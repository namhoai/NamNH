package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  private String driverClassName = "com.mysql.jdbc.Driver";
  private String connectionUrl = "jdbc:mysql://localhost:3306/qlpk_namnh";
  private String dbUser = "root";
  private String dbPwd = "";

  private static ConnectionFactory connectionFactory = null;

  private ConnectionFactory() throws ClassNotFoundException {

    Class.forName(driverClassName);

  }

  /**
   * Open Connection.
   * 
   * @return connection.
   * @throws SQLException define Exception.
   */
  public Connection getConnection() throws SQLException {
    Connection conn = null;
    conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
    return conn;
  }

  /**
   * Get Instance this. Singleton Design pattern.
   * 
   * @return instance.
   * @throws ClassNotFoundException
   */
  public static ConnectionFactory getInstance() throws ClassNotFoundException {
    if (connectionFactory == null) {
      connectionFactory = new ConnectionFactory();
    }
    return connectionFactory;
  }
}
