<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Flight Form</title>
		<!-- reference to style sheet -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-flight-style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Flight Schedule Management</h2>
			</div>
		</div>
		<div id="container">
			<h3>Save Flight</h3>
			<form:form action="saveFlight" modelAttribute="flight" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>Flight Number:</label></td>
							<td><form:input path="flightNumber" /></td>
						</tr>
						<tr>
							<td><label>Departure:</label></td>
							<td>
								<form:select path="departure.id" class="dropdown">
									<form:option value="-1" label="--- Select ---" />
									<form:options items="${airports}" itemValue="id" itemLabel="name" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td><label>Arrival:</label></td>
							<td>
								<form:select path="arrival.id" class="dropdown">
									<form:option value="-1" label="--- Select ---" />
									<form:options items="${airports}" itemValue="id" itemLabel="name" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td><label>Departure Time:</label></td>
							<td><form:input path="departureTime" /></td>
						</tr>
						<tr>
							<td><label>Arrival Time:</label></td>
							<td><form:input path="arrivalTime" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" name="Save" class="save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/flight/list">Back to Schedule</a>
			</p>
		</div>
	</body>
</html>