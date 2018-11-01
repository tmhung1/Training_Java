package com.javasampleapproach.cassandra.service;

import java.util.List;
import java.util.UUID;

import com.javasampleapproach.cassandra.jpamodel.Location;
import com.javasampleapproach.cassandra.jpamodel.Time;
import com.javasampleapproach.cassandra.model.LocationCassandra;
import com.javasampleapproach.cassandra.model.TimeCassandra;

public interface TimeService {
	
	public List<TimeCassandra>getAllTimeCas();
	public List<Time>getAllTimeFromJPA();
	public TimeCassandra getTimeByIdCas(UUID id);
	public Time getTimeByIdFromJPA(UUID id);
	
	public TimeCassandra addTimeCas(TimeCassandra pCas);
	public Time addTimeFromJPA(Time pJPA);
	
	public TimeCassandra updateTimeCas(TimeCassandra pCas,int year,int month,int quarter);
	public Time updateTimeFromJPA(Time pJPA);
	
	public void deleteTimeById(UUID id);
}
