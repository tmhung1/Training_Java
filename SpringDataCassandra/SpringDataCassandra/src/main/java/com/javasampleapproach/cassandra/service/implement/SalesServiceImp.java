package com.javasampleapproach.cassandra.service.implement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Sales;
import com.javasampleapproach.cassandra.model.SalesCassandra;
import com.javasampleapproach.cassandra.repository.SalesCasRepository;
import com.javasampleapproach.cassandra.repository.SalesRepository;
import com.javasampleapproach.cassandra.service.BaseService;
import com.javasampleapproach.cassandra.service.SalesService;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@Service
public class SalesServiceImp extends BaseService implements SalesService {
	@Autowired
	SalesCasRepository salesCasRepository;
	@Autowired
	SalesRepository salesRepository;
	
	
	@Override
	public List<SalesCassandra> getAllSalesCas() {
		
		List<SalesCassandra> a = new ArrayList<SalesCassandra>();
		salesCasRepository.findAll().forEach(a::add);
		return a;
	}

	@Override
	public SalesCassandra getSalesByIdCas(UUID id) {
		
		return null;
	}

	@Override
	public Sales getSalesByIdFromJPA(UUID id) {
		
		return null;
	}

	@Override
	public SalesCassandra addSalesCas(SalesCassandra pCas) {
		
		return salesCasRepository.save(pCas);
	}

	@Override
	public Sales addSalesFromJPA(Sales pJPA) {
		
		return salesRepository.save(pJPA);
	}

	@Override
	public SalesCassandra updateSalesCas(SalesCassandra pCas) {
		
		return null;
	}

	@Override
	public Sales updateSalesFromJPA(Sales pJPA,int dollars) {
		
		/*if (salesRepository.findById(pJPA.getId()==null)) {
			throw new NoDataFoundException("Sales not found");
		}
		pJPA.setDollars(dollars);
		pJPA.setModified_at(new Timestamp(DateTimeUtil.getCurrent().getMillis()));
		return salesRepository.save(pJPA);
	}*/
		return null;
	}
	@Override
	public void deleteSalesById(UUID id) {
		
		
	}

	
}
