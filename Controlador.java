public class Controlador{
	Pelicula pelis;
	Archivo file;

	public Pelicula crearMovie(String data){
        String [] separada = data.split(";");
        Pelicula movie = new Pelicula(separada[0],separada[1],separada[2],separada[3],separada[4],separada[5],separada[6],separada[7],separada[8],separada[9],separada[10],separada[11]);
        return movie;
    }

	public static void main(String [] args){

	}
}