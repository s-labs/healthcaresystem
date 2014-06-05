<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Villages :</h2>
				<table>
					<thead>
						<tr>
							<th>S.No &nbsp &nbsp</th>
							
							<th>Code &nbsp</th>
						
							<th>Name &nbsp </th>
							
							<th>Details &nbsp </th>
							
						</tr>
					</thead>
					<tbody>

						<c:forEach var="village" items="${mandal.villages}"
							varStatus="status">
							<tr>
								<td>${status.count}</td>
							
								<td>${village.code }</td>
							
								<td>${village.name }</td>
								<td><a href="village/${village.code}">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>