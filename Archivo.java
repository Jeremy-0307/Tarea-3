import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Archivo{
    public Pelicula crearMovie(String data){
        String [] separada = data.split(";");
        Pelicula movie = new Pelicula(separada[0],separada[1],separada[2],separada[3],separada[4],separada[5],separada[6],separada[7],separada[8],separada[9],separada[10],separada[11]);
        return movie;
    }
    public void read(){
         try{
            File myObj = new File("netflix.txt");
            Scanner pelicula = new Scanner(myObj);
            while(pelicula.hasNextLine()){

                String data = pelicula.nextLine();
                Pelicula movie = crearMovie(data);
                System.out.println(data);
                System.out.print("\n\n\n");
            }
            pelicula.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }

    }

    public static void main(String[] args){
        Archivo a = new Archivo();
        a.read();
    }
}
