package com.javasampleapproach.cassandra.service;

import java.util.List;
import java.util.UUID;

import com.javasampleapproach.cassandra.jpamodel.Location;
import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.LocationCassandra;


public interface LocationService {
	public List<LocationCassandra>getAllLocationCas();
	public List<Location>getAllLocationFromJPA();
	public LocationCassandra getlocationByIdCas(UUID id);
	public Location getlocationByIdFromJPA(UUID id);
	
	public LocationCassandra addLocationCas(LocationCassandra pCas);
	public Location addLocationFromJPA(Location pJPA);
	
	public LocationCassandra updateLocationCas(LocationCassandra pCas,String country,String city);
	public Location updateLocationFromJPA(Location pJPA);
	
	public void deleteLocationtById(UUID id);
}
