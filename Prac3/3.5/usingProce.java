import java.sql.*;

public class usingProcedure1 {
  
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost/s2b130050131066";


   
   static final String USER = "postgres";
   static final String PASS = "abcd";
   
   public static void main(String[] args) {
   Connection conn = null;
   CallableStatement cStmt = null;
   try{
     
      Class.forName(JDBC_DRIVER);

      
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
     
      
        System.out.println("Enrollno: 130050131066");
                  cStmt = conn.prepareCall("{call student1()}");
              cStmt.execute();
              
              System.out.println("Selected Data is:");
              System.out.println();
              
              ResultSet rs = cStmt.getResultSet();
              System.out.print("id:");
              System.out.print("Name:");
              System.out.print("Branch:");
           
              while (rs.next())
              {
                System.out.println();
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.println();
              } 
           cStmt.close();
   }catch(SQLException se){
     
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(cStmt!=null)
            conn.close();
             cStmt.close();
             
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("program completed");
}
}

