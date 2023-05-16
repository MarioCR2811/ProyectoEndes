package examenParejas;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class VentanaPpal extends JFrame
{

	private static final long serialVersionUID = 1L;

	private Principal controlador;

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField campoNombreAlta;
	private JRadioButton radioSexoSolicitanteHombre;
	private JLabel lblSexo;
	private JRadioButton radioSexoSolicitanteMujer;
	private JLabel lblSexoDeLa;
	private JRadioButton radioSexoParejaSolicitadaHombre;
	private JRadioButton radioSexoParejaSolicitadaMujer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JCheckBox checkGestor;
	private JLabel lblGustosYAficiones;
	private JScrollPane scrollPane;
	private JList<String> listaAficiones;
	private JButton botonAltaSolicitante;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblGestorDeParejas;
	private JComboBox<String> comboGestor;
	private JLabel lblPrimerSolicitante;
	private JComboBox<String> comboSolicitante;
	private JLabel lblParejaSeleccionada;
	private JComboBox<String> comboPareja;
	private JButton botonMostrarAfinidades;
	private JButton botonCrearPareja;
	private JScrollPane scrollPane_1;
	private JTextArea areaTexto;
	private JButton botonListarTodo;
	private JButton botonListarParejasPorGestor;
	private JScrollPane scrollPane_2;
	private JTextArea areaListados;


	public VentanaPpal(Principal controlador)
	{
		setTitle("Parejas, S.A.");
		this.controlador = controlador;
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{

			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Altas", null, panel, null);

		lblNombre = new JLabel("Nombre:");

		campoNombreAlta = new JTextField();
		campoNombreAlta.setColumns(10);

		radioSexoSolicitanteHombre = new JRadioButton("Hombre");
		buttonGroup.add(radioSexoSolicitanteHombre);
		radioSexoSolicitanteHombre.setSelected(true);

		lblSexo = new JLabel("Sexo del solicitante:");

		radioSexoSolicitanteMujer = new JRadioButton("Mujer");
		buttonGroup.add(radioSexoSolicitanteMujer);

		lblSexoDeLa = new JLabel("Sexo de la pareja solicitada:");

		radioSexoParejaSolicitadaHombre = new JRadioButton("Hombre");
		buttonGroup_1.add(radioSexoParejaSolicitadaHombre);
		radioSexoParejaSolicitadaHombre.setSelected(true);

		radioSexoParejaSolicitadaMujer = new JRadioButton("Mujer");
		buttonGroup_1.add(radioSexoParejaSolicitadaMujer);

		checkGestor = new JCheckBox("Gestor de parejas");

		lblGustosYAficiones = new JLabel("Gustos y aficiones del solicitante");

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		botonAltaSolicitante = new JButton("Dar de alta");
		botonAltaSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAltaSolicitantePulsado();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(botonAltaSolicitante, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(campoNombreAlta, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(radioSexoSolicitanteMujer, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
														.addComponent(radioSexoSolicitanteHombre)
														.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
												.addGap(44)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(radioSexoParejaSolicitadaHombre, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblSexoDeLa)
																.addGap(43)
																.addComponent(checkGestor))
														.addComponent(radioSexoParejaSolicitadaMujer, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
												.addGap(43)))
								.addComponent(lblGustosYAficiones))
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(campoNombreAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblSexo)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radioSexoSolicitanteHombre)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radioSexoSolicitanteMujer))
								.addComponent(checkGestor)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblSexoDeLa)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radioSexoParejaSolicitadaHombre)
										.addComponent(radioSexoParejaSolicitadaMujer)))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(18)
										.addComponent(lblGustosYAficiones)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(botonAltaSolicitante)))
						.addContainerGap())
				);

		listaAficiones = new JList<String>();
		listaAficiones.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Leer", "Ver la tele", "Pasar tiempo con la familia", "Ir al cine", "Pescar", "Pasar el tiempo en el PC o port\u00E1til", "Dedicarse a la jardiner\u00EDa", "Alquilar pel\u00EDculas", "Pasear", "Hacer ejercicio", "Escuchar m\u00FAsica", "Realizar peque\u00F1as tareas divertidas", "Ir de caza", "Practicar deportes en equipo", "Ir de compras", "Viajar", "Dormir", "Socializarse", "Coser", "Jugar al golf", "Actividades de iglesia", "Relajarse", "Tocar alg\u00FAn instrumento", "Hacer las tareas del hogar", "Artesan\u00EDa", "Ver partidos", "Montar en bici", "Jugar a las cartas", "Excursionismo", "Cocinar", "Ir a cenar fuera", "Tener citas online", "Nadar", "Ir de camping", "Esquiar", "Arreglar coches", "Montar en barco", "Escribir", "Ir en motocicleta", "Cuidado de animales", "Jugar a los bolos", "Pintar", "Ir a correr", "Bailar", "Montar a caballo", "Jugar al tennis", "Ir al teatro", "Jugar al billar", "Ir a la playa", "Trabajar como voluntario"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listaAficiones);
		panel.setLayout(gl_panel);

		panel_1 = new JPanel();
		tabbedPane.addTab("Crear Parejas", null, panel_1, null);

		lblGestorDeParejas = new JLabel("Gestor de parejas:");

		comboGestor = new JComboBox<String>();

		lblPrimerSolicitante = new JLabel("Solicitante:");

		comboSolicitante = new JComboBox<String>();

		lblParejaSeleccionada = new JLabel("Pareja seleccionada:");

		comboPareja = new JComboBox<String>();

		botonMostrarAfinidades = new JButton("Ver aficiones comunes con el solicitante");
		botonMostrarAfinidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonMostrarAfinidadesPulsado();
			}
		});

		botonCrearPareja = new JButton("Crear pareja");
		botonCrearPareja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonCrearParejaPulsado();
			}
		});

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
										.addComponent(lblPrimerSolicitante, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addGap(57)
										.addComponent(comboSolicitante, 0, 345, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
										.addComponent(lblGestorDeParejas, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboGestor, 0, 345, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
										.addComponent(lblParejaSeleccionada)
										.addGap(39)
										.addComponent(comboPareja, 0, 345, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
										.addComponent(botonMostrarAfinidades, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(botonCrearPareja, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGestorDeParejas)
								.addComponent(comboGestor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrimerSolicitante)
								.addComponent(comboSolicitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(comboPareja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(4)
										.addComponent(lblParejaSeleccionada)))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonMostrarAfinidades)
								.addComponent(botonCrearPareja))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addContainerGap())
				);

		areaTexto = new JTextArea();
		scrollPane_1.setViewportView(areaTexto);
		panel_1.setLayout(gl_panel_1);

		panel_2 = new JPanel();
		tabbedPane.addTab("Listados", null, panel_2, null);
		
		botonListarTodo = new JButton("Listar solicitantes");
		botonListarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonListarTodoPulsado();
			}
		});
		botonListarTodo.setToolTipText("Listar todos los datos almacenados de los solicitantes");
		
		botonListarParejasPorGestor = new JButton("Parejas por gestores");
		botonListarParejasPorGestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonListarParejasPorGestorPulsado();
			}
		});
		botonListarParejasPorGestor.setToolTipText("Listado ordenado por nombre de gestor, con las parejas hechas por cada uno");
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(botonListarTodo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botonListarParejasPorGestor)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonListarTodo)
						.addComponent(botonListarParejasPorGestor))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		areaListados = new JTextArea();
		scrollPane_2.setViewportView(areaListados);
		panel_2.setLayout(gl_panel_2);
		this.actualizaCombos();
	}

	protected void botonAltaSolicitantePulsado()
	{
		if(this.campoNombreAlta.getText().isEmpty())
			this.error("Escriba un nombre.");
		else
			if(this.listaAficiones.isSelectionEmpty())
				this.error("Seleccione al menos una afici�n.");
			else
				if(this.controlador.altaSolicitante(
						this.campoNombreAlta.getText(),
						this.radioSexoSolicitanteHombre.isSelected()?Sexo.HOMBRE:Sexo.MUJER,
						this.radioSexoParejaSolicitadaHombre.isSelected()?Sexo.HOMBRE:Sexo.MUJER,						
						this.checkGestor.isSelected(),
						this.listaAficiones.getSelectedValuesList()) == Modelo.YA_EXISTE)
					this.error("Ya existe un solicitante con ese nombre");
				else
				{
					this.msg("Solicitante dado de alta");
					this.limpiarCampos();
					this.actualizaCombos();
				}

	}

	private void limpiarCampos()
	{
		this.campoNombreAlta.setText("");
		this.radioSexoSolicitanteHombre.setSelected(true);
		this.radioSexoParejaSolicitadaHombre.setSelected(true);
		this.checkGestor.setSelected(false);
		this.listaAficiones.clearSelection();
		this.areaTexto.setText("");
		this.comboGestor.setSelectedIndex(0);
		this.comboSolicitante.setSelectedIndex(0);
		this.comboPareja.setSelectedIndex(0);
	}

	private void error(String msg)
	{
		JOptionPane.showMessageDialog(this, msg,"Error",JOptionPane.ERROR_MESSAGE);
	}

	private void msg(String msg)
	{
		JOptionPane.showMessageDialog(this, msg,"Correcto",JOptionPane.INFORMATION_MESSAGE);
	}

	private void actualizaCombos()
	{
		this.actualizaComboGestores();
		this.actualizaCombo(this.comboSolicitante);
		this.actualizaCombo(this.comboPareja);
	}

	private void actualizaCombo(JComboBox<String> combo)
	{
		combo.removeAllItems();
		combo.addItem("seleccione un solicitante ...");
		for(Persona p:this.controlador.getListaSolicitantes())
			combo.addItem(p.getNombre());
	}

	private void actualizaComboGestores()
	{
		this.comboGestor.removeAllItems();
		this.comboGestor.addItem("seleccione un gestor ...");
		for(Persona p:this.controlador.getListaGestores())
			this.comboGestor.addItem(p.getNombre());
	}


	protected void botonMostrarAfinidadesPulsado() 
	{
		if(this.comboSolicitante.getSelectedIndex()<1)
			this.error("Debe seleccionar alg�n solicitante.");
		else
			this.areaTexto.setText(this.controlador.getListadoAfinidades((String)this.comboSolicitante.getSelectedItem()));
	}
	protected void botonCrearParejaPulsado() 
	{
		if(this.comboGestor.getSelectedIndex()<1)
			this.error("Debe seleccionar alg�n gestor.");
		else
			if(this.comboSolicitante.getSelectedIndex()<1)
				this.error("Debe seleccionar alg�n solicitante.");
			else
				if(this.comboPareja.getSelectedIndex()<1)
					this.error("Debe seleccionar alguna pareja.");	
				else
					if(((String)this.comboSolicitante.getSelectedItem()).equals((String)this.comboPareja.getSelectedItem()))
						this.error("La pareja no puede ser el mismo solicitante.");
					else
						if(this.controlador.creaPareja((String)this.comboGestor.getSelectedItem(),
								(String)this.comboSolicitante.getSelectedItem(),
								(String)this.comboPareja.getSelectedItem()
								) == Modelo.YA_EXISTE)
							this.error("Alguno de los seleccionados ya ten�a pareja.");
						else
						{
							this.msg("Pareja creada.");
							this.limpiarCampos();
						}
	}
	protected void botonListarTodoPulsado() 
	{
		this.areaListados.setText(this.controlador.getListadoSolicitantes());
	}
	protected void botonListarParejasPorGestorPulsado() 
	{
		this.areaListados.setText(this.controlador.getListadoParejas());
	}
}

