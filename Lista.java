public class Lista{
     
    boolean usado; //Saber si la lista ya esta usada
	String nombre; //nombre (Pais/Categoria/Actor)
	ArbolPeliculas hijas; //Sub-Arbol de peliculas
	Lista next; //Siguiente Nodo

    public Lista(){
        usado = false;
        next = null;
        hijas = new ArbolPeliculas();
	}
	public Lista(String n){
		nombre = n;
        next = null;
        usado = true;
        hijas = new ArbolPeliculas();
	}
    public Lista(String n, Lista d){
        nombre = n;
        next = d;
        usado = true;
        hijas = new ArbolPeliculas();
    }
    public Lista(String name ,Pelicula movie){
        nombre = name;
        hijas = new ArbolPeliculas();
        hijas.add(movie,0);
        next = null;
        usado = true;
    }
    /**
     * @param  abc :  Pais/Categoria/Actor
     * @return  valor int del primer char de la Pais/Categoria/Actor
     */
	public int valor(String nombre,int indice){
		try{
			char [] separada = nombre.toUpperCase().toCharArray();
 		    return (int)separada[indice];
		}
		catch(ArrayIndexOutOfBoundsException e){
			return 100;
		}
	} 
     /**
     * @param nada
     * @return String de los nombres
     * de los Nodos en la lista hasta que se acaben
     */
    public String imprenta(){
        if(!usado){
            return "";
        }
        else{
            if(next==null){
                return " "+nombre+" | ";
            }
            else{
            return " "+nombre+" | "+next.imprenta();
            }
        }
    }
    /**
     * @param name : String
     * @param movie : obejto tipo pelicula 
     * @return String de los nombres
     * de los Nodos en la lista hasta que se acaben
     */
	public void addFirst(String name,Pelicula movie){
        if (usado == false){  
            nombre = name;
            hijas.add(movie,0);
            usado = true;
        }
        else{
            next = new Lista (name,movie);
            next.hijas.add(movie,0);
        }
    }
     /**
     * @param name : String
     * @param movie : obejto tipo pelicula 
     * @return nada, el metodo se encarga de recibir
     * un name (Pais/Categoria/Actor) y agregarle
     * la pelicula a hijas al nodo
     */
    public void add(String name,Pelicula movie){
        if(!usado){  
            addFirst(name,movie);
        }
        else if(nombre.equalsIgnoreCase(name)){
            hijas.add(movie,0);
        }
        else{
            if(next == null){ 
                next = new Lista(name,movie);
            }
            else{
                next.add(name, movie); 
            }
        }
    }
    /**
     * @param name : String
     * @return busca por los Nodos de la lista 
     * si existe un nombre que concuerde con name
     * y regresa su subarbol de peliculas
     */
    public ArbolPeliculas buscarH(String name){
        if(nombre.equalsIgnoreCase(name)){
            return hijas;

        }
        else{
            if(next==null){
                return null;
            }
            else{
                return next.buscarH(name);
            }
        }   
    }
	public static void main(String [] args){
	}
}