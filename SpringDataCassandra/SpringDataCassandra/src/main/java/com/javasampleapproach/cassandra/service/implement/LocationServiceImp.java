package com.javasampleapproach.cassandra.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Location;
import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.LocationCassandra;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.repository.LocationCasRepoistory;
import com.javasampleapproach.cassandra.repository.LocationRepository;
import com.javasampleapproach.cassandra.service.BaseService;
import com.javasampleapproach.cassandra.service.LocationService;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;
@Service
public class LocationServiceImp extends BaseService implements LocationService{
	@Autowired
	 LocationCasRepoistory locationCasRepoistory;
	@Autowired
	LocationRepository locationRepoistory;
	@Override
	public List<LocationCassandra> getAllLocationCas() {
		
		List<LocationCassandra> list = new ArrayList<>();
		locationCasRepoistory.findAll().forEach(list::add);
		;

		return list;
	}

	@Override
	public List<Location> getAllLocationFromJPA() {
		
		List<Location> list = new ArrayList<>();
		locationRepoistory.findAll().forEach(list::add);
		;
		return list;
	}

	@Override
	public LocationCassandra getlocationByIdCas(UUID id) {
		
		LocationCassandra p2 = null;
		for (LocationCassandra value : getAllLocationCas()) {
			if (value.getLocation_id().equals(id)) {
				p2 = value;
			}
		}
		return p2;
	}

	@Override
	public Location getlocationByIdFromJPA(UUID id) {
		
		Location p2 = null;
		for (Location value : getAllLocationFromJPA()) {
			if (value.getLocation_id().equals(id)) {
				p2 = value;
			}
		}
		return p2;
	}

	@Override
	public LocationCassandra addLocationCas(LocationCassandra pCas) {
		
		return locationCasRepoistory.save(pCas);
	}

	@Override
	public Location addLocationFromJPA(Location pJPA) {
		
		return locationRepoistory.save(pJPA);
	}

	@Override
	public LocationCassandra updateLocationCas(LocationCassandra pCas,String country,String city) {
		if(locationCasRepoistory.findById(pCas.getLocation_id())==null)
		{
			throw new NoDataFoundException("Location ID '" + pCas.getLocation_id() + "' not found in DB");
		}
		pCas.setCountry(country);
		pCas.setCity(city);
		pCas.setModifiedAt(DateTimeUtil.getCurrent());
		return locationCasRepoistory.save(pCas);
	}
	//same as update Cassandra
	@Override
	public Location updateLocationFromJPA(Location pJPA) {
		
		return null;
	}

	@Override
	public void deleteLocationtById(UUID id) {
		for (LocationCassandra value : getAllLocationCas()) {
			if (value.getLocation_id().equals(id)) {
				locationCasRepoistory.delete(value);;
			}
		}
		
	}
	

}
