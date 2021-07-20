import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Controlador{
	ArbolPeliculas pelis;
	Archivo file;
	ListaABC actores;
	ListaABC categorias;

    

    public void iniciar(){
    	File archiv = new File("netflix.txt");
        Scanner scnnr = new Scanner(archiv);
        while(scnnr.hasNextLine()){
        	String data = scnnr.nextLine();
        	Pelicula movie = file.crearMovie(data);

            pelis.add(movie,0);

            
            String [] ac = (movie.getCast().split(","));
            for(int f = 0; f < ac.length; f++){
            	actores.add(ac[c]);
            }
        }
        scnnr.close();
    }



	public static void main(String [] args){

	}
}