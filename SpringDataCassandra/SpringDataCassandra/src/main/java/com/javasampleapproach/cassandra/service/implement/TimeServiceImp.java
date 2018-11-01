package com.javasampleapproach.cassandra.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.cassandra.exception.NoDataFoundException;
import com.javasampleapproach.cassandra.jpamodel.Location;
import com.javasampleapproach.cassandra.jpamodel.Time;
import com.javasampleapproach.cassandra.model.LocationCassandra;
import com.javasampleapproach.cassandra.model.TimeCassandra;
import com.javasampleapproach.cassandra.repository.TimeCasRepository;
import com.javasampleapproach.cassandra.repository.TimeRepository;
import com.javasampleapproach.cassandra.service.BaseService;
import com.javasampleapproach.cassandra.service.TimeService;
import com.javasampleapproach.cassandra.utils.DateTimeUtil;

@Service
public class TimeServiceImp extends BaseService implements TimeService{

	@Autowired
	TimeCasRepository timeCasRepository;
	@Autowired
	TimeRepository timeRepository;
	@Override
	public List<TimeCassandra> getAllTimeCas() {
		
		List<TimeCassandra> list = new ArrayList<>();
		timeCasRepository.findAll().forEach(list::add);
		;

		return list;
	}
	@Override
	public List<Time> getAllTimeFromJPA() {
		
		List<Time> list = new ArrayList<>();
		timeRepository.findAll().forEach(list::add);
		;
		return list;
	}
	@Override
	public TimeCassandra getTimeByIdCas(UUID id) {
		
		TimeCassandra p2 = null;
		for (TimeCassandra value : getAllTimeCas()) {
			if (value.getTime_id().equals(id)) {
				p2 = value;
			}
		}
		return p2;
	}
	@Override
	public Time getTimeByIdFromJPA(UUID id) {
		
		Time p2 = null;
		for (Time value :getAllTimeFromJPA()) {
			if (value.getTime_id().equals(id)) {
				p2 = value;
			}
		}
		return p2;
	}
	@Override
	public TimeCassandra addTimeCas(TimeCassandra pCas) {
		
		return timeCasRepository.save(pCas);
	}
	@Override
	public Time addTimeFromJPA(Time pJPA) {
		
		return timeRepository.save(pJPA);
	}
	@Override
	public TimeCassandra updateTimeCas(TimeCassandra pCas,int year,int month,int quarter) {
		
		if(timeCasRepository.findById(pCas.getTime_id())==null)
		{
			throw new NoDataFoundException("Time ID '" + pCas.getTime_id() + "' not found in DB");
		}
		pCas.setMonth(month);
		pCas.setYear(year);
		pCas.setQuarter(quarter);
		
		pCas.setModifiedAt(DateTimeUtil.getCurrent());
		return timeCasRepository.save(pCas);
	}
	@Override
	public Time updateTimeFromJPA(Time pJPA) {
		
		return null;
	}
	@Override
	public void deleteTimeById(UUID id) {
		
		for (TimeCassandra value : getAllTimeCas()) {
			if (value.getTime_id().equals(id)) {
				timeCasRepository.delete(value);;
			}
		}
	}

}
