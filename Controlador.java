import javax.swing.JOptionPane;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Controlador{
	ArbolPeliculas pelis;
	Archivo file;
	ListaABC actores;
	ListaABC categorias;

    public Controlador(){
        pelis = new ArbolPeliculas();
        file = new Archivo();
        actores = new ListaABC();
        categorias = new ListaABC();
    }

     public Pelicula crearMovie(String data){
        String [] separada = data.split(";");
        Pelicula movie = new Pelicula(separada[0],separada[1],separada[2],separada[3],separada[4],separada[5],separada[6],separada[7],separada[8],separada[9],separada[10],separada[11]);
        return movie;
    }
    public void iniciar(){
        try{
            File archiv = new File("netflix.txt");
            Scanner scnnr = new Scanner(archiv);
            while(scnnr.hasNextLine()){
                String data = scnnr.nextLine();
                Pelicula movie = crearMovie(data);
                pelis.add(movie,0);
                actores.addActores(movie);
                categorias.addCategoria(movie);
            }
            scnnr.close();
            JOptionPane.showMessageDialog(null, "Bienvenido al programa!");
            boolean ciclo = true;
            while(ciclo == true){
                String desicion1 = JOptionPane.showInputDialog("Desea buscar por: \n1-) Titulo \n2-) Actor \n3-) Categoria \n[Otra tecla\\Salir]");
                if(desicion1.equalsIgnoreCase("1")){
                    String movie = JOptionPane.showInputDialog("[ T I T U L O ]");
                    Pelicula temporal = pelis.buscar(movie,0);
                    String desicion12 = JOptionPane.showInputDialog("Desea ver la informacion de esta Pelicula?\n1-)Si \n2-)No");
                    if(desicion12.equalsIgnoreCase("1")){
                        System.out.println(temporal.getInformacion());
                    }
                }
                else if(desicion1.equalsIgnoreCase("2")){
                    String actor = JOptionPane.showInputDialog("[ A C T O R ]");

                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Ha ocurrrido un error");
        }
    }
    	
	public static void main(String [] args){
        Controlador c = new Controlador();
        c.iniciar();


	}
}