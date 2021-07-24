import javax.swing.JOptionPane;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Controlador{
	ArbolPeliculas pelis;
	ListaABC actores;
	ListaABC categorias;
    ListaABC paises;

    public Controlador(){
        pelis = new ArbolPeliculas();
        actores = new ListaABC();
        categorias = new ListaABC();
        paises = new ListaABC();
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
                paises.addPais(movie);
                categorias.addCategoria(movie);
            }
            scnnr.close();
            JOptionPane.showMessageDialog(null, "Bienvenido al programa!");
            boolean ciclo = true;
            while(ciclo == true){
                String desicion1 = JOptionPane.showInputDialog("Desea buscar por: \n( 1 ) Titulo \n( 2 ) Actor \n( 3 ) Categoria \n( 4 ) Categoria \n[Otra tecla\\Salir]");
                if(desicion1.equalsIgnoreCase("1")){
                    String movie = JOptionPane.showInputDialog("[ T I T U L O ]");
                    Pelicula temporal = pelis.buscar(movie,0);
                    String desicion1v2 = JOptionPane.showInputDialog("Desea ver la informacion de esta Pelicula?\n( 1 )Si \n( 2 )No");
                    if(desicion1v2.equalsIgnoreCase("1")){
                        System.out.println(temporal.getInformacion());
                    }
                }
                else if(desicion1.equalsIgnoreCase("2")){
                    String actor = JOptionPane.showInputDialog("[ A C T O R ]");
                    System.out.println(actor+" "+actores.buscar(actor).print());
                }
                else if(desicion1.equalsIgnoreCase("3")){
                    String categoria = JOptionPane.showInputDialog("[ C A T E G O R I A ]");
                    System.out.println(categoria+" "+categorias.buscar(categoria).print());
                    String desicion1v3 = JOptionPane.showInputDialog("Desea: \n ( 1 ) Agregarlas a una nueva Categoria [re-agruparlas] \n[Otra tecla\\Salir]");
                    if(desicion1v3.equalsIgnoreCase("1")){
                        String nuevaCategoria = JOptionPane.showInputDialog("Como desea llamar la nueva categoria?");
                        categorias.buscar(categoria).addCategoria(nuevaCategoria,categorias);
                    }
                }
                else if(desicion1.equalsIgnoreCase("4")){
                    String pais = JOptionPane.showInputDialog("[ P A I S ]");
                    System.out.println(pais+" "+paises.buscar(pais).print());
                }
                String desicion2 = JOptionPane.showInputDialog("Desea continuar con el programa? \n( 1 ) Si \n[Otra tecla\\Salir]");
                if(!desicion2.equalsIgnoreCase("1")){
                    ciclo = false;
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