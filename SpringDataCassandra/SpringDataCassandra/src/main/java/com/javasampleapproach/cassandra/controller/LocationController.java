package com.javasampleapproach.cassandra.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.cassandra.dto.LocationDTO;
import com.javasampleapproach.cassandra.dto.ProductDTO;
import com.javasampleapproach.cassandra.exception.BadRequestException;
import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Location;
import com.javasampleapproach.cassandra.jpamodel.Product;
import com.javasampleapproach.cassandra.model.DBType;
import com.javasampleapproach.cassandra.model.LocationCassandra;
import com.javasampleapproach.cassandra.model.ProductCassandra;
import com.javasampleapproach.cassandra.service.LocationService;
import com.javasampleapproach.cassandra.service.implement.LocationServiceImp;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@RestController
public class LocationController {
	public static final Logger log = LoggerFactory.getLogger(LocationController.class);
	@Autowired
	LocationService locationService = new LocationServiceImp();

	public Location convertToJPAEntity(LocationDTO locationDTO) {
		Location l = null;
		if (locationDTO == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		l = new Location(locationDTO.getLocation_id(), locationDTO.getCountry(), locationDTO.getCity(),
				new Timestamp(locationDTO.getCreated_at().getMillis()),
				new Timestamp(locationDTO.getModified_at().getMillis()));
		return l;
	}
	public LocationCassandra convertToCasEntity(LocationDTO locationDTO) {
		LocationCassandra p = null;
		if (locationDTO == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		p = new LocationCassandra(locationDTO.getLocation_id(), locationDTO.getCountry(), locationDTO.getCity(),
				locationDTO.getCreated_at(), locationDTO.getModified_at());
		return p;
	}
	public LocationDTO convertToDTO(Object obj, DBType type) {
		LocationDTO locationDTO = null;
		if (obj == null) {
			throw new NoDataFoundException("Not found location");
		}
		if (type == DBType.JPA) {
			Location lc = (Location) obj;
			locationDTO = new LocationDTO(lc.getLocation_id(), lc.getCountry(), lc.getCity(),
					new DateTime(lc.getCreated_at()), new DateTime(lc.getModified_at()));

		} else if (type == DBType.CASSSANDRA) {
			LocationCassandra lr = (LocationCassandra) obj;
			locationDTO = new LocationDTO(lr.getLocation_id(), lr.getCountry(), lr.getCity(), lr.getCreatedAt(),
					lr.getModifiedAt());
		} else {
			throw new BadRequestException("No type");
		}
		return locationDTO;
	}
	@RequestMapping("/initLocation")
	public String initialProduct() {
		LocationCassandra p1 = new LocationCassandra(UUID.randomUUID(), "VietNam", "HaNoi", DateTimeUtil.getCurrent(),
				DateTimeUtil.getCurrent());
		LocationCassandra p2 = new LocationCassandra(UUID.randomUUID(), "ThaiLand", "Bangkok",
				DateTimeUtil.getCurrent(), DateTimeUtil.getCurrent());
		locationService.addLocationCas(p1);
		locationService.addLocationCas(p2);
		return "done";
	}
	// retrieve data from NoSQL Cassandra --insert PostgreSql
	@PostMapping(value = "/location/insertProIntoPostSQL")
	public ResponseEntity<List<Location>> insertProIntoPostgreSQL() {
		Location location = null;
		LocationDTO pTo = null;
		for (LocationCassandra cas : locationService.getAllLocationCas()) {
			pTo = convertToDTO(cas, DBType.CASSSANDRA);
			location = convertToJPAEntity(pTo);
			locationService.addLocationFromJPA(location);
		}
		return new ResponseEntity<List<Location>>(locationService.getAllLocationFromJPA(), HttpStatus.CREATED);
	}
	
}
