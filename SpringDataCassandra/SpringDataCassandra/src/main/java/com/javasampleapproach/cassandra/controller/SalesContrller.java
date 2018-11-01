package com.javasampleapproach.cassandra.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.cassandra.model.LocationCassandra;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.model.SalesCassandra;
import com.javasampleapproach.cassandra.model.TimeCassandra;
import com.javasampleapproach.cassandra.service.SalesService;
import com.javasampleapproach.cassandra.service.implement.SalesServiceImp;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@RestController 
public class SalesContrller {
	 public static final Logger log = LoggerFactory.getLogger(SalesContrller.class);
	@Autowired
	SalesService salesService=new SalesServiceImp();
	
	@RequestMapping("/initialsales")
	public String process() {
		// sample data
		TimeCassandra t = new TimeCassandra(UUID.randomUUID(), 12, 4, 2018, DateTimeUtil.getCurrent(), DateTimeUtil.getCurrent());
		ProductCassandra p = new ProductCassandra(UUID.randomUUID(), 261, "9a1Class", "Inventory261", DateTimeUtil.getCurrent(), DateTimeUtil.getCurrent());
		LocationCassandra l = new LocationCassandra(UUID.randomUUID(), "England", "London", DateTimeUtil.getCurrent(), DateTimeUtil.getCurrent());

		SalesCassandra s = new SalesCassandra();
		s.setTime_id(t.getTime_id());
		s.setProduct_id(p.getProductId());
		s.setLocation_id(l.getLocation_id());
		s.setCreatedAt(DateTimeUtil.getCurrent());
		s.setModifiedAt(DateTimeUtil.getCurrent());
		s.setDollars(2000);
		
	salesService.addSalesCas(s);
		return "Done";
	}
}
