<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>EmpCode</th> 
   <th>CmpCode</th> 
   <th>FirstName</th> 
   <th>MiddleName</th>
   <th>LastEmpCode</th>   
   <th>Address</th> 
   <th>City</th> 
   
   
   <th>Select</th>
 </tr>
  
<c:forEach var="em" items="${emp}">
  <tr>
    <td>${em.empCode}</td>
    <td>${em.cmpCode}</td>
    <td>${em.firstName}</td>
    <td>${em.middleName}</td>
    <td>${em.lastName}</td>
    <td>${em.address}</td>
    <td>${em.city}</td>
      
    <td>
      <form method="post" action="employee" >
        <input type="hidden" name="empCode" value="${em.empCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete" onclick="return doDel()" />
      </form>
    </td>
   </tr>
</c:forEach>
</table>