public class ListaABC{
     
    boolean usado; //saber si ya la lista esta usada
	String letra; //Letra, primera letra de una palabra dada
	Lista hijas; //Lista cuyo nombre (Pais/Categoria/Actor) qcomiencen con la misma Letra
	ListaABC next; //Siguiente Nodo

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
    /**
     * @param  movie : objeto pelicula 
     * @param  name : Sring
     * @return  si la lista está vacia aplica em metodo .addFirst()
     */
    public void addFirst(String name,Pelicula movie){
        if (usado == false){  
            letra = getLetra(name);
            hijas.add(name,movie);
            usado = true;
        }
        else{
            next = new ListaABC (movie.getTitle());
        }
    }
     /**
     * @param  abc :  Pais/Categoria/Actor
     * @return  valor int del primer char de la Pais/Categoria/Actor
     */
    public int getValor(String abc){
        char [] separada = abc.toUpperCase().toCharArray();
        int resultado = (int)separada[0];
        if(separada[0]>='M'){
            resultado = resultado+1;
        }
        return resultado;
    } 
    /**
     * @param  abc : Pais/Categoria/Actor
     * @return  la primera letra de abc
     */
    public String getLetra(String abc){
        String [] separada = abc.toUpperCase().split("");
        return separada[0];
    } 
    /**
     * @param  movie : objeto pelicula
     * @return  nada, sino que tome al String de categorias de movie y por cada 
     * una le aplica el metodo .add()
     */
    public void addCategoria(Pelicula movie){
        String [] separada = (movie.getCategorias().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c].trim(),movie);
        }
    }
    /**
     * @param  movie : objeto pelicula
     * @return  nada, sino que tome al String de Paises de movie y por cada 
     * una le aplica el metodo .add()
     */
    public void addPais(Pelicula movie){
        String [] separada = (movie.getPais().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c].trim(),movie);
        }
    }
    /**
     * @param  movie : objeto pelicula
     * @return  nada, sino que tome al String de actores de movie y por cada 
     * una le aplica el metodo .add()
     */
    public void addActores(Pelicula movie){
        String [] separada = (movie.getCast().split(","));
        for(int c = 0; c < separada.length; c++){
            add(separada[c].trim(),movie);
        }
    }
    /**
     * @param  movie : objeto pelicula
     * @param  name : String (Pais/Categoria/Actor)
     * @return  nada, toma el name y compara la primera letra con las 
     * demas letras que estan en la ListaABC, 
     * -En caso de que sean iguales anyade la movie a las hijas
     * -En caso de que no sea iguales y aun hayan Nodo se fijara en el siguiente
     * -En caso de que se haya acabado los Nodos y no haya encontrado
     * un letra igual anyadara la letra como un nuevo Nodo y anyadara
     * la movie a hijas
     */
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
    /**
     * @param  name : String (Pais/Categoria/Actor)
     * @return  ArbolPeliculas, busca con que Nodo 
     * concuerdan la primera letra de name y Letra
     * -En caso de que lo encuentre aplica buscarH (buscar en Hijas)
     * -En caso de que no y aun hayan Nodos buscara en el sigueinte
     * -En caso de que se acaben los Nodos y no lo haya encontrado 
     * retornara Null
     */
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
    /**
     * @param nada
     * @return nada, imprime la Letra y sus hijas hasta que 
     * se acaben
     */
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