<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HPQC Updated file upload</title>
</head>
<body>
	<form:form action="upload_updated_file" method="get">
		<table>
			<tr>
				<td><label for="fileName">Updated File Name : </label></td>
				<td><input type="text" name="fileName"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Updated File Upload" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>