public class ArbolPeliculas{

	ArbolPeliculas izq; //rama izquierda
	String nombre; //Titulo de la pelicula
	Pelicula pelicula; //objeto tipo pelicula
    ArbolPeliculas der; //rama derecha

    public ArbolPeliculas(){
		nombre = "";
		pelicula = null;
		izq = null;
		der = null;
	}
	public ArbolPeliculas(Pelicula v){
		pelicula = v;
		izq = null;
		der = null;
		nombre = pelicula.getTitle();
	}
	/**
     * @param  nada
     * @return  imprime todos los titulos que se encuentra
     * en el arbol
     */
	 public String print(){
        String r="";
        if(der!=null){
            r+=der.print();
        }
        r+=nombre+"\n";
        if(izq!=null){
            r+=izq.print();
        }
        return r;
    }
    /**
     * @param  palabra : String
     * @param  indice : int
     * @return Se crea un char array a partir del cada letra
     * de "palabra" y retorna el valor del char dependiendo del 
     * indice
     */
	public int getValor(String palabra,int indice){
		try{
			char [] separada = palabra.toUpperCase().toCharArray();
			int resultado = (int)separada[0];
			if(separada[indice]<'0'){
				separada[indice] = 0;
			}
			if(separada[0]>='M'){
				resultado = 1000;

			}
 		    return (int)separada[indice];
		}
		catch(ArrayIndexOutOfBoundsException e){
			return 0;
		}
	}
	 /** 
    * Este metodo pertenece a
    * @author Todd Davies, sacado de Stack Overflow
    * es solo para que el arbol sea mejor visualizado
    **/
	public void printBinaryTree(ArbolPeliculas root, int level){
        if(root==null){
           return;
        }    
        printBinaryTree(root.izq, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t");
            }
            System.out.println("|-------"+root.nombre);
        }
        else
            System.out.println(root.nombre);
        printBinaryTree(root.der, level+1);
    } 
    /**
     * @param  nuevaPelicula : objeto tipo pelicla
     * @param  indice : int
     * @return anyada nuevaPelicula a una posicion en el arbol de
     * manera "alafabetica" por el titulo de nuevaPelicula.
     */
	public void add(Pelicula nuevaPelicula,int indice){ 
		int valor1 = getValor(nuevaPelicula.getTitle(),indice);
		int valor2 = getValor(nombre,indice);
        
		if(nuevaPelicula.getTitle().equalsIgnoreCase(nombre)){
			//hacer nada,cambiar m
		}
		else{
			if(valor1==valor2){
				add(nuevaPelicula,indice+1);
			}
			if(valor1>valor2){
				if(der == null){
				    der = new ArbolPeliculas(nuevaPelicula);
			    }
			    else{
				    der.add(nuevaPelicula,0);
			    }
			}
			if(valor1<valor2){
				if(izq == null){
				    izq = new ArbolPeliculas(nuevaPelicula);
			    }
			    else{
				    izq.add(nuevaPelicula,0);
			    }
			}
		}
	}
	/**
     * @param  newCateogy : String
     * @param  category : ListaABC
     * @return nada, agrega una nueva categoria a un sub-arbol de una categoria
     * ya existente
     */
	public void addCategoria(String newCategory,ListaABC category){
        if(der!=null){
        	der.pelicula.agregarCategoria(newCategory);
            category.addCategoria(der.pelicula);
            der.addCategoria(newCategory,category);
        }
        if(izq!=null){
            izq.pelicula.agregarCategoria(newCategory);
            category.addCategoria(izq.pelicula);
            izq.addCategoria(newCategory,category);
        }
	}
    /**
     * @param  titulo : String
     * @param  indice : int
     * @return Pelicula,  busca de manera alfabetica si el titulo de 
     * la pelicula exite
     */
	public Pelicula buscar(String titulo,int indice){
		int valor1 = getValor(titulo,indice);
		int valor2 = getValor(nombre,indice);
		try{
			if(titulo.equalsIgnoreCase(nombre)){
			System.out.println(nombre);
            return pelicula;
		    }
		    else if(indice<titulo.length()){
		    	if(valor1 == valor2){
		    		return buscar(titulo,indice+1);
		    	}
		    	else if(valor1 < valor2){
		    		return izq.buscar(titulo,0);
		    	}
		    	else if(valor1 > valor2){
		    		return der.buscar(titulo,0);
		    	}
		    }
		}
		catch(NullPointerException e){
			return null;
		}
		
	    return null;	
	}
	public static void main(String [] args){
	}
}