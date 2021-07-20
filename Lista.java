public class Lista{
     
    boolean usado;
	String nombre;
	ArbolPeliculas hijas; //Sub-Arbol de peliculas
	Lista next;

    public Lista(){
        usado = false;
        next = null;
        hijas = null;
	}
	public Lista(String n){
		nombre = n;
        next = null;
        usado = true;
	}
    public Lista(Pelicula movie){
        nombre = movie.getTitle();
        hijas.add(movie,0);
        next = null;
        usado = true;
    }
    public Lista(String n, Lista d){
        nombre = n;
        next = d;
        usado = true;
    }
	public int valor(String nombre,int cero){
		try{
			char [] separada = nombre.toUpperCase().toCharArray();
 		    return (int)separada[cero];
		}
		catch(ArrayIndexOutOfBoundsException e){
			return 100;
		}
	} 
	public void addFirst(Pelicula movie){
        if (usado == false){  
            nombre = movie.getTitle();
            usado = true;
        }
        else{
            next = new Lista (movie);
            next.hijas.add(movie,0)
        }
    }
    public void add(Pelicula movie){
        if(!usado){  
            addFirst(movie);
        }
        else{
            if(next == null){ 
                next = new Lista(movie);
                next.hijas.add(movie,0);
            }
            else{
                next.add(movie); 
            }
        }
    }
    public int getTotal(){
        if(!usado){
            return 0;
        }
        else{
            int contador = 1;
            Lista temporal = next;
            while(temporal!=null){
                contador++;
                temporal = temporal.next;
            }
            return contador;
        }
    }
    public Lista buscar(String name){
        if(nombre.equalsIgnoreCase(name)){
            Lista temporal = new Lista(name,next);
            return temporal;
        }
        else{
            return next.buscar(name);
        }
    }
    public void ordenar(Lista enRevision,int cero){
    	if(usado == false){
    		//hacer nada
    	}
    	else{
            if(enRevision.nombre.equalsIgnoreCase(nombre)){
                if(next!=null){
                    next.ordenar(enRevision,0);
                }
            }
            else{
                int valor1 = valor(enRevision.nombre,cero);
                int valor2 = valor(nombre,cero);
                if(valor1==valor2){
                    ordenar(enRevision,cero+1);
                }   
                else if(valor1>valor2){
                    String temporal = enRevision.nombre;
                    enRevision.nombre = nombre;
                    nombre = temporal;
                }
                if(next!=null){
                    ordenar(enRevision.next,0);
                }
            }
    	}
    }
    public void ordenar(Lista cate){
        if(getTotal()>1){
            ordenar(cate,0);
        }
        if(next!=null){
            next.ordenar(cate);
        }
    }
    public void imprimir(){
        if(!usado){

        }
        else{
            System.out.println(nombre);
            Lista temporal = next;
            while(temporal!=null){
                System.out.println(temporal.nombre);
                temporal = temporal.next;
            }
        }
    }
	public static void main(String [] args){
        Lista categoria = new Lista();
        
	}
}