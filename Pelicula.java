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
	String categoria;
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
	    categoria = cate;
	    descripcion = descrip;
	}
	public  String getshowID(){
		return showID;
	}
	public  String gettipo(){
		return tipo;
	}
	public  String getdirector(){
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
	public  String getCategoria(){
		return categoria;
	}
	public  String getDescripcion(){
		return descripcion;
	}
	public  String getAnyo(){
		return anyo;
	}

	public static void main(String [] args){

	}
}