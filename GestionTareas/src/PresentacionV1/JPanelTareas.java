package PresentacionV1;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import DominioV1.Tarea;
import DominioV1.Usuario;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;

public class JPanelTareas extends JPanel {
	private JLabel lnlDefinicion;
	private JLabel lblPrioridad;
	private JLabel lblEstado;
	private JRadioButton rdbtnTerminado;
	private JRadioButton rdbtnEjecucin;
	private JRadioButton rdbtnSinTerminar;
	private JRadioButton rdbtnAlta;
	private JRadioButton rdbtnMedia;
	private JRadioButton rdbtnBaja;
	private JTextField txtDefinicion;
	private JButton btnAadirTrabajador;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private Tarea tarea;
	private JButton btnCrearNuevaTarea;
	private JButton btnEliminarTareaActual;
	private JButton btnActualizarTarea;
	private JPanel pnlDatosTarea;
	private JPanel pnlTrabajadoresDisponibles;
	private JPanel pnlTrabajadoresOcupados;
	private JList<String> lstTrabajadoresDisponibles;
	private JList<String> lstTrabajadoresImplicados;
	private JFrameTareas frameTareas;
	private ArrayList<String> trabajadoresDisponibles = new ArrayList<String>();
	private ArrayList<String> usuariosTarea = new ArrayList<String>();
	private DefaultListModel<String> modelUsuariosDisponibles = new DefaultListModel<String>();
	private DefaultListModel<String> modelUsuariosImplicados = new DefaultListModel<String>();

