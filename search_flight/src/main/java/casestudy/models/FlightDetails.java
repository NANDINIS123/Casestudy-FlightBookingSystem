package casestudy.models;


import org.springframework.data.mongodb.core.mapping.Document;

@Document("Flight_Details")
public class FlightDetails {
String name,route,date,fid;

public String getFid() {
	return fid;
}

public void setFid(String fid) {
	this.fid = fid;
}

public FlightDetails(String name, String route, String date, String fid) {
	super();
	this.name = name;
	this.route = route;
	this.date = date;
	this.fid = fid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getRoute() {
	return route;
}

public void setRoute(String route) {
	this.route = route;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public FlightDetails() {
	// TODO Auto-generated constructor stub
}
public String sorry() {
	return "unable to find the flight on given route";
}
}
