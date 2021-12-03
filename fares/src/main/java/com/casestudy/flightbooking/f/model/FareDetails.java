package com.casestudy.flightbooking.f.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fares")
public class FareDetails
{ 
	@Indexed(unique=true)
    
	private String fid;
	private String economy;
	private String premium_economy;
	private String business;
	private String first_class;
	private int Date;
	private String route;
	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the economy
	 */
	public String getEconomy() {
		return economy;
	}
	/**
	 * @param economy the economy to set
	 */
	public void setEconomy(String economy) {
		this.economy = economy;
	}
	/**
	 * @return the premium_economy
	 */
	public String getPremium_economy() {
		return premium_economy;
	}
	/**
	 * @param premium_economy the premium_economy to set
	 */
	public void setPremium_economy(String premium_economy) {
		this.premium_economy = premium_economy;
	}
	/**
	 * @return the business
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * @param business the business to set
	 */
	public void setBusiness(String business) {
		this.business = business;
	}
	/**
	 * @return the first_class
	 */
	public String getFirst_class() {
		return first_class;
	}
	/**
	 * @param first_class the first_class to set
	 */
	public void setFirst_class(String first_class) {
		this.first_class = first_class;
	}
	/**
	 * @return the date
	 */
	public int getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		Date = date;
	}
}
	
	
	   
		