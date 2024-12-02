package principal;
import clases.*;
import utilidades.EmailValidator;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int opcion = 0;
			String message="Aún no hay profesores introducidos";
			ArrayList<Profesor> listaProfesores = new ArrayList<>();
			rellenarListaDeProfesores(listaProfesores);
	//		do {
				opcion = menu();
				switch (opcion) {
				case 1:
					nuevoProfe(listaProfesores);
					break;
				case 2:
					if (listaProfesores.size()>0)
						anadirPublicacion(listaProfesores);
					else
						System.out.println(message);
					break;
				case 3:
					//Depende de que haya profes pero también publicaciones premiadas, que lo controle el método
					librosPremiadosAnno(listaProfesores);
					break;
				case 4:
					//Depende de que haya profes pero también publicaciones, que lo controle el método.
					listadoPorDepartamento(listaProfesores);
					break;
				case 5:
					if (listaProfesores.size()>0)
						listaProfes(listaProfesores);
					else
						System.out.println(message);
					break;
				}
		//	} while (opcion != 6);
			System.out.println("Gracias por usar nuestro programa...");
	} //fin del main
	private static int menu() {
		System.out.println("-------- MENU -----------");
		System.out.println("1) Introducir un nuevo profesor");
		System.out.println("2) Añadir publicación/es");
		System.out.println("3) Mostrar libros premiados de un año concreto");
		System.out.println("4) Mostrar un listado por departamento de los profes con mayor número de publicaciones");
		System.out.println("5) Listar profes");
		System.out.println("6) Salir");
		System.out.println("Introduce la opción elegida (1-6)");
		System.out.println("--------------------------");
		//int opcion = Util.leerInt(1, 6);
		int opcion=4;
		return opcion;
	}
	private static void nuevoProfe(ArrayList<Profesor> listaProfesores) {
		String email=null;
		boolean esta=false;
		System.out.println("Introduce email: ");
	//	email=Util.introducirCadena();
		if (EmailValidator.validarEmail(email)){ //Si el mail es correcto
			for(int i=0; i<listaProfesores.size(); i++){
				if (listaProfesores.get(i).getEmail().equalsIgnoreCase(email)){
					System.out.println("Error, el profesor ya existe, sus datos:");
					esta=true;
					i=listaProfesores.size();
				}
			}
			if (!esta){ //Profe nuevo
				Profesor aux=new Profesor();
				// falta pedir al usuario y rellenar aux
			//	aux.setDatosProfe(email);
				listaProfesores.add(aux);
			}
		}//Fin if del email correcto
	}//nuevoProfe
	private static void anadirPublicacion(ArrayList<Profesor> listaProfesores) {
		String email=null;
		boolean esta=false;
		System.out.println("Introduce email: ");
	//	email=Util.introducirCadena();
		if (EmailValidator.validarEmail(email)){ //Si el mail es correcto
			for(int i=0; i<listaProfesores.size(); i++){
				if (listaProfesores.get(i).getEmail().equalsIgnoreCase(email)){
					
					// falta pedir al usuario nuevas publicaciones y añadirlas
					//listaProfesores.get(i).setDatosPubli(); //Para añadir publicaciones: libros y/o artículos
					esta=true;
					i=listaProfesores.size();
				}
			}
			if (!esta){ //Profe nuevo
				System.out.println("No se pueden añadir publicaciones ya que el profesor aún no está registrado");
			}
		}//if del mail correcto
	}//añadirPublicacion
	private static void listaProfes(ArrayList<Profesor> listaProfesores) {
	//	for (Profesor p: listaProfesores){
	//		p.getDatos();
	//	}
	}
	private static void librosPremiadosAnno(ArrayList<Profesor> listaProfesores) {
		int anno,hay=0;
		System.out.println("Introduce año: ");
	//	anno=Util.leerInt();
		anno=2024;
		 
		for (Profesor p: listaProfesores){
			for (Publicacion pu:p.getPublicaciones()){
				if (pu instanceof Libro && ((Libro) pu).isPremiado()&& pu.getAnno()==anno){
					hay++;
					if (hay==1){
						System.out.println("Fecha-publicación Titulo ISBN Nombre profesor Nombre departamento");
					}
					System.out.println(pu.getFechaMA()+" "+pu.getTitulo()+" "+((Libro)pu).getIsbn()+" "+p.getNombre()+" "+p.getNomDepar());
				}
			}
		}
		if (hay==0) System.out.println("No se han encontrados libros galardonados.");
	}
	private static void listadoPorDepartamento(ArrayList<Profesor> listaProfesores) {
		Collections.sort(listaProfesores);
		if (listaProfesores.size()==0)
			System.out.println("No hay profesores");
		else
		{
			String depar=listaProfesores.get(0).getNomDepar()+"-";
			for (int contador=0;contador<listaProfesores.size();contador++)
			{
				if (contador == 0)
					System.out.println("Nombre Depar--Nombre profe--Numero Publicaciones");
				if (!depar.equalsIgnoreCase(listaProfesores.get(contador).getNomDepar()))
				{
					depar=listaProfesores.get(contador).getNomDepar();
					System.out.println(listaProfesores.get(contador).getNomDepar() + "--" + listaProfesores.get(contador).getNombre()+"--"+listaProfesores.get(contador).getNumeroPublicaciones());
				}
			}
		}
		
	} // listado por departamento con publicaciones
	
	 public static void rellenarListaDeProfesores(ArrayList<Profesor> lista) {
	        // Crear las publicaciones genéricas
	        Articulo pub1 = new Articulo("Articulo 1");	        
	        Libro pub2 = new Libro("Libro 2");
	        Libro pub3 = new Libro("Libro 3");

	        // Profesor 1
	        Profesor prof1 = new Profesor();
	        prof1.setNombre("Profesor 1");
	        prof1.setEmail("prof1@universidad.edu");
	        prof1.setNomDepar("Departamento A");
	        prof1.getPublicaciones().add(pub1);
	        lista.add(prof1);

	        // Profesor 2
	        Profesor prof2 = new Profesor();
	        prof2.setNombre("Profesor 2");
	        prof2.setEmail("prof2@universidad.edu");
	        prof2.setNomDepar("Departamento A");
	        prof2.getPublicaciones().add(pub1);
	        prof2.getPublicaciones().add(pub2);
	        lista.add(prof2);

	        // Profesor 3
	        Profesor prof3 = new Profesor();
	        prof3.setNombre("Profesor 3");
	        prof3.setEmail("prof3@universidad.edu");
	        prof3.setNomDepar("Departamento B");
	        prof3.getPublicaciones().add(pub1);
	        prof3.getPublicaciones().add(pub2);
	        lista.add(prof3);

	        // Profesor 4
	        Profesor prof4 = new Profesor();
	        prof4.setNombre("Profesor 4");
	        prof4.setEmail("prof4@universidad.edu");
	        prof4.setNomDepar("Departamento B");
	        prof4.getPublicaciones().add(pub1);
	        prof4.getPublicaciones().add(pub2);
	        prof4.getPublicaciones().add(pub3);
	        lista.add(prof4);

	        // Profesor 5
	        Profesor prof5 = new Profesor();
	        prof5.setNombre("Profesor 5");
	        prof5.setEmail("prof5@universidad.edu");
	        prof5.setNomDepar("Departamento C");
	        prof5.getPublicaciones().add(pub1);
	        prof5.getPublicaciones().add(pub2);
	        lista.add(prof5);
	    }
	}


