package clases;

import java.util.ArrayList;

public class Profesor implements Comparable<Profesor>{
	private String email;
	private String nombre;
	private String nomDepar;
	private ArrayList <Publicacion> publicaciones;
	public Profesor() {
		publicaciones=new ArrayList <>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNomDepar() {
		return nomDepar;
	}
	public void setNomDepar(String nomDepar) {
		this.nomDepar = nomDepar;
	}
	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	public int getNumeroPublicaciones(){
		return publicaciones.size();
	}
	
	
	@Override
	/*El método compareTo en Java debe devolver un valor entero que represente la relación de orden entre el objeto actual 
	 * (this) y el objeto que se compara (otro).
	 
	Los posibles valores son:
	
	Un valor negativo (< 0):
	Indica que el objeto actual (this) es menor que el objeto otro.
	
	Cero (0):
	Indica que el objeto actual (this) es igual al objeto otro en términos de orden.
	
	Un valor positivo (> 0):
	Indica que el objeto actual (this) es mayor que el objeto otro.
	*/
	public int compareTo(Profesor otro) {
		// Comparar primero por nombre de departamento alfabéticamente
		int comparacionDepartamento = this.nomDepar.compareToIgnoreCase(otro.nomDepar);
		if (comparacionDepartamento != 0) {
			// Si son diferentes los nombres de los departamentos devuelve <0 si es alfabeticamente menor
			return comparacionDepartamento;
		}

		// Si los departamentos son iguales, comparar por número de publicaciones (de mayor a menor)
		// <0 si otro tiene menos publicaciones
		return Integer.compare(otro.getNumeroPublicaciones(), this.getNumeroPublicaciones());
	}
	
}