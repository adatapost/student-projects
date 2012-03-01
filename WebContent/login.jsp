<%@ include file="header.jsp"%>


<form method="post" action="login">

<div class="form">
  <table>
     <tr>
     <td colspan="3"> <h1> Login </h1> </td>
     </tr>
  
    <tr> 
     <td> Username </td>
     <td>
          <input type="text" name="username" size="20"/>
     </td>
     </tr>

     <tr>
     <td> Password </td>
     <td>
           <input type="password" name="password" size="20"/>
     </td>
      </tr>
      
      <tr>
        <td colspan="3">
  
            <input type="submit" name="cmd" value="Login" />
         </td>
       </tr>
      </table>

     </div>
   </form>


<%@ include file="footer.jsp"%>