/**
 * 
 */
package com.project.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ravi-1979
 *
 */
@XmlRootElement
public class Volunteer {
	
	@Override
	public String toString() {
		return "Volunteer [name=" + name + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress
				+ ", facebookURL=" + facebookURL + ", Location=" + Location + ", eventType=" + eventType + "]";
	}
	@FormParam("name")
	private String name;
	
	@FormParam("phone-number")
	private String phoneNumber;
	
	@FormParam("email-address")
	private String emailAddress;
	
	@FormParam("facebook-url")
	private String facebookURL;
	
	@FormParam("location")
	private String Location;
	
	@FormParam("event-type")
	private String eventType;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFacebookURL() {
		return facebookURL;
	}
	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
}
