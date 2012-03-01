<%@ include file="header.jsp"%>

  <div class="form">
 <form method="post" action="Loan Transaction">

 <table style="title">
   <tr>
     <td> <h1> Loan Transaction Master</h1> </td>

  
     <tr>
        <td> Loan Transaction Code</td>
        <td><input type="text" name="loanTranCode" size="6"> </td>
      </tr>
   
       <tr>
        <td> Loan Code</td>
        <td><input type="text" name="loanCode" size="6"> </td>
      </tr>

      <tr>
        <td> Transaction Date</td>
        <td><input type="text" name="tranDate" size="30"> </td>
      </tr>
  
      <tr>
        <td> Transaction Amount</td>
        <td><input type="text" name="tranAmount" size="30" > </td>
      </tr>

     <tr>
        <td> Narration</td>
        <td> <textarea name="narration" cols="32"> </textarea></td>
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