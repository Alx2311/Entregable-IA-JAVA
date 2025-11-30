package DML;

public class Pelicula {
	 private int id;
	    private String titulo;
	    private String genero;

	    public Pelicula(int id, String titulo, String genero) {
	        this.id = id;
	        this.titulo = titulo;
	        this.genero = genero;
	    }

	    public String getTitulo() {
	        return titulo;
	    }
}
