<%@ include file="header.jsp"%>

<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<form method="get" action="companymaster">
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

 <form method="post" action="companymaster">

  <table>
    <tr>
    <td colspan="3"> <h1> Company Master</h1> </td>
    </tr>

    <tr>
    <td>Company Code </td>
     <td>
       <input type="text" name="cmpCode" size="6">
       <input type="submit" name="cmd" value="Search"/>  
     </td>
    </tr>
     
   
     <tr>
        <td>Company Name</td>
        <td> <input type="text" name="cmpName" size="40"/> </td>
     </tr>
 
    <tr>
        <td> Company Address</td>
        <td> <textarea name="cmpAddress" cols="32"> </textarea></td>
    </tr>
  
  
    <tr>
       <td>Company City</td>
       <td> <input type="text" name="cmpCity" size="40"/> </td>
    </tr>
 
    <tr>
       <td>Company State</td>
       <td> <input type="text" name="cmpState" size="40"/> </td>
   </tr>
 
  
    <tr>
       <td>Company Pincode</td>
       <td> <input type="text" name="cmpPin" size="20"/> </td>
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
  <jsp:include page="companymasterlist.jsp"/>
</c:if>  
<%@ include file="footer.jsp"%>