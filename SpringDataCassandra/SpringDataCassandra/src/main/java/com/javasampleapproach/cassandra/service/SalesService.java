package com.javasampleapproach.cassandra.service;

import java.util.List;
import java.util.UUID;

import com.javasampleapproach.cassandra.jpamodel.Sales;
import com.javasampleapproach.cassandra.jpamodel.Time;
import com.javasampleapproach.cassandra.model.SalesCassandra;
import com.javasampleapproach.cassandra.model.TimeCassandra;

public interface SalesService {
	
	public List<SalesCassandra>getAllSalesCas();
	
	public SalesCassandra getSalesByIdCas(UUID id);
	public Sales getSalesByIdFromJPA(UUID id);
	
	public SalesCassandra addSalesCas(SalesCassandra pCas);
	public Sales addSalesFromJPA(Sales pJPA);
	
	public SalesCassandra updateSalesCas(SalesCassandra pCas);
	public Sales updateSalesFromJPA(Sales pJPA,int dollars);
	
	public void deleteSalesById(UUID id);
}
