package SimpleDB;

import java.sql.*;

public class ConnectToServer {

  public static void main(String[] args) {

    // Register the Mckoi JDBC Driver
    try {
      Class.forName("com.mckoi.JDBCDriver").newInstance();
    }
    catch (Exception e) {
      System.out.println(
        "Unable to register the JDBC Driver.\n" +
        "Make sure the JDBC driver is in the\n" +
        "classpath.\n");
      System.exit(1);
    }

    // This URL specifies we are connecting with a local database
    // within the file system.  './db.conf' is the path of the
    // configuration file of the database to embed.
    String url = "jdbc:mckoi://localhost/";

    // The username / password to connect under.
    String username = "panji";
    String password = "12345";

    // Make a connection with the local database.
    Connection connection;
    try {
  		connection = DriverManager.getConnection(url, username, password);
  		//buat statement
  		Statement stmt = connection.createStatement();
  		//lakukan proses data query/update
  		ResultSet rs = stmt.executeQuery("select * from products");
  		//cetak hasil query/update
  		while(rs.next())
  		{
  			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
  		}
    }
    catch (SQLException e) {
      System.out.println(
        "Unable to make a connection to the database.\n" +
        "The reason: " + e.getMessage());
      System.exit(1);
      return;
    }

    try {
    
      // .... Use 'connection' to talk to database ....
    	
      // Close the connection when finished,
      connection.close();

    }
    catch (SQLException e) {
      System.out.println(
        "An error occured\n" +
        "The SQLException message is: " + e.getMessage());
      return;
    }

  }

}