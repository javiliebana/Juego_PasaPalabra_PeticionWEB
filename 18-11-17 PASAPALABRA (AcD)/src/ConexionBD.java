import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ConexionBD {


	public static void insertarDatos(ArrayList<Pregunta> lista_PasaPal) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties p=new Properties();
			p.setProperty("user", "root");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pasapalabra", p);
			Statement stmt=c.createStatement();
			String sql="CREATE TABLE IF NOT EXISTS PasaPalabra(letra VARCHAR(200), posicion VARCHAR(200), definicion VARCHAR(500), solucion VARCHAR(200));";
			stmt.executeUpdate(sql);
			for (Pregunta pregunta : lista_PasaPal) {
				String insert="INSERT INTO PasaPalabra (letra,posicion,definicion,solucion) VALUES (?,?,?,?)";
				 PreparedStatement preparedStmt = c.prepareStatement(insert);
			      preparedStmt.setString (1, pregunta.getLetra());
			      preparedStmt.setString (2, pregunta.getPosicion());
			      preparedStmt.setString(3, pregunta.getDefinicion());
			      preparedStmt.setString(4, pregunta.getSolucion());
			      preparedStmt.execute();
			      
			      
			      
			}
			stmt.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

