<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>Code</th> 
   <th>Name</th>
   <th>Address</th>
   <th>City</th>
   <th>State</th>
   <th>Pin</th>
   <th>Select</th>
 </tr>
  
<c:forEach var="d" items="${company}">
  <tr>
    <td>${d.cmpCode}</td>
    <td>${d.cmpName}</td>
    <td>${d.cmpAddress}</td>
    <td>${d.cmpCity}</td>
    <td>${d.cmpState}</td>
    <td>${d.cmpPin}</td>
    <td>
      <form method="post" action="companymaster">
        <input type="hidden" name="cmpCode" value="${d.cmpCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>