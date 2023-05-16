package examenParejas;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Persona implements Comparable<Persona>
{
	public static final boolean HOMBRE = true;
	public static final boolean MUJER = false;

	private String nombre;
	private Sexo sexoPropio;
	private Sexo sexoBuscado;
	private boolean esGestor;
	private LinkedList<String> aficiones=new LinkedList<>();

	public Persona(String nombre, Sexo sexoPropio, Sexo sexoBuscado, boolean esGestor, List<String> gustos)
	{
		this.nombre=nombre;
		this.sexoPropio=sexoPropio;
		this.sexoBuscado=sexoBuscado;
		this.esGestor=esGestor;
		this.aficiones.addAll(gustos);
	}
	//
   public String aficionesComunesCon(Persona otra)
	{	
	   //Este metodo devuelve las aficiones comunes de una persona con otra, para ello se crea un string vacio, ya que hay que devolver un String
	   //y recorremos cada gusto en la lista de aficiones, si la otra persona pasada como parametro, contiene es sus aficiones alguno de los gustos
	   //de la primera persona, entonces el valor de ese String se le anyade ese gusto hasta que ya no haya mas comunes.
	   String aficionesComunesCon = "";
	   for(String gusto: this.aficiones) {
		   if(otra.aficiones.contains(gusto)) {
			   aficionesComunesCon+= gusto + " , ";
		   }
	   }
	   return aficionesComunesCon;
	}
   
	public boolean isGestor()
	{
		return esGestor;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public Sexo getSexoPropio()
	{
		return sexoPropio;
	}

	public Sexo getSexoBuscado()
	{
		return sexoBuscado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", sexoPropio=" + sexoPropio + ", sexoBuscado=" + sexoBuscado
				+ ", esGestor=" + esGestor + ", aficiones=" + aficiones + "]";
	}
}
