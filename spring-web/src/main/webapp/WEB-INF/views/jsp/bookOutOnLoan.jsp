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
				<form:form method="POST" action="bookOutOnLoan/search" modelAttribute="bookOutOnLoan">
					<tr>
						<td>Id del bookOutOnLoan</td>
						<td><form:input path="idBookBorrowing"/></td>
					</tr>
					<tr><td><input type="submit" class="btn" value="search"/></td></tr>
				</form:form>
			</table>
			<form:form method="POST" action="bookOutOnLoan/create">
				<input type="submit" class="btn" value="Create new bookOutOnLoan"/>
			</form:form>
		</div>
	</div>
</div>

</body>
</html>