import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Archivo{
    public Pelicula crearMovie(String data){
        String [] separada = data.split(";");
        Pelicula movie = new Pelicula(separada[0],separada[1],separada[2],separada[3],separada[4],separada[5],separada[6],separada[7],separada[8],separada[9],separada[10],separada[11]);
        return movie;
    }

    public static void main(String[] args){
        try{
            File myObj = new File("netflix.txt");
            Scanner pelicula = new Scanner(myObj);
            int x=6;
            int contador = 0;
            while(pelicula.hasNextLine()){
                String data = pelicula.nextLine();
                String [] separada = data.split(";");
                for(int i = 0; i < separada.length; i++){
                    System.out.println(separada[i]);
                }
            }
            pelicula.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }
    }
}
