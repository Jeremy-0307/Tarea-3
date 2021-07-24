public class ArbolPeliculas{

	ArbolPeliculas izq;
	String nombre;
	Pelicula pelicula;
    ArbolPeliculas der;
    
	public ArbolPeliculas(Pelicula v){
		pelicula = v;
		izq = null;
		der = null;
		nombre = pelicula.getTitle();
	}
	public ArbolPeliculas(){
		nombre = "Movies:\n";
		pelicula = null;
		izq = null;
		der = null;
	}
	 public String print(){
        String r="";
        if (der!=null){
            r+=der.print();
        }
        r+=nombre+"\n";
        if (izq!=null){
            r+=izq.print();
        }
        return r;
    }
	public int getValor(String palabra,int indice){
		try{
			char [] separada = palabra.toUpperCase().toCharArray();
			int resultado = (int)separada[0];
			if(separada[0]>='M'){
				resultado = resultado+1;

			}
 		    return (int)separada[indice];
		}
		catch(NullPointerException e){
			return 0;
		}
	} 
	public void add(Pelicula nuevaPelicula,int indice){     // AB AC
		int valor1 = getValor(nuevaPelicula.getTitle(),indice);
		int valor2 = getValor(nombre,indice);
        
		if(nuevaPelicula.getTitle().equalsIgnoreCase(nombre)){
			//hacer nada,cambiar m
		}
		else{
			if(valor1>=valor2){
				if(der == null){
				    der = new ArbolPeliculas(nuevaPelicula);
			    }
			    else if(der!=null && valor2 == valor1){
                    der.add(nuevaPelicula,indice++);
			    }
			    else{
				    der.add(nuevaPelicula,indice);
			    }
			}
			if(valor1<valor2){
				if(izq == null){
				    izq = new ArbolPeliculas(nuevaPelicula);
			    }
			    else{
				    izq.add(nuevaPelicula,indice);
			    }
			}
		}
	}
	public void addCategoria(String newCategory,ListaABC category){
        if(der!=null){
        	der.pelicula.agregarCategoria(newCategory);
            category.addCategoria(der.pelicula);
            der.print();
        }
        if(izq!=null){
            izq.pelicula.agregarCategoria(newCategory);
            category.addCategoria(izq.pelicula);
            izq.print();
        }
	}
	public Pelicula buscar(String movie,int indice){
		int valor1 = getValor(movie,indice);
		int valor2 = getValor(nombre,indice);
		if(movie.equalsIgnoreCase(nombre)){
			System.out.println(nombre);
            return pelicula;
		}
		else if(indice<movie.length()){
			if(valor1 == valor2){
				return buscar(movie,indice++);
			}
			else if(valor1 < valor2){
				return izq.buscar(movie,indice);
			}
			else if(valor1 > valor2){
				return der.buscar(movie,indice);
			}
		}
	    return null;
		
	}
	public static void main(String [] args){

	}
}