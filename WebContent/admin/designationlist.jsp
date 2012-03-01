<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table 
   class="table" 
   cellpadding="3" 
   cellspacing="0">
 <tr>
   <th>Code</th> 
   <th>Name</th>
   <th>Select</th>
 </tr>
  
<c:forEach var="d" items="${desig}">
  <tr>
    <td>${d.dgCode}</td>
    <td>${d.dgName}</td>
    <td>
      <form method="post" action="designation">
        <input type="hidden" name="dgCode" value="${d.dgCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>