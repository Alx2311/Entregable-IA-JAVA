package Controller;
import DML.Pelicula;
import java.util.List;

public class Controller {
	public String recomendar(List<Pelicula> peliculas, int index) {
        if (index >= peliculas.size()) {
            return ""; 
        }

        return peliculas.get(index).getTitulo() + "\n" +
               recomendar(peliculas, index + 1);
    }
}
