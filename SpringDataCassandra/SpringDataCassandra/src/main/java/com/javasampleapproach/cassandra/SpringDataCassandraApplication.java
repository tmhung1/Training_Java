package com.javasampleapproach.cassandra;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


import com.javasampleapproach.cassandra.service.implement.ProductServiceImp;

@SpringBootApplication
public class SpringDataCassandraApplication implements CommandLineRunner  {
	
//	@Autowired
//	ProductService productService;
//	@Autowired
//	LocationService locationService;
//	@Autowired
//	TimeService timeSerivce;
//	@Autowired
//	SalesService salesService;
	/*@Autowired
	CustomerRepository customerRepository;
	@Autowired 
	Jpacustomerrepository jpacustomerrepository;
	@Autowired
	ProductService productService=new ProductServiceImp();*/
	public static void main(String[] args) {
		SpringApplication.run(SpringDataCassandraApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
		// clearData();
		// saveData();
		// lookup();
		//saveCustomer();	
	}*/
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ltkh 2610");
		
		//saveproduct();
	}
	/*public void saveproduct()
	{
		String text = "2015-05-28 12:45:59";
	    Timestamp timestamp = Timestamp.valueOf(text);
		DateTime d1=new DateTime(timestamp.getTime());
		DateTime d2=new DateTime(timestamp.getTime());
		
		
		
		SalesCassandra productCassandra1=new TimeCassandra(f6bb694b-c59b-4e32-845c-43385b15fac2,1,1,1996,d1,d2);
		TimeCassandra productCassandra2=new TimeCassandra(f6bb694b-c59b-4e32-845c-43385b15fac2,2,2,1998,d1,d2);
		TimeCassandra productCassandra3=new TimeCassandra(UUID.randomUUID(),3,3,2000,d1,d2);
		
		
		timeSerivce.addTimeCas(productCassandra1);
		timeSerivce.addTimeCas(productCassandra2);
		timeSerivce.addTimeCas(productCassandra3);
		
		
		
	}*/
	/*public ProductCassandra convertToCasEntity(ProductDTO pTo) {
		ProductCassandra p=null;
		if (pTo == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		DateTime d1=new DateTime(p.getCreatedAt());
		DateTime d2=new DateTime(p.getModifiedAt());
		p = new ProductCassandra(pTo.getProduct_id(),pTo.getItem(),pTo.getPclass(),pTo.getInventory(),
				d1,d2);
		
		return p;
	}*/
/*	public void saveCustomer()
	{
		List<Customer>listCassCustomer=customerRepository.findAll();
		System.out.println("size: "+listCassCustomer.size());
		List<com.javasampleapproach.cassandra.jpamodel.Customer>listJpaCustomer=new ArrayList<>();
		com.javasampleapproach.cassandra.jpamodel.Customer customerJPA=new com.javasampleapproach.cassandra.jpamodel.Customer();
		for(Customer cus:listCassCustomer)
		{
			customerJPA.setId(cus.getId());
			customerJPA.setFirstname(cus.getFirstname());
			customerJPA.setLastname(cus.getLastname());
			customerJPA.setAge(cus.getAge());
			jpacustomerrepository.save(customerJPA);
		}
	}
	public void clearData() {
		customerRepository.deleteAll();
	}
	public void saveData() {
		System.out.println("===================Save Customers to Cassandra===================");
		Customer cust_1 = new Customer(1, "Peter", "Smith", 20);
		Customer cust_2 = new Customer(2, "Mary", "Taylor", 25);
		Customer cust_3 = new Customer(3, "Peter", "Brown", 30);
		Customer cust_4 = new Customer(4, "Lauren", "Taylor", 20);
		Customer cust_5 = new Customer(5, "Lauren", "Flores", 45);
		Customer cust_6 = new Customer(6, "Peter", "Williams", 20);
	
		// save customers to ElasticSearch
		customerRepository.save(cust_1);
		customerRepository.save(cust_2);
		customerRepository.save(cust_3);
		customerRepository.save(cust_4);
		customerRepository.save(cust_5);
		customerRepository.save(cust_6);
		
		
		ProductCassandra pC=new ProductCassandra();
		LocationCassandra lC=new LocationCassandra();
		TimeCassandra tC=new TimeCassandra();
	}
	public void lookup() {
		System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
		List<Customer> peters = customerRepository.findByFirstname("Peter");
		peters.forEach(System.out::println);

		System.out.println("===================Lookup Customers from Cassandra by Age===================");
		List<Customer> custsAgeGreaterThan25 = customerRepository.findCustomerHasAgeGreaterThan(25);
		custsAgeGreaterThan25.forEach(System.out::println);
	}

	*/
	
}
