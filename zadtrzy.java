import java.sql.*;


public class zadtrzy
{
  public static void main(String[] args)
  {
    String url = "jdbc:postgresql://localhost/prog_obiektDB";
	  try
    {
	        Class.forName("org.postgresql.Driver");
	        Connection db = DriverManager.getConnection(url, "jbelcik", "");

	        Statement st = db.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM narokw;");
	        
          int x;          

          while (rs.next())
          {    

            System.out.println("Nazwisko:");
            System.out.println(rs.getString(2));
            System.out.println("Rok:");
            System.out.println(rs.getInt   (3));
            System.out.println("Kwota:");
            System.out.println(rs.getFloat (4));
            
            x = rs.getInt(3);
            if (x > 2000) x += 1000;

            System.out.println("Dodatkowo:");
            System.out.println(x);
            System.out.print("\n"); 
          }
          rs.close();
          st.close();

    }
    catch (SQLException e)
    {
	    System.err.println("Wyjatek z zapytania SQL: " + e.getMessage());
	    e.printStackTrace(System.err);
    }
    catch (ClassNotFoundException e)
    {
	    System.err.println("Wyjatek przy ladowaniu klas: " + e.getMessage());
	    e.printStackTrace(System.err);
    }
  }
}
