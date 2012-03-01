<%@ include file="header.jsp"%>

<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<form method="get" action="Experience">
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

 <form method="post" action="Experience">

 <table>
    <tr>
    <td colspan="3"> <h1> Experience Master</h1> </td>
    </tr>

    <tr>
    <td>  Experience Id </td>
     <td>
       <input type="text" name=" expid" value="${single.expid}" size="6">
       </td>
    </tr>
     
   <tr>
      <td> Employee Code </td>
        <td>
           <input type="text" name="empCode" value="${single.empCode}" size="6">
       </td>
    </tr>
     
  
  <tr>
    <td> Company Name </td>
     <td>
       <input type="text" name="cmpname" value="${single.cmpname}" size="40">
       </td>
    </tr>
     
  
   <tr>
    <td> From Date </td>
     <td>
       <input type="text" name="fromdate" value="${single.fromdate}" size="30">
       </td>
    </tr>


    <tr>
    <td> To Date </td>
     <td>
       <input type="text" name="todate" value="${single.todate}" size="30">
       </td>
    </tr>


     <tr>
    <td> Designation </td>
     <td>
       <input type="text" name="desig" value="${single.desig}" size="30">
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
  <jsp:include page="experiencelist.jsp"/>
</c:if>
  
<%@ include file="footer.jsp"%>