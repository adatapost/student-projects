<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>Code</th> 
   <th>Name</th>
   <th>Select</th>
 </tr>
  
<c:forEach var="d" items="${dept}">
  <tr>
    <td>${d.deptCode}</td>
    <td>${d.deptName}</td>
    <td>
      <form method="post" action="departement">
        <input type="hidden" name="deptCode" value="${d.deptCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>