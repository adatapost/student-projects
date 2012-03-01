<%@ include file="header.jsp"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/fmt-1_0-rt.tld" prefix="fmt" %>

<script type="text/javascript">
$.validator.setDefaults({
	submitHandler: function() {  }
});
 
    
</script>
 

<form method="get" action="employee">
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

<c:catch var="ex">
 <fmt:parseDate var="jdate" pattern="yyyy-MM-dd" >
   ${single.joinDate}
 </fmt:parseDate>
 <fmt:formatDate value="${jdate}" var="jd" pattern="d" />
 <fmt:formatDate value="${jdate}" var="jm" pattern="MMM" />
 <fmt:formatDate value="${jdate}" var="jy" pattern="yyyy" />
 
 <fmt:parseDate var="bdate" pattern="yyyy-MM-dd" >
   ${single.birthDate}
 </fmt:parseDate>
 <fmt:formatDate value="${bdate}" var="bd" pattern="d" />
 <fmt:formatDate value="${bdate}" var="bm" pattern="MMM" />
 <fmt:formatDate value="${bdate}" var="by" pattern="yyyy" />
</c:catch>
 
<div class="form">

 <form id="empForm" method="post" action="employee">

 <table>
    <tr>
    <td colspan="3"> <h1> Employee Master</h1> </td>
    </tr>

    
    
   <tr>
    <td> Employee Code </td>
     <td>
       <input type="text" name="empCode" value="${single.empCode}" size="6">
       </td>
    </tr>
 
    <tr>
      <td> Company Code </td>
      <td>
        <select name="cmpCode">
            <option value="">***Select***</option>
            <c:forEach var="c" items="${cmp}">
                <c:if test="${c.cmpCode==single.cmpCode}">
                   <option value="${c.cmpCode}"
                     selected='selected'>${c.cmpName}</option>
                </c:if>
               <c:if test="${c.cmpCode!=single.cmpCode}">
                   <option value="${c.cmpCode}">${c.cmpName}</option>
                </c:if>
            </c:forEach>

        </select>
       </td>
     </tr>
  
     <tr>
        <td> First Name </td>
        <td>
           <input type="text" name="firstName" value="${single.firstName}" size="30">
        </td>
     </tr>

     <tr>
       <td> Middle Name </td>
         <td>
           <input type="text" name="middleName" value="${single.middleName}" size="30">
         </td>
     </tr>


     <tr>
      <td> Last Name </td>
       <td>
         <input type="text" name="lastName" value="${single.lastName}" size="30">
       </td>
    </tr>

   <tr>
       <td>Address</td>
    <td> <textarea name="address"  cols="32">${single.address}</textarea></td>
   </tr>

 <tr>
    <td> City</td>
     <td>
       <input type="text" name="city" value="${single.city}" size="40">
       </td>
    </tr>

    <tr>
    <td> State</td>
     <td>
       <input type="text" name="state" value="${single.state}" size="40">
       </td>
    </tr>

     <tr>
      <td>Pincode</td>
       <td> <input type="text" name="pin" value="${single.pin}" size="10"/> </td>
   </tr>
       <tr>
      <td>Phone</td>
       <td> <input type="text" name="phone" value="${single.phone}" size="10"/> </td>
   </tr>
 
     <tr>
         <td> Designation Code</td>
        <td>
           <select name="dgCode">
               <option value="0">***Select***</option>
            <c:forEach var="c" items="${desig}">
                 <c:if test="${c.dgCode==single.dgCode}">
                   <option value="${c.dgCode}"
                     selected='selected'>${c.dgName}</option>
                </c:if>
               <c:if test="${c.dgCode!=single.dgCode}">
                   <option value="${c.dgCode}">${c.dgName}</option>
                </c:if>
            </c:forEach>

            </select>
      </td>
     </tr>


     <tr>
         <td> Depatement Code</td>
         <td>
          <select name="deptCode">
               <option value="0">***Select***</option>
               <c:forEach var="c" items="${dept}">
                 <c:if test="${c.deptCode==single.deptCode}">
                   <option value="${c.deptCode}"
                     selected='selected'>${c.deptName}</option>
                </c:if>
               <c:if test="${c.deptCode!=single.deptCode}">
                   <option value="${c.deptCode}">${c.deptName}</option>
                </c:if>
            </c:forEach>
            </select>
        </td>
      </tr>


     <tr>
        <td> Birth Date</td>
       <td>
        
            <select name="bday">
              <option value="0">day</option>
              
              <c:forEach var="d" begin="1" end="31">
                
                <c:choose>
                   <c:when test="${bd==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
                
                
              </c:forEach>
            </select>
            <select name="bmon">
              <option value="0">month</option>
              <c:forEach var="d" items="JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC">
                 <c:choose>
                   <c:when test="${bm.toUpperCase()==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
            <select name="byear">
              <option value="0">year</option>
              <c:forEach var="d" begin="1970" end="2031">
                 <c:choose>
                   <c:when test="${by==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
       </td>
     </tr>

   
     <tr>
        <td> join Date</td>
       <td>
            <select name="jday">
              <option value="0">day</option>
              <c:forEach var="d" begin="1" end="31">
                 <c:choose>
                   <c:when test="${jd==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
            <select name="jmon">
              <option value="0">month</option>
              <c:forEach var="d" items="JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC">
                <c:choose>
                   <c:when test="${jm.toUpperCase()==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
            <select name="jyear">
              <option value="0">year</option>
              <c:forEach var="d" begin="1970" end="2031">
                 <c:choose>
                   <c:when test="${jy==d}">  
                     <option selected='selected'>${d}</option>
                   </c:when>
                   <c:otherwise>
                      <option>${d}</option>
                   </c:otherwise>
                </c:choose>
              </c:forEach>
            </select>
       </td>
     </tr>


     <tr>
         <td> Bank Code</td>
         <td>
          <select name="bankCode">
               <option value="0">***Select***</option>
                <c:forEach var="c" items="${bank}">
                 <c:if test="${c.bankCode==single.bankCode}">
                   <option value="${c.bankCode}"
                     selected='selected'>${c.bankName}</option>
                </c:if>
               <c:if test="${c.bankCode!=single.bankCode}">
                   <option value="${c.bankCode}">${c.bankName}</option>
                </c:if>
            </c:forEach>
            </select>
         </td>
      </tr>


      <tr>
         <td> Bank Account No</td>
         <td><input type="text" name="bankAccount" value="${single.bankAccount}" size="30"> </td>
      </tr>  

  
      <tr>
         <td> Provident Fund No</td>
         <td><input type="text" name="pfNo" value="${single.pfNo}" size="30"> </td>
      </tr>  

      <tr>
         <td> Email_Id</td>
         <td><input type="text" name="email" value="${single.email}" size="30"> </td>
      </tr>  
      
      <tr> 
        <td colspan="3">
        </td>
      </tr>
  

     <tr>   
       <td colspan="3">

    <input type="submit" name="cmd" value="New" />
  
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
  <jsp:include page="employeelist.jsp"/>
</c:if>   

<%@ include file="footer.jsp"%>