	/**
	 * Create the panel.
	 */
	public JPanelTareas() {
		setBorder(new TitledBorder(null, "Tareas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 91, 370, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 60, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlDatosTarea = new JPanel();
		pnlDatosTarea
				.setBorder(new TitledBorder(null, "Estado tarea", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlDatosTarea = new GridBagConstraints();
		gbc_pnlDatosTarea.gridheight = 2;
		gbc_pnlDatosTarea.gridwidth = 2;
		gbc_pnlDatosTarea.fill = GridBagConstraints.BOTH;
		gbc_pnlDatosTarea.gridx = 0;
		gbc_pnlDatosTarea.gridy = 0;
		add(pnlDatosTarea, gbc_pnlDatosTarea);
		GridBagLayout gbl_pnlDatosTarea = new GridBagLayout();
		gbl_pnlDatosTarea.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlDatosTarea.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 15, 0, 67, 0, 0, 0, 0, 0, 0 };
		gbl_pnlDatosTarea.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlDatosTarea.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		pnlDatosTarea.setLayout(gbl_pnlDatosTarea);

		lnlDefinicion = new JLabel("Definicion:");
		GridBagConstraints gbc_lnlDefinicion = new GridBagConstraints();
		gbc_lnlDefinicion.insets = new Insets(0, 0, 5, 5);
		gbc_lnlDefinicion.gridx = 1;
		gbc_lnlDefinicion.gridy = 1;
		pnlDatosTarea.add(lnlDefinicion, gbc_lnlDefinicion);

		txtDefinicion = new JTextField();
		GridBagConstraints gbc_txtDefinicion = new GridBagConstraints();
		gbc_txtDefinicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDefinicion.gridwidth = 7;
		gbc_txtDefinicion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDefinicion.gridx = 3;
		gbc_txtDefinicion.gridy = 1;
		pnlDatosTarea.add(txtDefinicion, gbc_txtDefinicion);
		txtDefinicion.setColumns(10);

		lblPrioridad = new JLabel("Prioridad:");
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 1;
		gbc_lblPrioridad.gridy = 3;
		pnlDatosTarea.add(lblPrioridad, gbc_lblPrioridad);

		rdbtnAlta = new JRadioButton("Alta");
		GridBagConstraints gbc_rdbtnAlta = new GridBagConstraints();
		gbc_rdbtnAlta.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAlta.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlta.gridx = 3;
		gbc_rdbtnAlta.gridy = 3;
		pnlDatosTarea.add(rdbtnAlta, gbc_rdbtnAlta);

		rdbtnMedia = new JRadioButton("Media");
		GridBagConstraints gbc_rdbtnMedia = new GridBagConstraints();
		gbc_rdbtnMedia.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMedia.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMedia.gridx = 5;
		gbc_rdbtnMedia.gridy = 3;
		pnlDatosTarea.add(rdbtnMedia, gbc_rdbtnMedia);

		rdbtnBaja = new JRadioButton("Baja");
		GridBagConstraints gbc_rdbtnBaja = new GridBagConstraints();
		gbc_rdbtnBaja.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBaja.gridx = 7;
		gbc_rdbtnBaja.gridy = 3;
		pnlDatosTarea.add(rdbtnBaja, gbc_rdbtnBaja);

		btnActualizarTarea = new JButton("Actualizar Tarea");
		GridBagConstraints gbc_btnActualizarTarea = new GridBagConstraints();
		gbc_btnActualizarTarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizarTarea.gridx = 9;
		gbc_btnActualizarTarea.gridy = 4;
		pnlDatosTarea.add(btnActualizarTarea, gbc_btnActualizarTarea);

		lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		pnlDatosTarea.add(lblEstado, gbc_lblEstado);

		rdbtnTerminado = new JRadioButton("Terminado");
		GridBagConstraints gbc_rdbtnTerminado = new GridBagConstraints();
		gbc_rdbtnTerminado.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTerminado.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTerminado.gridx = 3;
		gbc_rdbtnTerminado.gridy = 5;
		pnlDatosTarea.add(rdbtnTerminado, gbc_rdbtnTerminado);

		rdbtnEjecucin = new JRadioButton("Ejecución");
		GridBagConstraints gbc_rdbtnEjecucin = new GridBagConstraints();
		gbc_rdbtnEjecucin.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEjecucin.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEjecucin.gridx = 5;
		gbc_rdbtnEjecucin.gridy = 5;
		pnlDatosTarea.add(rdbtnEjecucin, gbc_rdbtnEjecucin);

		rdbtnSinTerminar = new JRadioButton("Sin Terminar");
		GridBagConstraints gbc_rdbtnSinTerminar = new GridBagConstraints();
		gbc_rdbtnSinTerminar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSinTerminar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSinTerminar.gridx = 7;
		gbc_rdbtnSinTerminar.gridy = 5;
		pnlDatosTarea.add(rdbtnSinTerminar, gbc_rdbtnSinTerminar);

		pnlTrabajadoresDisponibles = new JPanel();
		pnlTrabajadoresDisponibles.setBorder(
				new TitledBorder(null, "Trabajadores Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlTrabajadoresDisponibles = new GridBagConstraints();
		gbc_pnlTrabajadoresDisponibles.gridwidth = 3;
		gbc_pnlTrabajadoresDisponibles.gridheight = 4;
		gbc_pnlTrabajadoresDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_pnlTrabajadoresDisponibles.fill = GridBagConstraints.BOTH;
		gbc_pnlTrabajadoresDisponibles.gridx = 1;
		gbc_pnlTrabajadoresDisponibles.gridy = 7;
		pnlDatosTarea.add(pnlTrabajadoresDisponibles, gbc_pnlTrabajadoresDisponibles);
		GridBagLayout gbl_pnlTrabajadoresDisponibles = new GridBagLayout();
		gbl_pnlTrabajadoresDisponibles.columnWidths = new int[] { 0, 0 };
		gbl_pnlTrabajadoresDisponibles.rowHeights = new int[] { 0, 0 };
		gbl_pnlTrabajadoresDisponibles.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTrabajadoresDisponibles.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlTrabajadoresDisponibles.setLayout(gbl_pnlTrabajadoresDisponibles);

		lstTrabajadoresDisponibles = new JList();
		GridBagConstraints gbc_lstTrabajadoresDisponibles = new GridBagConstraints();
		gbc_lstTrabajadoresDisponibles.fill = GridBagConstraints.BOTH;
		gbc_lstTrabajadoresDisponibles.gridx = 0;
		gbc_lstTrabajadoresDisponibles.gridy = 0;
		pnlTrabajadoresDisponibles.add(lstTrabajadoresDisponibles, gbc_lstTrabajadoresDisponibles);

		pnlTrabajadoresOcupados = new JPanel();
		pnlTrabajadoresOcupados.setBorder(
				new TitledBorder(null, "Trabajadores Implicados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlTrabajadoresOcupados = new GridBagConstraints();
		gbc_pnlTrabajadoresOcupados.gridheight = 4;
		gbc_pnlTrabajadoresOcupados.gridwidth = 2;
		gbc_pnlTrabajadoresOcupados.insets = new Insets(0, 0, 5, 5);
		gbc_pnlTrabajadoresOcupados.fill = GridBagConstraints.BOTH;
		gbc_pnlTrabajadoresOcupados.gridx = 7;
		gbc_pnlTrabajadoresOcupados.gridy = 7;
		pnlDatosTarea.add(pnlTrabajadoresOcupados, gbc_pnlTrabajadoresOcupados);
		GridBagLayout gbl_pnlTrabajadoresOcupados = new GridBagLayout();
		gbl_pnlTrabajadoresOcupados.columnWidths = new int[] { 0, 0 };
		gbl_pnlTrabajadoresOcupados.rowHeights = new int[] { 0, 0 };
		gbl_pnlTrabajadoresOcupados.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTrabajadoresOcupados.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlTrabajadoresOcupados.setLayout(gbl_pnlTrabajadoresOcupados);

		lstTrabajadoresImplicados = new JList();
		GridBagConstraints gbc_lstTrabajadoresImplicados = new GridBagConstraints();
		gbc_lstTrabajadoresImplicados.fill = GridBagConstraints.BOTH;
		gbc_lstTrabajadoresImplicados.gridx = 0;
		gbc_lstTrabajadoresImplicados.gridy = 0;
		pnlTrabajadoresOcupados.add(lstTrabajadoresImplicados, gbc_lstTrabajadoresImplicados);

		btnAadirTrabajador = new JButton("Añadir Trabajador");
		GridBagConstraints gbc_btnAadirTrabajador = new GridBagConstraints();
		gbc_btnAadirTrabajador.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirTrabajador.gridx = 5;
		gbc_btnAadirTrabajador.gridy = 8;
		pnlDatosTarea.add(btnAadirTrabajador, gbc_btnAadirTrabajador);

		btnEliminarTareaActual = new JButton("Eliminar Tarea Actual");
		btnEliminarTareaActual.addActionListener(new BtnEliminarTareaActualActionListener());
		GridBagConstraints gbc_btnEliminarTareaActual = new GridBagConstraints();
		gbc_btnEliminarTareaActual.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarTareaActual.gridx = 7;
		gbc_btnEliminarTareaActual.gridy = 12;
		pnlDatosTarea.add(btnEliminarTareaActual, gbc_btnEliminarTareaActual);

		btnCrearNuevaTarea = new JButton("Crear Nueva Tarea");
		GridBagConstraints gbc_btnCrearNuevaTarea = new GridBagConstraints();
		gbc_btnCrearNuevaTarea.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearNuevaTarea.gridx = 9;
		gbc_btnCrearNuevaTarea.gridy = 12;
		pnlDatosTarea.add(btnCrearNuevaTarea, gbc_btnCrearNuevaTarea);
		btnCrearNuevaTarea.addActionListener(new BtnCrearNuevaTareaActionListener());

	}

	public void trabajadoresDisponibles() {
		for (int j = 0; j < usuarios.size(); j++)
			if (!usuariosTarea.contains(usuarios.get(j).getNombre())) {
				trabajadoresDisponibles.add(usuarios.get(j).getNombre());
			}
	}

	public void rellenarListaTrabajadoresDisponibles() {
		modelUsuariosDisponibles.clear();
		trabajadoresDisponibles.clear();
		
		trabajadoresDisponibles();
		
		for (int i = 0; i < trabajadoresDisponibles.size(); i++) {
			modelUsuariosDisponibles.addElement(trabajadoresDisponibles.get(i));
		}
		lstTrabajadoresDisponibles.setModel(modelUsuariosDisponibles);
	}

	public void rellenarListaTrabajadoresTarea() {
		modelUsuariosImplicados.clear();
		for (int i = 0; i < usuariosTarea.size(); i++) {
			modelUsuariosImplicados.addElement(usuariosTarea.get(i));
		}
		lstTrabajadoresImplicados.setModel(modelUsuariosImplicados);
	}

	public void setFramePadre(JFrameTareas frame) {
		frameTareas = frame;
	}

	private class BtnCrearNuevaTareaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtDefinicion.setText("");
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			btnCrearNuevaTarea.setEnabled(false);
			btnEliminarTareaActual.setEnabled(false);
			btnActualizarTarea.setText("Guardar Tarea");
		}
	}

	private class BtnEliminarTareaActualActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}

	public void rellenar() {
		txtDefinicion.setText(tarea.getDescripion());
		btnEliminarTareaActual.setEnabled(true);
		btnCrearNuevaTarea.setEnabled(true);
		switch (tarea.getPrioridad()) {
		case 1:
			rdbtnAlta.setSelected(true);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			break;
		case 2:
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(true);
			rdbtnBaja.setSelected(false);
			break;
		case 3:
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(true);
			break;
		}
		switch (tarea.getEstado()) {
		case 1:
			rdbtnTerminado.setSelected(true);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			break;
		case 2:
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(true);
			rdbtnSinTerminar.setSelected(false);
			break;
		case 3:
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(true);
			break;

		}
	}

	public void setJlabelPadre() {

	}

	public void setArrayListUsuarios(ArrayList<Usuario> users) {
		usuarios = users;
	}

	public void setUsuario(Usuario u) {
		usuario = u;

	}

	public void setTarea(Tarea t) {

		tarea = t;
		usuariosTarea = tarea.getParticipantes();
		rellenar();
		rellenarListaTrabajadoresTarea();
		rellenarListaTrabajadoresDisponibles();
	}

}
