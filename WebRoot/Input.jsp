<!-- 
Struts2_MySQL_Demo
Copyright 2015 Todd Brochu
 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Input</title>
	<style type="text/css">
	.errorDiv {
		color: red;
	}
	</style>
</head>
<body>
	<h2>Enter an item</h2>
	<div class="errorDiv">
		<s:actionerror />
	</div>
	<s:form action="enterItem" namespace="/" method="post">
    	<s:textfield name="name" id="name" label="OS" size="50" autofocus="true" />
    	<s:textfield name="version" id="version" label="version" size="20" />
    	<s:textarea name="notes" id="notes" label="notes" rows="5" cols="50"
    		cssStyle="overflow: none; resize: none;" maxlength="255"/>
    	<s:submit method="execute" key="label.submit" align="left" />
	</s:form>
</body>
</html>