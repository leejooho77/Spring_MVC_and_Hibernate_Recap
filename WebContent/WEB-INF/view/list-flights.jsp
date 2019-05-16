<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
				<h2>Flight Schedule Management</h2>
			</div>
		</div>
		<div id="container">
			<h3>Flight Schedule</h3>
			<!--  add a search box -->
            <form:form action="searchFlight" method="GET" style="margin-left: 5%">
                Search by Departure: <input type="text" name="departureName" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<div id="content">
				<!-- add html table -->
				<table>
					<tr>
						<th>Flight Number</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>Scheduled Departure Time</th>
						<th>Scheduled Arrival Time</th>
						<th>Update</th>
					</tr>
					<!-- loop over and print flights info -->
					<c:forEach var="flight" items="${flights}">
						<!-- construct an "update" link with flight id -->
						<c:url var="updateLink" value="/flight/showFormForUpdate">
							<c:param name="flightId" value="${flight.id}"></c:param>
						</c:url>
						<!-- construct an "delete" link with flight id -->
						<c:url var="deleteLink" value="/flight/deleteFlight">
							<c:param name="flightId" value="${flight.id}"></c:param>
						</c:url>
						<tr>
							<td> ${flight.flightNumber} </td>
							<td> ${flight.departure.name} </td>
							<td> ${flight.arrival.name} </td>
							<td> ${flight.departureTime} </td>
							<td> ${flight.arrivalTime} </td>
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a> |
								<a href="${deleteLink}"
								   onclick="if (!(confirm('Are you sure you want to delete this flight?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<!-- Add new button for adding new flight -->
				<input type="button" value="Add Flight" 
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
				/>
			</div>
		</div>
	</body>
</html>