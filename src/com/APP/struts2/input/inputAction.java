/* 
*Struts2_MySQL_Demo
*Copyright 2015 Todd Brochu
*/
package com.APP.struts2.input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.APP.struts2.results.OSDatabaseItem;
import com.opensymphony.xwork2.ActionSupport;

/**
 *methods for the Input page
 *@author Todd Brochu
 */
public class inputAction  extends ActionSupport{
	private String name;
    private String version;
    private String notes;
    private static final long serialVersionUID = 1L;
	public ArrayList <OSDatabaseItem> arrlist = new ArrayList<OSDatabaseItem>();

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
		this.notes = notes;
	}
	
	public ArrayList<OSDatabaseItem> getArrlist() {
		return arrlist;
	}
	
	public void setArrlist(ArrayList<OSDatabaseItem> arrlist) {
		this.arrlist = arrlist;
	}
	
	/**
     *Inserts the input field data to the database
     *Reads all tuples from the database
     *Passes the return string back to struts.xml
     *@param none
     *@return ret:string
     */
    @Override
	public String execute() throws ClassNotFoundException, SQLException{
		String query;
		Statement stmt;
		String ret = "error";
		Connection conn = null;
		OSDatabaseItem db_item;
		
		//the name and version fields are required
		if (this.name.equals("") || this.version.equals("")) {
        	addActionError(getText("error.input"));
            return "error";
        }
		
		try {
			String URL = "jdbc:mysql://localhost:3306/myDB";
			Class.forName("com.mysql.jdbc.Driver");	
			conn = DriverManager.getConnection(URL, "todd-VirtualBox", "");
			
			//an addition to the database
			query = "INSERT INTO Operating_Systems(OS, version, notes) " + "VALUES('"+this.name+"', '"+this.version+"', '"+this.notes+"')";
			stmt = conn.createStatement();
			int val = stmt.executeUpdate(query);
			if (val == 0) return ret;
			
			//a read of the database
			query = "SELECT * FROM Operating_Systems ORDER BY OS, version";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				db_item = new OSDatabaseItem();
				db_item.setName(rs.getString(1));
				db_item.setVersion(rs.getString(2));
				db_item.setNotes(rs.getString(3));
				arrlist.add(db_item);
			}
			
			conn.close();
			ret = "success";
		} catch (Exception excep){
			System.out.println(excep);
			addActionError(getText("error.db"));
			ret = "error";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception excep) {
					System.out.println(excep);
				}
			}
		}
        return ret;
    }
}
