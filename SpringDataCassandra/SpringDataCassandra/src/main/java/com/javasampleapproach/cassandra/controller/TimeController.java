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


import com.javasampleapproach.cassandra.dto.TimeDTO;
import com.javasampleapproach.cassandra.exception.BadRequestException;
import com.javasampleapproach.cassandra.exception.NoDataFoundException;

import com.javasampleapproach.cassandra.jpamodel.Time;
import com.javasampleapproach.cassandra.model.DBType;

import com.javasampleapproach.cassandra.model.TimeCassandra;

import com.javasampleapproach.cassandra.service.TimeService;

import com.javasampleapproach.cassandra.service.implement.TimeServiceImp;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@RestController
public class TimeController {
	 public static final Logger log = LoggerFactory.getLogger(TimeController.class);
	@Autowired
	TimeService timeService = new TimeServiceImp();
	
	public Time convertToJPAEntity(TimeDTO timeDTO) {
		Time l = null;
		if (timeDTO == null) {
			throw new BadRequestException("Parameters not valid ");
		}
		l=new Time(timeDTO.getTime_id(),timeDTO.getMonth(),timeDTO.getQuarter(),timeDTO.getYear()
				,new Timestamp(timeDTO.getCreated_at().getMillis()),new Timestamp(timeDTO.getModified_at().getMillis()));

		return l;
	}

	public TimeCassandra convertToCasEntity(TimeDTO timeDTO) {
		TimeCassandra p = null;
		if (timeDTO == null) {
			throw new BadRequestException("Parameters not valid ");
		}

		p=new TimeCassandra(timeDTO.getTime_id(),timeDTO.getMonth(),timeDTO.getQuarter(),timeDTO.getYear(),
				timeDTO.getCreated_at(),timeDTO.getModified_at());

		return p;
	}

	public TimeDTO convertToDTO(Object obj, DBType type) {
		TimeDTO timeDTO = null;
		if (obj == null) {
			throw new NoDataFoundException("Not found location");
		}
		if (type == DBType.JPA) {
			Time lc = (Time) obj;
			timeDTO = new TimeDTO(lc.getTime_id(), lc.getMonth(), lc.getQuarter(),lc.getYear(),
					new DateTime(lc.getCreated_at()), new DateTime(lc.getModified_at()));

		} else if (type == DBType.CASSSANDRA) {
			TimeCassandra lr = (TimeCassandra) obj;
			timeDTO = new TimeDTO(lr.getTime_id(), lr.getMonth(), lr.getQuarter(),lr.getYear(), lr.getCreatedAt(),
					lr.getModifiedAt());
		} else {
			throw new BadRequestException("No type");
		}
		return timeDTO;
	}

	@RequestMapping("/initTime")
	public String initialProduct() {
		TimeCassandra p1 = new TimeCassandra(UUID.randomUUID(), 5,2,2018,DateTimeUtil.getCurrent(),
				DateTimeUtil.getCurrent());
		TimeCassandra p2 = new TimeCassandra(UUID.randomUUID(), 9,1,2017,
				DateTimeUtil.getCurrent(), DateTimeUtil.getCurrent());
		timeService.addTimeCas(p1);
		timeService.addTimeCas(p2);
		return "done";
	}

	// retrieve data from NoSQL Cassandra --insert PostgreSql
	@PostMapping(value = "/time/insertProIntoPostSQL")
	public ResponseEntity<List<Time>> insertProIntoPostgreSQL() {
		Time time = null;
		TimeDTO pTo = null;
		for (TimeCassandra cas : timeService.getAllTimeCas()) {
			pTo = convertToDTO(cas, DBType.CASSSANDRA);
			time = convertToJPAEntity(pTo);
			timeService.addTimeFromJPA(time);
		}
		return new ResponseEntity<List<Time>>(timeService.getAllTimeFromJPA(), HttpStatus.CREATED);
	}
}
