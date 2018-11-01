package com.javasampleapproach.cassandra.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.javasampleapproach.cassandra.dto.ProductDTO;
import com.javasampleapproach.cassandra.exception.BadRequestException;
import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.DBType;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.service.ProductService;
import com.javasampleapproach.cassandra.service.implement.ProductServiceImp;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@RestController
public class ProductController {
	public static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService = new ProductServiceImp();

	// productDT0->>JPA
	public Product convertToJPAEntity(ProductDTO productDTO) {
		if (productDTO == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		Product p = new Product(productDTO.getProduct_id(), productDTO.getItem(), productDTO.getPclass(),
				productDTO.getInventory(), new Timestamp(productDTO.getCreated_at().getMillis()),
				new Timestamp(productDTO.getModified_at().getMillis()));
		return p;
	}

	// productDT0->>Cassandra
	public ProductCassandra convertToCasEntity(ProductDTO pTo) {
		ProductCassandra p = null;
		if (pTo == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		DateTime d1 = new DateTime(p.getCreatedAt());
		DateTime d2 = new DateTime(p.getModifiedAt());
		p = new ProductCassandra(pTo.getProduct_id(), pTo.getItem(), pTo.getPclass(), pTo.getInventory(), d1, d2);

		return p;
	}

	// Jpa,Cassandra->>productDTO
	public ProductDTO convertToDTO(Object obj, DBType type) {
		ProductDTO productDTO = null;
		if (obj == null) {
			throw new NoDataFoundException("Not found product");
		}
		if (type == DBType.JPA) {
			Product product = (Product) obj;
			productDTO = new ProductDTO(product.getProduct_id(), product.getItem(), product.getPclass(),
					product.getInventory(), new DateTime(product.getCreated_at()),
					new DateTime(product.getModified_at()));

		} else if (type == DBType.CASSSANDRA) {
			ProductCassandra pCas = (ProductCassandra) obj;
			productDTO = new ProductDTO(pCas.getProductId(), pCas.getItem(), pCas.getsClass(), pCas.getInventory(),
					pCas.getCreatedAt(), pCas.getModifiedAt());
		} else {
			throw new BadRequestException("No type");
		}
		return productDTO;
	}

	// add product demo for Cassandra
	@RequestMapping("/init")
	public String initialProduct() {
		ProductCassandra p1 = new ProductCassandra(UUID.randomUUID(), 10, "class1", "dc2", DateTimeUtil.getCurrent(),
				DateTimeUtil.getCurrent());
		ProductCassandra p2 = new ProductCassandra(UUID.randomUUID(), 122, "class12", "dc3", DateTimeUtil.getCurrent(),
				DateTimeUtil.getCurrent());
		productService.addProductCas(p1);
		productService.addProductCas(p2);
		return "done";
	}

	// retrieve data from NoSQL Cassandra --insert PostgreSql
	@PostMapping(value = "/product/insertProIntoPostSQL")
	public ResponseEntity<List<Product>> insertProIntoPostgreSQL() {
		Product product = null;
		ProductDTO pTo = null;
		for (ProductCassandra cas : productService.getAllProductsCas()) {
			pTo = convertToDTO(cas, DBType.CASSSANDRA);
			product = convertToJPAEntity(pTo);
			if (productService.checkProductInJPA(product)) {
				throw new BadRequestException("No type");
			} else {
				productService.addProductFromJPA(product);
			}
		}
		return new ResponseEntity<List<Product>>(productService.getAllProductsFromJPA(), HttpStatus.CREATED);
	}

	// GET- all product by Cassandra
	@GetMapping(value = "/product/getAllProCas", headers = "Accept=application/json")
	public ResponseEntity<List<ProductDTO>> getListProductCas() {
		List<ProductDTO> listDTO = new ArrayList<>();
		ProductDTO pTo = null;
		for (ProductCassandra p : productService.getAllProductsCas()) {
			pTo = convertToDTO(p, DBType.CASSSANDRA);

			pTo.setCreated_at(pTo.getCreated_at().withZone(DateTimeZone.UTC));
			listDTO.add(pTo);
		}

		return new ResponseEntity<List<ProductDTO>>(listDTO, HttpStatus.OK);
	}

	// GET- all product by PostgreSQL
	@GetMapping(value = "/product/getAllProJPA", headers = "Accept=application/json")
	public ResponseEntity<List<ProductDTO>> getListProductJPA() {
		List<ProductDTO> listDTO = new ArrayList<>();
		ProductDTO pTo = null;
		for (Product p : productService.getAllProductsFromJPA()) {
			pTo = convertToDTO(p, DBType.JPA);

			listDTO.add(pTo);
		}
		return new ResponseEntity<List<ProductDTO>>(listDTO, HttpStatus.OK);
	}
			
	// add product for Cassandra
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<ProductDTO> addProductCas(@RequestParam int item, @RequestParam String pclass,
			@RequestParam String inventory)

	{
		ProductCassandra p = new ProductCassandra(UUID.randomUUID(), item, pclass, inventory, DateTimeUtil.getCurrent(),
				DateTimeUtil.getCurrent());
		ProductCassandra p1 = productService.addProductCas(p);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "http://localhost:8000/product?id=" + p1.getProductId());
		return new ResponseEntity<ProductDTO>(convertToDTO(p1, DBType.CASSSANDRA), headers, HttpStatus.CREATED);

	}

	// update product for Cassandra
	@PutMapping(value = "/updateProduct", headers = "Accept=application/json")
	public ResponseEntity<ProductDTO> updateProductCas(@RequestParam String product_id, @RequestParam int item,
			@RequestParam String pclass, @RequestParam String inventory) {
		ProductCassandra p = productService.getProductByIdCas(UUID.fromString(product_id));
		if (p == null) {
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		}
		productService.addProductCas(p);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "http://localhost:8000/product?id=" + p.getProductId());

		return new ResponseEntity<ProductDTO>(convertToDTO(p, DBType.CASSSANDRA), headers, HttpStatus.OK);
	}

	// delete product Cassandra
	@DeleteMapping(value = "/product/delete/{productId}")
	public ResponseEntity<ProductDTO> deleteProductByProductId(@PathVariable String product_id) {
		ProductCassandra p = productService.getProductByIdCas(UUID.fromString(product_id));
		if (p == null) {
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		} else {
			productService.deleteProductById(UUID.fromString(product_id));
		}
		return new ResponseEntity<ProductDTO>(HttpStatus.NO_CONTENT);
	}
	
	// find product by id--Cassandra
	@GetMapping(value = "/product/getProductCas/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getProductByID(@PathVariable("product_id") String id) {
		ProductDTO pDTO = null;
		ProductCassandra p = productService.getProductByIdCas(UUID.fromString(id));
		if (p == null) {
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		} else {
			pDTO = convertToDTO(p, DBType.CASSSANDRA);
		}
		return new ResponseEntity<ProductDTO>(pDTO, HttpStatus.OK);
	}

	
}
