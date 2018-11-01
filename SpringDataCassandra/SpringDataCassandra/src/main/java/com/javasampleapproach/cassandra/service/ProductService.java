package com.javasampleapproach.cassandra.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.ProductCassandra;

	

public interface ProductService {
	public List<ProductCassandra>getAllProductsCas();
	public List<Product>getAllProductsFromJPA();
	
	public ProductCassandra addProductCas(ProductCassandra pCas);
	public Product addProductFromJPA(Product pJPA);
	
	
	
	//public Product getProductByIdFromJPA(UUID id);
	public ProductCassandra getProductByIdCas(UUID id);
	public void deleteProductById(UUID id);
	
	
	//check exists product in casssandra
	public boolean checkProductInJPA(Product p);

	/*public void updateProductFromJPA(Product pJPA);
	*/
	
	/*public ProductCassandra updateProductCas(ProductCassandra pCas);
	
	
	*/
	
}
