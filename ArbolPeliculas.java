public class ArbolPelicuals{

	ArbolPelicuals izq;
	String pelicula;
    ArbolPelicuals der;
	public ArbolPelicuals(String v){
		pelicula = v;
	}
	public ArbolPelicuals(){
	}
	public int valor(String nuevaPelicula,int cero){
		try{
			char [] separada = nuevaPelicula.toUpperCase().toCharArray();
 		    return (int)separada[cero];
		}
		catch(NullPointerException e){
			return 0;
		}
	} 
	public void add(String nuevaPelicula,int cero){
		int valor1 = valor(nuevaPelicula,cero);
		int valor2 = valor(pelicula,cero);

		if(nuevaPelicula.equalsIgnoreCase(pelicula)){
			//hacer nada
		}
		else{
			if(valor1>=valor2){
				if(der == null){
				    der = new ArbolPelicuals(nuevaPelicula);
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
				    izq = new ArbolPelicuals(nuevaPelicula);
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