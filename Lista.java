public class Lista{
     
    boolean usado;
	String nombre;
	ArbolPeliculas hijas; //Sub-Arbol de peliculas
	Lista next;

    public Lista(){
	}
	public Lista(String n){
		nombre = n;
	}
	public int valor(String nombre,int cero){
		try{
			char [] separada = nombre.toUpperCase().toCharArray();
 		    return (int)separada[cero];
		}
		catch(NullPointerException e){
			return 0;
		}
	} 
	public void addFirst(String newName){
        if (usado != false){  
            nombre = newName;
        }
        else{
            next = new Lista (nombre);
            nombre = newName;
        }
    }
    public void add(String newName){
        if (usado != false){  
            usado = true;
            nombre = newName;
        }
        else{
            if(next == null){ 
                next = new Lista(newName);
            }
            else{
                next.add(newName); 
            }
        }
    }
    public void ordenar(){
    	if(usado == false){
    		//hacer nada
    	}
    	else{
    		int cero = 0;
            int valor1 = valor(nombre,0);
            int valor2 = valor(next.nombre,0);
    		Lista temporal = new Lista();
    		if(valor1<valor2){

    		}
    		if(valor1>valor2){

    		}
    		else{

    		}
    		
    	}


    }

	public void addHijas(Pelicula movie){
		hijas.add(movie);
	}
	public static void main(String [] args){

	}
}