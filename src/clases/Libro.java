package clases;

public class Libro extends Publicacion{
public Libro(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
private String isbn;
private boolean premiado;
public String getIsbn() {
return isbn;
}
public void setIsbn(String isbn) {
this.isbn = isbn;
}
public boolean isPremiado() {
return premiado;
}
public void setPremiado(boolean premiado) {
this.premiado = premiado;
}

}