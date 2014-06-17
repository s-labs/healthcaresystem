<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Villages :</h2>
				<table id="sample-table-1" class="table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>S.No &nbsp &nbsp</th>
							
							<th>Code &nbsp</th>
						
							<th>Name &nbsp </th>
							
							<th>Details &nbsp </th>
							<th>Delete </th>
							
						</tr>
					</thead>
					<tbody>

						<c:forEach var="district" items="${state.districts}"
							varStatus="status">
							<tr>
								<td>${status.count}</td>
							
								<td>${district.code }</td>
							
								<td>${district.name }</td>
								<td><a href="district/${district.code}">Detail</a></td>
								<td><a href="deletedistrict/${district.code}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>