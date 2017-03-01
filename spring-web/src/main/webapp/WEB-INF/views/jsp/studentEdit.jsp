<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<spring:url value="/static/css/app.css" var="coreCss" />
<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url
	value="/webjars/jquery-ui-themes/1.11.4/south-street/jquery-ui.min.css"
	var="jqueryCssTheme" />
<spring:url value="/webjars/toastr/2.1.2/build/toastr.min.css"
	var="toastrCss" />

<link href="${coreCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${jqueryCssTheme}" rel="stylesheet" />
<link href="${toastrCss}" rel="stylesheet" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Project Name</a>
		</div>
	</div>
</nav>

<div class="container">
	<div class="row">
		<div class="col-md-4">
					<table>
						<form:form  action="save" modelAttribute="student">
						<tr>
							<td><form:label path="idStudent" >Id: </form:label></td>
							<td><form:input path="idStudent" readonly="true"/></td>
						</tr>
						<tr>
							<td><form:label path="firstName" >Nombre: </form:label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><form:label path="lastName" >Apellido: </form:label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><form:label path="studentAdress" >Dirección: </form:label></td>
							<td><form:input path="studentAdress"/></td>
						</tr>
						<tr>
							<td><form:label path="phoneNumber" >Telefono: </form:label></td>
							<td><form:input path="phoneNumber"/></td>
						</tr>
						<tr>
							<td><form:label path="emailAdress" >Correo: </form:label></td>
							<td><form:input path="emailAdress"/></td>
						</tr>
						<tr><td><input type="submit" class="btn" value="save"/></td></tr>
						</form:form>
						<form:form action="delete" modelAttribute="student">
							<form:hidden path="idStudent" readonly="true"/>
							<form:hidden path="firstName"/>
							<form:hidden path="lastName"/>
							<tr><td><input type="submit" class="btn" value="delete"/></td>
								<td><a style="btn" href="/spring-web/student">regresar</a></td>
							</tr>
						</form:form>
					</table>
		</div>
	</div>
</div>

</body>
</html>