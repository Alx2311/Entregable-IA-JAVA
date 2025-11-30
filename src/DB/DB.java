package DB;
import java.sql.Connection;
import java.sql.DriverManager;
public class DB {
	 private static final String URL = "jdbc:postgresql://localhost:5432/Entr_JV_01";
	    private static final String USER = "postgres";
	    private static final String PASS = "1234";

	    public static Connection getConexion() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            return DriverManager.getConnection(URL, USER, PASS);
	        } catch (Exception e) {
	            System.out.println("Error en conexión: " + e.getMessage());
	            return null;
	        }

	}
}
