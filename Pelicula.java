public class Pelicula{

	String showID;
	String tipo;
	String title;
	String director;
	String cast;
	String pais;
	String estreno;
	String rating;
	String duracion;
	String categoria;
	String descripcion;

	public Pelicula(String id,String type,String dire,String nombre,String ca,String pO,String anyo,String rat,String dura,String cate,String descrip){
	    showID = id;
	    tipo = type;
	    director = dire;
	    title = nombre;
	    cast = ca;
	    pais = pO;
	    estreno = anyo;
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
		return title;	|
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

	public static void main(String [] args){

	}
}