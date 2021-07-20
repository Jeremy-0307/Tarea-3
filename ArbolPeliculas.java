public class ArbolPeliculas{

	ArbolPeliculas izq;
	Pelicula pelicula;
    ArbolPeliculas der;
    
	public ArbolPeliculas(Pelicula v){
		pelicula = v;
		izq = null;
		der = null;
	}
	public ArbolPeliculas(){
	}
	public int valor(Pelicula nuevaPelicula,int cero){
		String peliculaNombre = nuevaPelicula.getTitle();
		try{
			char [] separada = peliculaNombre.toUpperCase().toCharArray();
 		    return (int)separada[cero];
		}
		catch(NullPointerException e){
			return 0;
		}
	} 
	public void add(Pelicula nuevaPelicula,int cero){
		String peliculaNombre = nuevaPelicula.getTitle();

		int valor1 = valor(nuevaPelicula,cero);
		int valor2 = valor(pelicula,cero);

		if(peliculaNombre.equalsIgnoreCase(pelicula.getTitle())){
			//hacer nada
		}
		else{
			if(valor1>=valor2){
				if(der == null){
				    der = new ArbolPeliculas(nuevaPelicula);
			    }
			    if(der!=null && valor2 == valor1){
                    der.add(nuevaPelicula,cero++);
			    }
			    else{
				    der.add(nuevaPelicula,cero);
			    }
			}
			if(valor1<valor2){
				if(izq == null){
				    izq = new ArbolPeliculas(nuevaPelicula);
			    }
			    else{
				    izq.add(nuevaPelicula,cero);
			    }
			}
		}
	}
	public static void main(String [] args){

	}
}