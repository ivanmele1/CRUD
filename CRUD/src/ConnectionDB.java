import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	   
	    private static Connection conexion  = null;
	    private String  servidor    = "";
	    String db = "PruebaCRUD"; // Nombre de BD.
 		int port = 3306;
 		String host = "localhost";
		String url  = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", host, port, db);
		String user = "root";
		String password = "0110";
	 
	    //CONSTRUCTOR
	    //Recibe el nombre de la base de datos
	    ConnectionDB(String baseDatos){
	        this.servidor=this.url+baseDatos;
	 
	        //Registrar el driver
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("ERROR AL REGISTRAR EL DRIVER");
	            System.exit(0); //parar la ejecución
	        }
	 
	        //Establecer la conexión con el servidor
	        try {
	            conexion = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
	            System.exit(0); //parar la ejecución
	        }
	        System.out.println("Conectado a "+baseDatos);
	    }
	 
	    //Devuelve el objeto Connection que se usará en la clase Controller
	    public static Connection getConexion() {
	        return conexion;
	    }

}
