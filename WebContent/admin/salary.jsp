<%@ include file="header.jsp"%>

   <div class="form">

 <form method="post" action="Salary">

  <table>
    <tr>
    <td colspan="3"> <h1> Salary Master</h1> </td>
    </tr>
  
   <tr>
    <td> salary Id </td>
     <td>
       <input type="text" name="salaryId" size="6">
       
     </td>
    </tr>
  
    <tr>
    <td> Profile Code </td>
     <td>
       <input type="text" name="profileCode" size="6">
       
     </td>
    </tr>
  
     <tr>
    <td> salary Date </td>
     <td>
       <input type="text" name="salaryDate" size="30">
       
     </td>
    </tr>
  
  <tr>
    <td> Da </td>
     <td>
       <input type="text" name="da" size="30">
       
     </td>
    </tr>

   <tr>
    <td> Hra </td>
     <td>
       <input type="text" name="hra" size="30">
       
     </td>
    </tr>


   <tr>
    <td> Ma </td>
     <td>
       <input type="text" name="ma" size="30">
       
     </td>
    </tr>

    <tr>
      <td> Ptax</td>
       <td>
       <input type="text" name="ptax" size="30">
       
      </td>
      </tr>

    <tr>
    <td> Leave Deduction </td>
     <td>
       <input type="text" name="leaveDedu" size="30">
       
     </td>
    </tr>

   <tr>
    <td> Overtime </td>
     <td>
       <input type="text" name="overtime" size="30">
       
     </td>
    </tr>

     <tr>
    <td> other Allowance </td>
     <td>
       <input type="text" name="otherAllow" size="30">
       
     </td>
    </tr>

   <tr>
    <td> other  Deduction </td>
     <td>
       <input type="text" name="otherDedu" size="30">
       
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
   

<%@ include file="footer.jsp"%>