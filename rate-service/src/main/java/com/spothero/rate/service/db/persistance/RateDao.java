package com.spothero.rate.service.db.persistance;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.spothero.rate.service.model.Rate;

public interface RateDao {
	
	
	public void insertRate(Rate rate) throws IOException;
		
	public void updateRate(Rate rate) throws IOException;
	
	public void deleteRate(Rate rate) throws IOException;
	
	public List<Double> findRatesByDateRange(Date initialDate, Date finalDate);

}
