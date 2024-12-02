package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Publicacion{
protected String titulo;

protected LocalDate fecha;
public Publicacion(String string) {
	// TODO Auto-generated constructor stub
	this.titulo=string;
}
public String getTitulo() {
return titulo;
}
public void setTitulo(String titulo) {
this.titulo = titulo;
}
public LocalDate getFecha() {
return fecha;
}
public void setFecha(LocalDate fecha) {
this.fecha = fecha;
}

public int getAnno(){
return fecha.getYear();
 }
public String getFechaDMA(){
 DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
return fecha.format(formateador);
}
 public String getFechaMA(){
 DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MMMM-yyyy");
return fecha.format(formateador);
}
}