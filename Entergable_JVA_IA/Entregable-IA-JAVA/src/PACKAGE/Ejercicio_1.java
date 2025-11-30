package PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

/

public class Ejercicio_1 {
    public class Ejercicio1 {
        public static void main(String[] args) throws SQLException {

            //Árbol de clasificacion con WEKA
            // --- 1 GENERANDO EL DATASET ---
            //NOS CONECTAMOS A LA DB
            String url = "jdbc:postgresql://localhost:5432/DATA_JAVA";
            String user = "root";
            String password = "1234";

            Connection cn = DriverManager.getConnection(url, user, password);

            String sql = "select edad, asistencia, promedio, conducta, apoyo_familiar, abandono from estudiantes_riesgo";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // --- 2 PROCESAMOS LA GENERACION DEL DATASET CON LA DATA DEL RESULTSET
            //ArrayList<E> EL ESQUELETO DEL DATASET
            ArrayList<Attribute> atributos = new ArrayList<Attribute>();

            atributos.add(new Attribute("edad"));
            atributos.add(new Attribute("asistencia"));
            atributos.add(new Attribute("promedio"));

            //ONE_HOT_ENCODER DE CONDUCTA
            ArrayList<String> valoresConducta = new ArrayList<String>();  // ← Arreglado "ArraryList"
            valoresConducta.add("buena");
            valoresConducta.add("regular");
            valoresConducta.add("mala");
            atributos.add(new Attribute("conducta", valoresConducta));     // ← Arreglado "Atribute"

            //ONE_HOT ENCODER DE APOYO FAMILIAR
            ArrayList<String> valoresApoyo = new ArrayList<String>();
            valoresApoyo.add("si");
            valoresApoyo.add("no");
            atributos.add(new Attribute("apoyo_familiar", valoresApoyo));  // ← Arreglado error de variable

            //ONE_HOT_ENCODER DE ABANDONO
            ArrayList<String> valoresAbandono = new ArrayList<String>();
            valoresAbandono.add("si");
            valoresAbandono.add("no");
            atributos.add(new Attribute("abandono", valoresAbandono));     // ← Arreglado "Atribute"

            //POBLADO NUESTRO DATA SET CON NUESTRO RESULT SET
            while (rs.next()) {
                // ← Arreglado: así se debe crear Instances
                Instances instances = new Instances("dataset", atributos, 0);
            }
        }
    }
}
