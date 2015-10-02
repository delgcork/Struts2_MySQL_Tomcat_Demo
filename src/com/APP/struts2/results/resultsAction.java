/* 
*Struts2_MySQL_Demo
*Copyright 2015 Todd Brochu
*/
package com.APP.struts2.results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Todd Brochu
 */
public class resultsAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;

	/**
     *Passes the 'success' string back to struts.xml
     *in order to call Input.jsp
     *@param none
     *@return none
     */
    public String execute() {
        return "success";
    }
}
