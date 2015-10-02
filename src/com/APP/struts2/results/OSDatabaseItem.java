/* 
*Struts2_MySQL_Demo
*Copyright 2015 Todd Brochu
*/
package com.APP.struts2.results;

/**
 * @author Todd Brochu
 */
public class OSDatabaseItem {
	private String name = null;
	private String version = null;
	private String notes = null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		if (notes != null) {
			this.notes = notes;
		}
	}
}
