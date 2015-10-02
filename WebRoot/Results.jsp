<!-- 
Struts2_MySQL_Demo
Copyright 2015 Todd Brochu
 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List</title>
	<style type="text/css">
	.errorDiv {
		color: red;
	}
	</style>
</head>
 
<body>
	<h2>Operating Systems</h2>
    <div class="errorDiv">
		<s:actionerror />
	</div>
	<table border = "1">
		<tr>
			<th>OS Name</th><th>Version</th><th>Notes</th>
		</tr>
		<s:iterator value="arrlist">
			<tr>
				<td><s:property value="%{name}"/></td>
				<td><s:property value="%{version}"/></td>
				<td><s:property value="%{notes}"/></td>
			</tr>
		</s:iterator>
	</table>
	<br/>
    <s:form action="goToInput" namespace="/" method="post">
    	<s:submit method="execute" key="label.goToInput" autofocus="true"
    			  align="left" title="Go back to add another item"/>
    </s:form>
</body>
</html>