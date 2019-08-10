import java.sql.*;

class DBLoader
{
    static ResultSet executeQuery(String sqlstatement)
    {
        try
        {
          ///        ##CODE          ////
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded successfully");
    
            Connection conn =
            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "system");
            System.out.println("connection built");
    
            Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                                                         ResultSet.CONCUR_UPDATABLE );
            System.out.println("statement created");
    
            ResultSet rs = stmt.executeQuery(sqlstatement);
            System.out.println("ResultSet Created");
            
            return rs;
           //// ## CODE Ends Here ///////
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
           return null;
        }
    }
}