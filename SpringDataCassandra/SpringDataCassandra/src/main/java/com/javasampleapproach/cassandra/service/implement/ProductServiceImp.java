package com.javasampleapproach.cassandra.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.repository.ProductCasRepository;
import com.javasampleapproach.cassandra.repository.ProductRepository;
import com.javasampleapproach.cassandra.service.BaseService;
import com.javasampleapproach.cassandra.service.ProductService;

@Service
public class ProductServiceImp extends BaseService implements ProductService {
	@Autowired
	ProductCasRepository productCasRepository;
	@Autowired
	ProductRepository productRepository;

	/*
	 * @Override public ProductCassandra getProductByIdCas(UUID id) {
	 * ProductCassandra p = null; for (ProductCassandra value :
	 * getAllProductsCas()) { if (value.getProduct_id().equals(id)) { p = value;
	 * } } return p; }
	 */
	/*
	 * @Override public Product getProductByIdFromJPA(UUID id) {
	 * 
	 * Product p = null; for (Product value : getAllProductsFromJPA()) { if
	 * (value.getProduct_id().equals(id)) { p = value; } } return p; }
	 */

	/*
	 * @Override public ProductCassandra updateProductCas(ProductCassandra pCas)
	 * { if ((productCasRepository.findById(pCas.getProduct_id()) == null)) {
	 * System.out.println(pCas.getProduct_id() + "not found in Database"); }
	 * return productCasRepository.save(pCas); }
	 * 
	 */

	@Override
	public void deleteProductById(UUID id) {
		productCasRepository.deleteById(id);
	}

	@Override
	public List<ProductCassandra> getAllProductsCas() {

		List<ProductCassandra> list = new ArrayList<>();
		productCasRepository.findAll().forEach(list::add);
		;

		return list;
	}

	@Override
	public List<Product> getAllProductsFromJPA() {

		List<Product> list = new ArrayList<>();
		productRepository.findAll().forEach(list::add);
		;
		return list;
	}

	@Override
	public ProductCassandra addProductCas(ProductCassandra pCas) {

		return productCasRepository.save(pCas);
	}

	@Override
	public Product addProductFromJPA(Product pJPA) {

		return productRepository.save(pJPA);
	}

	@Override
	public ProductCassandra getProductByIdCas(UUID id) {
		// cách 1
		/*
		 * ProductCassandra p=productCasRepository.findOneByProductId(id);
		 * if(p==null) { throw new NoDataFoundException("Product_id: " + id +
		 * "not found Database"); } return p;
		 */

		// cách 2
		ProductCassandra p2 = null;
		for (ProductCassandra value : getAllProductsCas()) {
			if (value.getProductId().equals(id)) {
				p2 = value;
			}
		}
		return p2;

	}

	/*
	 * @Override public void updateProductFromJPA(Product pJPA) { if
	 * ((productRepository.findById(pJPA.getProduct_id()) == null)) {
	 * System.out.println(pJPA.getProduct_id() + "not found in Database");
	 * }else{ productRepository.save(pJPA); }
	 * 
	 * }
	 * 
	 * @Override public Product getProductByIdFromJPA(UUID id) { Product
	 * p=productRepository.findOneByProduct_id(id); if(p==null) { throw new
	 * NoDataFoundException("Product_id: " + id + "not found Database"); }
	 * return p; }
	 */
	@Override
	public boolean checkProductInJPA(Product p) {
		boolean result = false;
		for (Product value : getAllProductsFromJPA()) {
			if(value.getProduct_id().equals(p.getProduct_id()))
			{
				result= true;
				break;
			}
		}
		return result;
	}

}
