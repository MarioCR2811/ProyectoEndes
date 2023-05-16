package examenParejas;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Principal
{
	private Modelo modelo;
	private VentanaPpal vista;

	public static void main(String args[])
	{
		new Principal();
	}

	public Principal()
	{
		this.modelo = new Modelo();

		//////////// usado para crear datos de prueba
		this.crearDatos();
		////////////

		this.vista = new VentanaPpal(this);
		this.vista.setVisible(true);
	}

	private void crearDatos()
	{

		String afiA[]= {"Leer","Ver la tele"};
		String afiB[]= {"Leer","Ir al cine"};
		String afiC[]= {"Leer","Pasear"};
		String afiD[]= {"Leer","Ver la tele","Ir al cine"};
		String afiE[]= {"Leer","Ver la tele","Ir al cine","Pasear"};
		
		altaSolicitante("Ambrosio",Sexo.HOMBRE,Sexo.MUJER,true, Arrays.asList(afiA));
		altaSolicitante("Amelia",Sexo.MUJER,Sexo.HOMBRE,false,Arrays.asList(afiB));
		altaSolicitante("Amos",Sexo.HOMBRE,Sexo.HOMBRE,false,Arrays.asList(afiC));
		altaSolicitante("Amparo",Sexo.MUJER,Sexo.MUJER,false,Arrays.asList(afiD));
		altaSolicitante("Anacleto",Sexo.HOMBRE,Sexo.MUJER,true,Arrays.asList(afiE));
		altaSolicitante("Anastasia",Sexo.MUJER,Sexo.HOMBRE,false,Arrays.asList(afiA));
		altaSolicitante("Andres",Sexo.HOMBRE,Sexo.HOMBRE,false,Arrays.asList(afiB));
		altaSolicitante("Angel",Sexo.HOMBRE,Sexo.MUJER,false,Arrays.asList(afiC));
		altaSolicitante("Angela",Sexo.MUJER,Sexo.HOMBRE,true,Arrays.asList(afiD));
		altaSolicitante("Angeles",Sexo.MUJER,Sexo.MUJER,false,Arrays.asList(afiE));
		altaSolicitante("Angelica",Sexo.MUJER,Sexo.HOMBRE,false,Arrays.asList(afiA));
		altaSolicitante("Angelina",Sexo.MUJER,Sexo.MUJER,false,Arrays.asList(afiB));
		altaSolicitante("Angustias",Sexo.MUJER,Sexo.HOMBRE,true,Arrays.asList(afiC));
		altaSolicitante("Anibal",Sexo.HOMBRE,Sexo.MUJER,false,Arrays.asList(afiD));
		altaSolicitante("Aniceto",Sexo.HOMBRE,Sexo.HOMBRE,false,Arrays.asList(afiE));
		altaSolicitante("Anselmo",Sexo.HOMBRE,Sexo.MUJER,true,Arrays.asList(afiA));

	}
	

	public int altaSolicitante(String nombre, Sexo sexoSolicitante, 
			Sexo sexoSolicitado, boolean gestor,
			List<String> aficiones)
	{
		return this.modelo.anyadeSolicitante(nombre,sexoSolicitante,
				sexoSolicitado,gestor,aficiones);
	}

	public Set<Persona> getListaGestores()
	{
		return this.modelo.getListaGestores();
	}

	public Set<Persona> getListaSolicitantes()
	{
		return this.modelo.getListaSolicitantes();
	}

	public String getListadoAfinidades(String nombreSolicitante)
	{
		return this.modelo.getListadoAfinidades(nombreSolicitante);
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja)
	{
		return this.modelo.creaPareja(nombreGestor, nombreSolicitante, nombrePareja);
	}

	public String getListadoSolicitantes()
	{
		return this.modelo.getListadoSolicitantes();
	}

	public String getListadoParejas()
	{
		return this.modelo.getListadoParejas();
	}
}