class Pelicula{

	String showID;
	String tipo;
	String title;
	String director;
	String cast;
	String pais;
	String estreno;
	String anyo;
	String rating;
	String duracion;
	String categorias;
	String descripcion;

	public Pelicula(String id,String type,String nombre,String dire,String ca,String pO,String fecha,String year,String rat,String dura,String cate,String descrip){
	    showID = id;
	    tipo = type;
	    title = nombre;
	    director = dire;
	    cast = ca;
	    pais = pO;
	    estreno = fecha;
        anyo = year;
	    rating = rat;
	    duracion = dura;
	    categorias = cate;
	    descripcion = descrip;
	}
	public  String getshowID(){
		return showID;
	}
	public  String getTipo(){
		return tipo;
	}
	public  String getDirector(){
		return director;
	}	
	public  String getTitle(){
		return title;	
	}
	public  String getCast(){
		return cast;
	}
	public  String getPais(){
		return pais;
	}
	public  String getEstreno(){
		return estreno;
	}
	public  String getRating(){
		return rating;
	}
	public  String getDuracion(){
		return duracion;
	}
	public  String getCategorias(){
		return categorias;
	}
	public  void agregarCategoria(String newCategory){
		categorias = newCategory+", "+categorias;
	}
	public  String getDescripcion(){
		return descripcion;
	}
	public  String getAnyo(){
		return anyo;
	}
	public String getInformacion(){
		String resultado = getshowID()+"\n"+getTipo()+"\nDirector@: "+getDirector()+ " - titulo: "+getTitle()+ " - duracion: "+getDuracion()+"\nReparto: "+getCast()+
        "\nCategorias: "+getCategorias()+"\nPais: "+getPais() +" - estrenada en: "+getEstreno() +" - Rating: "+getRating()+" - anyo: "+getAnyo()+"\nSipnosis: "+getDescripcion();
        return resultado;
	}

	public static void main(String [] args){

	}
}