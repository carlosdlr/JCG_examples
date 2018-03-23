package com.spothero.rate.service;

import java.util.Date;
import java.util.List;

public interface RateService {
	
	public List<Double> findRatesByDateRange(Date initialDate, Date finalDate);

}
