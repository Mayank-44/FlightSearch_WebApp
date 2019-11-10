<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Search Flights</title>

</head>

<body>

	<div style="margin-right: 50px; margin-left: 50px; margin-top: 20px;">
		<div class="alert alert-dark" role="alert" style="background: #3498db">
			<div style="display: table; margin: 0 auto">
				<strong>Flight Search Utility</strong>
			</div>
		</div>
	</div>

	<form action="input" method="post">
		<div>

			<div class="alert alert-primary" role="alert"
				style="margin-right: 50px; margin-left: 50px; padding-left: 10px; padding-right: 10px; padding-top: 10px; padding-bottom: 10px">
				<table class="table">
					<tr>

						<td><strong>Departure Location</strong></td>
						<td><input class="form-control" type="text" name="dep"
							placeholder="City or airport" required> </td>

					</tr>
					<tr>
						<td><strong>Arrival Location</strong></td>
						<td><input class="form-control" type="text" name="arr"
							placeholder="City or airport" required></td>
					</tr>
					<tr>
						<td><strong>Flight Date</strong></td>
						<td><input class="form-control" type="date" name="flightdate"
							required></td>
					</tr>
					<tr>
						<td><strong>Travel class</strong></td>
						<td><input type="radio" name="flightclass" value="E" checked>&nbspEconomic<span
							style="margin-right: 10px;"></span> <input type="radio"
							name="flightclass" value="B">&nbsp Business</td>
					</tr>
					<tr>
						<td><strong>Sort By</strong></td>
						<td><input type="radio" name="output" value="Fare" checked>&nbspFare&nbsp<span
							style="margin-right: 45px;"></span> <input type="radio"
							name="output" value="FareAndDate">&nbsp Fare And Duration</td>

					</tr>

				</table>
			</div>
		</div>
		<div style="padding-top: 20px;">
			<div>
				<input type="submit" style="display: table; margin: 0 auto"
					class="btn btn-dark btn-lg " value="Show Flights">
			</div>
		</div>

	</form>
</body>
</html>

