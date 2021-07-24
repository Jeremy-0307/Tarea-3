public class Lista{
     
    boolean usado;
	String nombre;
	ArbolPeliculas hijas; //Sub-Arbol de peliculas
	Lista next;

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
    public Lista(String name ,Pelicula movie){
        nombre = name;
        hijas = new ArbolPeliculas();
        hijas.add(movie,0);
        next = null;
        usado = true;
    }
    public Lista(String n, Lista d){
        nombre = n;
        next = d;
        usado = true;
        hijas = new ArbolPeliculas();

    }
	public int valor(String nombre,int indice){
		try{
			char [] separada = nombre.toUpperCase().toCharArray();
 		    return (int)separada[indice];
		}
		catch(ArrayIndexOutOfBoundsException e){
			return 100;
		}
	} 
    public String imprenta(){
        if (!usado)
            return "";
        else
        if (next==null){
            return " "+nombre+" | ";
        }
        else {
            return " "+nombre+" | "+next.imprenta();
        }
    }
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
    public void ordenar(Lista enRevision,int indice){
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
                int valor1 = valor(enRevision.nombre,indice);
                int valor2 = valor(nombre,indice);
                if(valor1==valor2){
                    ordenar(enRevision,indice+1);
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
	public static void main(String [] args){
        Lista categoria = new Lista();
        
	}
}