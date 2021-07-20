public class ListaABC{
     
    boolean usado;
	String letra;
	Lista hijas;
	ListaABC next;

    public ListaABC(){
        usado = false;
        next = null;
        hijas = null;
	}
	public ListaABC(String n){
		letra = n;
        next = null;
        usado = true;
	}
    public ListaABC(String n, ListaABC d){
        letra = n;
        next = d;
        usado = true;
    }
    public void addFirst(Pelicula movie){
        if (usado == false){  
            letra = getLetra(movie.getTitle());
            usado = true;
        }
        else{
            next = new ListaABC (letra);
            letra = getLetra(movie.getTitle());
        }
    }
    public int valor(String abc){
        char [] separada = abc.toUpperCase().toCharArray();
        return (int)separada[0];
    } 
    public String getLetra(String abc){
        String [] separada = abc.toUpperCase().split("");
        return separada[0];
    } 
    public void addCategoria(Pelicula movie){
        String [] separada = (movie.getCategorias().split(","));
        for(int c = 0; c < separada.length; c++){
            hijas.add(separada[c]);
        }
    }
    public void addActores(Pelicula movie){
        String [] separada = (movie.getCast().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c],movie);
        }
    }
    public void add(String palabra,Pelicula movie){
        if(!usado){  
            addFirst(movie);
        }
        if(getLetra(movie.getTitle()).equalsIgnoreCase(letra)){
            hijas.add(movie);
        }
        else{
            if(next == null){ 
                next = new ListaABC(getLetra(movie.getTitle()));
                next.hijas.add(movie);
            }
            else{
                next.add(movie); 
            }
        }
    }
    public void imprimir(){
        System.out.println(letra);
        if(next!=null){
            next.imprimir();
        }
    }

    public static void main(String [] args){
        ListaABC wow = new ListaABC();
        wow.imprimir();


    }
}