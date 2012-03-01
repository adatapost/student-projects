<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>ProfileCode</th> 
   <th>EmpCode</th>
   <th>DgCode</th>
   <th>DeptCode</th>
   <th>StartDate</th>
   <th>EndDate</th>
   <th>BasicSalary</th> 
   <th>Select</th>
 </tr>
  
<c:forEach var="p" items="${EmpProfile}">
  <tr>
    <td>${p.profileCode}</td>
    <td>${p.empCode}</td>
    <td>${p.dgCode}</td>
    <td>${p.startDate}</td>
    <td>${p.endDate}</td>
    <td>${p.basicSalary}</td>
    <td>
      <form method="post" action="empprofile">
        <input type="hidden" name="profileCode" value="${p.profileCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>