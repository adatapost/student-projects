<%@ include file="header.jsp"%>

  <div class="form">
 <form method="post" action="loan">

 <table style="title">
   <tr>
     <td> <h1> Loan Master</h1> </td>

   
     <tr>
        <td> Loan Code</td>
        <td><input type="text" name="loanCode" size="6" value="${single.loanCode}"> </td>
      </tr>

     <tr>
         <td> Profile Code</td>
        <td><input type="text" name="profileCode" size="6" value="${single.profileCode}"> </td>
      </tr>
  
     <tr>
         <td> Loan Date</td>
        <td><input type="text" name="loanDate" size="30" value="${single.loanDate}"> </td>
     </tr>

      <tr>
         <td> Loan Amount</td>
        <td><input type="text" name="loanAmount" size="30" value="${single.loanAmount}"> </td>
     </tr>
    
   
      <tr>
         <td> Loan Installment</td>
        <td><input type="text" name="InstAmount" size="30" value="${single.InstAmount}"> </td>
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