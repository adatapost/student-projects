package in.safal;
public class Test
{
   public static void main(String []args)  
    {
    try{
          
    in.safal.EmployeeMaster a=new in.safal.EmployeeMaster();
    a.setFirstName("A");
    a.setCmpCode("A001");
    a.setBankCode("SBI02");
    a.setDgCode(25);
    a.setDeptCode(1);
     a.addEmp();         
     
         
      }catch(Exception ex){
         System.err.println(ex);
      }
     }
}