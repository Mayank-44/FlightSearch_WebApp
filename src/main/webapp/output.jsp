<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.nagarro.model.Flight"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Available Flights</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div style="background: white">
		<%

			String uname = (String) request.getSession().getAttribute("uname");
			if (uname == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		%>

		<div style="margin-right: 20px; margin-left: 20px; margin-top: 20px;">
			<div class="alert alert-dark" role="alert">
				<div style="display: table; margin: 0 auto">
					<strong>Flight Search Results</strong>
				</div>
			</div>
		</div>


		<div>
			<div
				style="margin-right: 20px; margin-left: 20px; background: #e8f8f5">
				<table class="table">
					<thead>
						<tr style="background: #58d68d">
							<th scope="col">S.No</th>
							<th scope="col" style="padding-left: 20px;">Flight No.</th>
							<th scope="col" style="padding-left: 10px;">Departure
								Location</th>
							<th scope="col" style="padding-left: 0px;">Arrival Location</th>
							<th scope="col">Flight Time</th>
							<th scope="col">Flight Duration</th>
							<th scope="col" style="padding-left: 20px;">Fare</th>
							<th scope="col">Seat Availability</th>
							<th scope="col">Class</th>
						</tr>
					</thead>
					<tbody>

						<c:set var="i" value="${0}" />
						<c:forEach items="${flights}" var="flight">
							<c:set var="i" value="${i+1}" />

							<tr>

								<td align="center"><c:out value=" ${i}" /></td>
								<td align="center"><c:out value=" ${flight.flightNo}" /></td>
								<td align="center"><c:out value=" ${flight.depLoc}" /></td>
								<td align="center"><c:out value=" ${flight.arrLoc}" /></td>
								<td align="center"><c:out value=" ${flight.flightTime}" /></td>
								<td align="center"><c:out value=" ${flight.flightDur}" /></td>
								<td align="center"><c:out value=" ${flight.fare}" /></td>
								<td align="center"><c:out value=" ${flight.seatAva}" /></td>
								<td align="center"><c:out value=" ${flight.flightClass}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div style="padding-top: 20px;">
			<div>
				<form action="display.jsp" method="post">
					<input type="submit" style="display: table; margin: 0 auto"
						class="btn btn-dark btn-lg " value="SEARCH MORE">
				</form>
			</div>
		</div>

		<div style="margin-top: 50px;"></div>
	</div>
</body>
</html>