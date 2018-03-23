package com.spothero.rate.service.db.persistance;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.spothero.rate.service.db.config.JsonDBConfig;
import com.spothero.rate.service.model.Rate;

/**
 * 
 * @author carlosdlr
 * 
 * Class that allow access to the data model
 * in the service
 *
 */
public class RateDaoImpl implements RateDao{
    
	private JsonDBConfig jsonDBConfig;
	
	@Override
	public void insertRate(Rate rate) throws IOException {
		jsonDBConfig = JsonDBConfig.getInstance();
		jsonDBConfig.setup();
		jsonDBConfig.getJsonDBTemplate().insert(rate);
		
	}

	@Override
	public void updateRate(Rate rate) throws IOException{
		jsonDBConfig = JsonDBConfig.getInstance();
		jsonDBConfig.setup();
		jsonDBConfig.getJsonDBTemplate().upsert(rate);
	}

	@Override
	public void deleteRate(Rate rate) throws IOException{
		jsonDBConfig = JsonDBConfig.getInstance();
		jsonDBConfig.setup();
		jsonDBConfig.getJsonDBTemplate().remove(rate, Rate.class);
	}

	@Override
	public List<Double> findRatesByDateRange(Date initialDate, Date finalDate) {
		return null;
		
	}

}
