<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>ExpId</th> 
   <th>EmpCode</th>
   <th>CmpName</th>
   <th>FromDate</th>
   <th>ToDate</th>
   <th>Desig</th>
   <th>Select</th>
 </tr>
  
<c:forEach var="e" items="${Exper}">
  <tr>
    <td>${e.expid}</td>
    <td>${e.empcode}</td>
    <td>${e.cmpcode}</td>
    <td>${e.fromdate}</td>
    <td>${e.todate}</td>
    <td>${e.desig}</td>
    <td>
      <form method="post" action="Experience">
        <input type="hidden" name="expid" value="${e.expid}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>