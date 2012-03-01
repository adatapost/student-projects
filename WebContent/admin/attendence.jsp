<%@ include file="header.jsp"%>

   <div class="form">

 <form method="post" action="attendece">

  <table>
    <tr>
    <td colspan="3"> <h1> Attendence Master</h1> </td>
    </tr>
  
  <tr>
    <td> Attendence Code </td>
     <td>
       <input type="text" name="attCode" size="6">
       
     </td>
    </tr>
     

      <tr>
    <td> Profile Code </td>
     <td>
       <input type="text" name="profileCode" size="6">
       
     </td>
    </tr>
  
  <tr>
    <td> Attendence Date </td>
     <td>
       <input type="text" name="attDate" size="30">
       
     </td>
    </tr>
 
    <tr>
    <td> Overtime Hours </td>
     <td>
       <input type="text" name="overtimeHours" size="8">
       
     </td>
    </tr>
  
     <tr>
    <td> Present</td>
     <td>
       <input type="text" name="present" size="8">
       
     </td>
    </tr>
  
   <tr>
    <td> Absent</td>
     <td>
       <input type="text" name="absent" size="8">
       
     </td>
    </tr>
   
   <tr>
    <td> Weak_off</td>
     <td>
       <input type="text" name="weak_off" size="8">
       
     </td>
    </tr>

     <tr>
    <td> Leave</td>
     <td>
       <input type="text" name="leave" size="8">
       
     </td>
    </tr>
    
    <tr>
    <td> Holiday</td>
     <td>
       <input type="text" name="holiday" size="8">
       
     </td>
    </tr>
    
    
     <tr>
    <td> Halfday</td>
     <td>
       <input type="text" name="halfday" size="8">
       
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