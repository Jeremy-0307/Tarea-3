public class ListaABC{
     
    boolean usado;
	String letra;
	Lista hijas;
	ListaABC next;

    public ListaABC(){
        usado = false;
        next = null;
        hijas = new Lista();
	}
	public ListaABC(String n){
		letra = n;
        next = null;
        usado = true;
        hijas = new Lista();
	}
    public ListaABC(String n,Pelicula movie){
        letra = n;
        next = null;
        usado = true;
        hijas = new Lista();
    }
    public void addFirst(String name,Pelicula movie){
        if (usado == false){  
            letra = getLetra(name);
            usado = true;
        }
        else{
            next = new ListaABC (movie.getTitle());
        }
    }
    public int getValor(String abc){
        char [] separada = abc.toUpperCase().toCharArray();
        int resultado = (int)separada[0];
        if(separada[0]>='M'){
            resultado = resultado+1;
        }
        return resultado;
    } 
    public String getLetra(String abc){
        String [] separada = abc.toUpperCase().split("");
        return separada[0];
    } 
    public void addCategoria(Pelicula movie){
        String [] separada = (movie.getCategorias().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c].trim(),movie);
        }
    }
    public void addPais(Pelicula movie){
        add(movie.getPais().trim(),movie);
        
    }
    public void addActores(Pelicula movie){
        String [] separada = (movie.getCast().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c].trim(),movie);
        }
    }
    public void add(String name,Pelicula movie){
        if(!usado){  
            addFirst(name,movie);
        }
        else if(getLetra(name).equalsIgnoreCase(letra)){
                hijas.add(name,movie);
        }
        else{
            if(next == null){ 
                next = new ListaABC(getLetra(name));
                next.hijas.add(name,movie);
            }
            else{
                next.add(name,movie); 
            }
        }

    }
    public ArbolPeliculas buscar(String name){
        if(getLetra(name).equalsIgnoreCase(letra)){
            return hijas.buscarH(name);
        }
        else{
            if(next!=null){
                return next.buscar(name);
            }
            return null;
        }
    }
    public void impresion(){
        if(!usado){

        }
        else{
            System.out.println(letra+": "+ hijas.imprenta());
            if(next!=null){
                next.impresion();
            }

        }
    }
    public static void main(String [] args){
    }
}