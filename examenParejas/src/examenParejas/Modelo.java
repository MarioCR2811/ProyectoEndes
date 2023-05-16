package examenParejas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Modelo 
{
	public static final int CORRECTO = 0;
	public static final int YA_EXISTE = 1;

	private LinkedHashSet<Persona> solicitantes;
	private HashMap<Persona, TreeMap<Persona,Persona>> gestoresParejas;

	public Modelo()
	{
		solicitantes=new LinkedHashSet<>();
		gestoresParejas=new HashMap<Persona, TreeMap<Persona,Persona>> ();
	}
    //
	
	/**
	 *
	 * 
	 * @param nombre Es el nombre de la persona solicitante.
	 * @param sexoSolicitante Indica el sexo de la persona solicitante.
	 * @param sexoSolicitado Indica el sexo de la persona solicitada por la persona solicitante.
	 * @param gestor Indica si la persona solicitante es ademas un gestor o no.
	 * @param aficiones Contiene una lista de las aficiones de la persona solicitante.
	 * @return Anyade a la persona solicitante si esta no existe ya, en caso de que existiese no se anyadiria.
	 */
	public int anyadeSolicitante(String nombre, Sexo sexoSolicitante, Sexo sexoSolicitado, boolean gestor,List<String> aficiones)
	{	
		
		//Como todos los atributos que se pasan como parametro son los mismos atributos de la clase persona, creamos una persona con esos atributos
		// y la anyadimos al LinkedHashSet de solicitantes, en caso de que exista la anyade y es correcto, y en caso de que no saltaria el mensaje de que ya existe
		Persona persona = new Persona(nombre, sexoSolicitante, sexoSolicitado, gestor, aficiones);
		
		return solicitantes.add(persona) ? CORRECTO:YA_EXISTE;
		
	}
	//
	
	/**
	 * 
	 * @return Devuelve un Set de personas que son gestoras.
	 * 
	 */
	public Set<Persona> getListaGestores()
	{
		//Para obtener la lista de solicitantes gestores, creamos un Set, en este caso un hashset, que tiene que devolver
		//un set con todos los solicitantes que son gestores, entonces recorremos con un foreach todas las personas solicitantes
		//y si es gestor == true, anyadimos esa persona al hashset de personasgestoras.
		HashSet<Persona> personasGestoras = new HashSet<>(); 
		for(Persona p: solicitantes) {
			if(p.isGestor()) {
				personasGestoras.add(p);
			}
		}
		return personasGestoras;
	}
	//
	
	/**
	 * 
	 * @return Devuelve un Set de las personas solicitantes.
	 * 
	 */
	public Set<Persona> getListaSolicitantes()
	{
		return this.solicitantes;
	}
	
	//
	
	/**
	 * @param nombreSolicitante Es el nombre de la persona solicitante de la cual queremos saber que afinidades tiene con otros solicitantes compatibles.
	 * @return Devuelve un lista de las personas afines a la persona cuyo nombre es el mismo que el pasado por parametro y cuales son las afinidades en comun entre ellos.
	 * 
	 */
	public String getListadoAfinidades(String nombreSolicitante)
	{
		//Para saber las afinidades comunes de la persona pasada como parametro con el resto de solicitantes afines a sus preferencias, creamos el String que devolvera las aficiones
		//comunes de las dos personas, para ello creamos una persona, que la obtendremos a traves del metodo getpersonasolicitantepornombre que nos devuelve el objeto persona del 
		//nombre pasado como parametro, entonces una vez tenemos esa persona, recorremos todos los solicitantes, entonces si el sexo de la solicitante es el sexo buscado de la persona 
		//solicitante o viceversa y además no son la misma persona, devolvemos el listado de las afinidades, con el metodo creado en la clase Persona, aficionesComunesCon.
		String listadoPersonasAfines="";
        Persona personaParam = getPersonaSolicitantePorNombre(nombreSolicitante);
        for (Persona persona : solicitantes) {
            if(persona.getSexoPropio().equals(personaParam.getSexoBuscado()) && persona.getSexoBuscado().equals(personaParam.getSexoPropio()) && !persona.equals(personaParam)) {
                listadoPersonasAfines += "Aficiones comunes de " + nombreSolicitante + " y " + persona.getNombre() + ": " + persona.aficionesComunesCon(personaParam) + "\n";
            }
        }
        return listadoPersonasAfines;
	}
	
	/**
	 * @param nombreGestor Es el nombre del gestor de la pareja.
	 * @param nombreSolicitante Es el nombre de la persona solicitante.
	 * @param nombrePareja Es el nombre de la persona que queremos que sea la pareja de la persona solicitante.
	 * @return Nos indica si podemos incluir a esa pareja o no.
	 * 
	 */

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja)
	{	
		int puedoIncluirlo = CORRECTO;
		
		Persona gestor = getPersonaSolicitantePorNombre(nombreGestor);
		Persona solicitante = getPersonaSolicitantePorNombre(nombreSolicitante);
		Persona pareja = getPersonaSolicitantePorNombre(nombrePareja);
		
		if(!gestoresParejas.containsKey(gestor)) {
			gestoresParejas.put(gestor, new TreeMap<Persona,Persona>());
		}
		
		for(TreeMap<Persona, Persona> couple : gestoresParejas.values()) {
			if(couple.containsKey(solicitante) || couple.containsKey(pareja) || couple.containsValue(solicitante) || couple.containsValue(pareja)) {
				puedoIncluirlo = YA_EXISTE;
			}
		}
		
		if(puedoIncluirlo == CORRECTO) {
			gestoresParejas.get(gestor).put(solicitante, pareja);
		}
		return puedoIncluirlo;
	}
	
	/**
	 * 
	 * @return Nos devuelve un String  con todas las personas solicitantes listadas.
	 * 
	 */

	public String getListadoSolicitantes()
	{	
		//Para obtener un listado de todos los solicitantes, creamos un String con la lista de nombres de solicitantes, entonces recorremos cada personasolicitante de 
		//set de solicitantes, y anyadimos ese nombre a la la lista de solicitantes
		String listSol = "";
		
		for(Persona p: solicitantes) {
			listSol += p.getNombre() + ", ";
		}
		
		return listSol;
	}
	
	/**
	 * 
	 * @return Devuelve un String con todas las parejas listadas y ordendas.
	 * 
	 */

	public String getListadoParejas()
	{	
		//Debemos de devolver un listado de todas las parejas, ordenadas por el nombre alfabetico del gestor, entonces creamos un TreeMap, para implementar un 
		//compareTo() en la clase persona que las compare por nombre, este TreeMap, va a ser igual que el de gestores parejas, entonces lo pasamos como parametro
		// y creamos un String que sera la lista de las parejas, ya que hay que devolver un String.
		TreeMap<Persona, TreeMap<Persona, Persona>> personasOrdenadas = new TreeMap<>(gestoresParejas);
		
		String listParejas = "";
		//Recorremos 
		for(Persona gestor : personasOrdenadas.keySet()) {
			if(personasOrdenadas.get(gestor) != null && personasOrdenadas.size() > 0) {
				listParejas += "Gestor " + gestor.getNombre() + " parejas hechas : " ;
				//
				for(Persona pareja : personasOrdenadas.get(gestor).keySet()) {
					listParejas += pareja.getNombre() + " + " + personasOrdenadas.get(gestor).get(pareja).getNombre();
				}
			}
		}
		return listParejas;
	}
	
	//
	
	/**
	 * @param nombreSolicitante Es el nombre de la persona solicitante de la cual queremos saber que afinidades tiene con otros solicitantes compatibles.
	 * @return Devuelve un objeto tipo persona la cual tenga el nombre pasado como parametro.
	 * 
	 */
	private Persona getPersonaSolicitantePorNombre(String nombreSolicitante) {
		//Este metodo se usa para devolver el objeto tipo persona la cual tenga como nombre el nombre pasado como parametro, entonces
		//recorremos todas las personas de los solicitantes, si el nombre de esa persona es igual que el nombre pasado como parametro, la persona
		// esa se iguala al parametro creado y asi obtenemos toda la clase persona de ese nombre.
        Persona personaParam=null;
        for (Persona personaP : solicitantes) {
            if(personaP.getNombre().equals(nombreSolicitante)) {
                personaParam=personaP;
            }
        }
        return personaParam;
    }

}
