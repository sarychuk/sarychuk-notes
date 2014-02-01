package com.example.counter;

import java.util.ArrayList;
import java.util.Date;


public class CounterModel {

	
	protected ArrayList<Date> counterTimestamp;
	protected String counterName;
	protected Date counterTime;
	protected Integer counterCount;
	
	
	/**
	 *  Constructor of Counter
	 */
	public CounterModel(String counterName) {
		super();
		this.counterName = counterName;
		this.counterTime = new Date();
		this.counterTimestamp = new ArrayList<Date>();
	}
	
	/**
	 * The array of timestamps of the Counter
	 */
	public ArrayList<Date> getCounterTimestamp(){
		return counterTimestamp;
	}
	
	/**
	 * @return Name of the Counter
	 */
	public String getCounterName() {
		return counterName;
	}
	
	/**
	 * Sets the current name of the counter
	 * @param counterName
	 */
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	
	/**
	 * @return Current count
	 */
	public Integer getCounterCount() {
		return this.counterCount = counterTimestamp.size();
	}
	
	/**
	 *   Increments count + date info to the Counter's ArrayList
	 */
	public void incrementCounter() {
		this.counterTime = new Date();
		System.out.println(this.counterTime);
		this.counterTimestamp.add(counterTime);
		System.out.println(this.counterTimestamp.size());
	}
	
	/**
	 * Clears the Counter
	 */
	public void resetCounter() {
		this.counterTimestamp.clear();
	}
	
	
}
