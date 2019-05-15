<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Flight List</title>
		<!-- reference our style sheet -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Flight Schedule</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<!-- add html table -->
				<table>
					<tr>
						<th>Flight Number</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>Scheduled Departure Time</th>
						<th>Scheduled Arrival Time</th>
					</tr>
					<!-- loop over and print flights info -->
					<c:forEach var="schedule" items="${flights}">
						<tr>
							<td> ${schedule.flightNumber} </td>
							<td> ${schedule.departure.name} </td>
							<td> ${schedule.arrival.name} </td>
							<td> ${schedule.departureTime} </td>
							<td> ${schedule.arrivalTime} </td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>