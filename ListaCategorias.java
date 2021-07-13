public class ListaCategorias{
	ListaCategorias next;
	Pelicula peliculas;
	boolean usado;

	public ListaCategorias(){
        usado=false;
        next=null;
    }
    public ListaCategorias(Pelicula movie){
        peliculas = movie;
        usado = true;
    }
    public String toString(){
        if (!usado)
            return "";
        else
        if (next==null){
            return " "+ peliculas.getTitle();
        }
        else {
            return " "+peliculas.getTitle()+next.toString();
        }
    }
    public void addFirst(Pelicula movie){
        if (!usado){ 
            usado=true;
            peliculas = movie;
        }else{
            next = new ListaCategorias(movie);
            peliculas = movie;
        }
    }
    public void add(Pelicula movie){ 
        if (!usado){  
            usado = true;
            peliculas = movie;
        }else{
            if (next==null){ 
                next = new ListaCategorias(movie);
            }else{
                next.add(movie); 
            }
        }
    }
	public static void main(String [] args){
		ListaCategorias p = new ListaCategorias();


	}

}
