<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<table class="table">
 <tr>
   <th>Code</th> 
   <th>Name</th>
   <th>Address</th>
   <th>City</th>
   <th>Phone</th>
   <th>Branch</th>
   <th>Select</th>
 </tr>
  
<c:forEach var="d" items="${bank}">
  <tr>
    <td>${d.bankCode}</td>
    <td>${d.bankName}</td>
    <td>${d.bankAddress}</td>
    <td>${d.bankCity}</td>
    <td>${d.bankPhone}</td>
    <td>${d.bankBranch}</td>
    <td>
      <form method="post" action="bankmaster">
        <input type="hidden" name="bankCode" value="${d.bankCode}"/>
        <input type="submit" name="cmd" value="Select"/>
        <input type="submit" name="cmd" value="Delete"/>
      </form>
    </td>
   </tr>
</c:forEach>
</table>