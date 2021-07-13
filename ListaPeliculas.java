public class ListaPeliculas{
	ListaPeliculas next;
	Pelicula peliculas;
	boolean usado;

	public ListaPeliculas(){
        usado=false;
        next=null;
    }
    public ListaPeliculas(Pelicula movie){
        peliculas = movie;
        usado = true;
    }
    public String toString(){
        if (!usado)
            return "";
        else
        if (next==null){
            return " "+ peliculas.getTitulo();
        }
        else {
            return " "+peliculas.getTitulo()+next.toString();
        }
    }
    public void addFirst(Pelicula movie){
        if (!usado){ 
            usado=true;
            peliculas = movie;
        }else{
            next = new ListaPeliculas(movie);
            peliculas = movie;
        }
    }
    public void add(Pelicula movie){ 
        if (!usado){  
            usado = true;
            peliculas = movie;
        }else{
            if (next==null){ 
                next = new ListaPeliculas(movie);
            }else{
                next.add(movie); 
            }
        }
    }
	public static void main(String [] args){
		ListaPeliculas p = new ListaPeliculas();

		p.add()

	}

}
