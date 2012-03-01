<%@ include file="header.jsp"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<form method="get" action="designation">
  <div class="nav">
     <input type="submit" 
            name="nav" 
            value="New"
            class=<c:if test="${param.nav!='List'}">active</c:if>
            />
     <input type="submit" 
            name="nav" 
            value="List"
            class=<c:if test="${param.nav=='List'}">active</c:if>
     />
  </div>
</form>

 
<c:if test="${param.nav!='List'}">
 <div class="form">
  <form method="post" action="designation">
  <table style="title">
   <tr>
     <td> <h1> Designation</h1> </td>
    <tr>
       <td> Designation Code</td>
      <td><input type="text" name="dgCode" size="6"  value="${single.dgCode}" > </td>
    </tr>
   
    <tr>
       <td> Designation Name</td>
       <td><input type="text" name="dgName" size="40" value="${single.dgName}"> </td>
    </tr>
    
     <tr> 
        <td colspan="3">
        </td>
      </tr>
     <tr>   
       <td colspan="3">

    <input type="submit" name="cmd" value="New"/>
  
    <input type="submit" name="cmd" value="Save"/>
   
    <input type="submit" name="cmd" value="Update"/>
     
    <input type="submit" name="cmd" value="Delete"/>
      
    </td>
    </tr>
   </table>
    
   </form>
 </div>
</c:if>
    
<c:if test="${param.nav=='List'}">
  <jsp:include page="designationlist.jsp"/>
</c:if>

    <%@ include file="footer.jsp"%>