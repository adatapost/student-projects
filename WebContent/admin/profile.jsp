<%@ include file="header.jsp"%>

<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<form method="get" action="empprofile">
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

 <form method="post" action="Employee Profile">

 <table>
    <tr>
    <td colspan="3"> <h1> Employee Profile Master</h1> </td>
    </tr>

  <tr>
    <td> Profile Code </td>
     <td>
       <input type="text" name="profileCode" value="${single.profileCode}" size="6">
       </td>
    </tr>
     
    <tr>
    <td> Employee Code </td>
     <td>
       <input type="text" name="empCode" value="${single.empCode}" size="6">
       </td>
    </tr>
     
    <tr>
    <td> Designation Code </td>
     <td>
       <input type="text" name="dgCode" value="${single.dgCode}" size="6">
       </td>
    </tr>
     
    <tr>
    <td> Departement Code </td>
     <td>
       <input type="text" name="deptCode" value="${single.deptCode}" size="6">
       </td>
    </tr>
 
   <tr>
    <td> Start Date </td>
     <td>
       <input type="text" name="startDate" value="${single.startDate}" size="8">
       </td>
    </tr>

    <tr>
    <td> End Date </td>
     <td>
       <input type="text" name="endDate" value="${single.endDate}" size="8">
       </td>
    </tr>
    
    <tr>
    <td> Basic Salary </td>
     <td>
       <input type="text" name="basicSalary" value="${single.basicSalary}" size="20">
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

 
  
<%@ include file="footer.jsp"%>