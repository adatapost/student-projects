<%@ include file="header.jsp"%>

<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<form method="get" action="bankmaster">
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

 <form method="post" action="bankmaster">
 
     <table>
    <tr>
    <td colspan="3"> <h1> Bank Master</h1> </td>
    </tr>
  
   <tr>
     <td> Bank Code </td>
     <td>
         <input type="text" name="bankCode" value="${single.bankCode}" size="6"/>
     </td>
    </tr>
   
    <tr>
     <td> Bank Name </td>
     <td>
         <input type="text" name="bankName" value="${single.bankName}" size="40"/>
     </td>
    </tr>
   
    
    <tr>
     <td> Bank Address </td>
     <td>
        <textarea name="bankAddress" cols="32">${single.bankAddress}</textarea>
     </td>
    </tr>
 
     <tr>
      <td> Bank City </td>
      <td>
         <input type="text" name="bankCity"  value="${single.bankCity}" size="40"/>
      </td>
     </tr>
     
      <tr>
       <td> Bank Phone </td>
       <td>
         <input type="text" name="bankPhone" value="${single.bankPhone}" size="40"/>
       </td>
     </tr>
  

       <tr>
       <td> Bank Branch </td>
       <td>
         <input type="text" name="bankBranch" value="${single.bankBranch}" size="40"/>
       </td>
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
  <jsp:include page="bankmasterlist.jsp"/>
</c:if>
  
<%@ include file="footer.jsp"%>