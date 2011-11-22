import java.sql.*;


public class JDBC
{
  public static void main(String[] args)
  {
    String url = "jdbc:postgresql://localhost/prog_obiektDB";
	  try
    {
	        Class.forName("org.postgresql.Driver");
	        Connection db = DriverManager.getConnection(url, "jbelcik", "kingjames23");

	        Statement st = db.createStatement();
          st.executeUpdate("UPDATE narokw SET Kwota = Kwota - 100 WHERE rok <= 1990;");
	        ResultSet rs = st.executeQuery("SELECT * FROM narokw WHERE rok <= 1990;");
	        while (rs.next())
          {    
            System.out.println("Nazwisko:");
            System.out.println(rs.getString(2));
            System.out.println("Rok:");
            System.out.println(rs.getInt   (3));
            System.out.println("Kwota:");
            System.out.println(rs.getFloat (4));
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
