package com.spothero.rate.service.model;

import java.util.List;
import java.util.Optional;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

/**
 * 
 * @author carlosdlr
 * domain representation for rate data
 * 
 */
@Document(collection = "rates", schemaVersion= "1.0")
public class Rate {
    
	@Id
	private int id;
	private List<String> days;
	private List<String> times;
	private Optional<Double> price = Optional.empty();

	public Rate(){
	}

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public Optional<Double> getPrice() {
		return price;
	}

	public void setPrice(Optional<Double> price) {
		this.price = price;
	}

}
