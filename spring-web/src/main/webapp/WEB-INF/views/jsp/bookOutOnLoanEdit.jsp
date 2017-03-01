<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
						<form:form  action="save" modelAttribute="bookOutOnLoan">
						<tr>
							<td><form:input path="idBookBorrowing" readonly="true"/></td>
						</tr>
						<tr>
							<td><form:label path="dateIssued" >Fecha de prestamo: </form:label></td>
							<td>
								<td><form:label path="dateIssued" >Fecha de prestamo: </form:label></td>
								<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateIssued}" pattern="dd/MM/yyyy"/>
								<input type="text" name="dateIssued" value="${fmtDate}"/>
							</td>
						</tr>
						<tr>
							<td><form:label path="dateDueForReturn" >Fecha limite de devolución: </form:label></td>
							<td>
								<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateDueForReturn}" pattern="dd/MM/yyyy"/>
								<input type="text" name="dateDueForReturn" value="${fmtDate}"/>
							</td>
						</tr>
						<tr>
							<td><form:label path="dateReturned" >Fecha de devolución: </form:label></td>
							<td>
								<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateReturned}" pattern="dd/MM/yyyy"/>
								<input type="text" name="dateReturned" value="${fmtDate}"/>
							</td>
						</tr>
						<tr>
							<td><form:label path="amountOfFine" >Multa: </form:label></td>
							<td><form:input path="amountOfFine"/></td>
						</tr>
						<tr>
							<td><form:label path="student.idStudent" >Id del estudiante: </form:label></td>
							<td><form:input path="student.idStudent"/></td>
						</tr>
						<tr>
							<td><form:label path="book.isbn" >Isbn: </form:label></td>
							<td><form:input path="book.isbn"/></td>
						</tr>
						
						<tr><td><input type="submit" class="btn" value="save"/></td></tr>
						</form:form>
						<form:form action="delete" modelAttribute="bookOutOnLoan">
							<form:hidden path="idBookBorrowing" readonly="true"/>
							<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateIssued}" pattern="dd/MM/yyyy"/>
							<input type="text" name="dateIssued" value="${fmtDate}" style="display: none;"/>
							<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateDueForReturn}" pattern="dd/MM/yyyy"/>
							<input type="text" name="dateDueForReturn" value="${fmtDate}" style="display: none;"/>
							<fmt:formatDate var="fmtDate" value="${bookOutOnLoan.dateReturned}" pattern="dd/MM/yyyy"/>
							<input type="text" name="dateReturned" value="${fmtDate}" style="display: none;"/>
							<form:hidden path="amountOfFine"/>
							<form:hidden path="student.idStudent"/>
							<form:hidden path="book.isbn"/>
							<tr><td><input type="submit" class="btn" value="delete"/></td>
								<td><a style="btn" href="/spring-web/bookOutOnLoan">regresar</a></td>
							</tr>
						</form:form>
					</table>
		</div>
	</div>
</div>

</body>
</html>