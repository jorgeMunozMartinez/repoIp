package PresentacionV1;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import DominioV1.LecturaEscritura;
import DominioV1.Mensaje;
import DominioV1.Usuario;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JPanelMensaje extends JPanel {
	private JPanel pnlMensaje;
	private JPanel pnlDatos;
	private JList<String> lstMensajes;
	private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	private JLabel lblMensaje;
	private JLabel lblEnviadoPor;
	private JLabel lblMarcarMensajeComo;
	private JRadioButton rdbtnLeido;
	private JRadioButton rdbtnNoLeido;
	private JButton btnAceptar;
	private JTextField txtMensaje;
	private JTextField txtEnviado;
	private Usuario user;
	private LecturaEscritura m = new LecturaEscritura();
	private JLabel lblAsunto;
	private JTextField txtAsunto;
	private ArrayList<Usuario> users;
	private JButton btnBorrar;
	private Mensaje mensajeMod;
	private JLabel lblMensajeNumero;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	/**
	 * Create the panel.
	 */
	public JPanelMensaje() {

		setBorder(new TitledBorder(null, "Gestor Mensajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 158, 265, 0 };
		gridBagLayout.rowHeights = new int[] { 265, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlMensaje = new JPanel();
		pnlMensaje.setBorder(new TitledBorder(null, "Mensajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlMensaje = new GridBagConstraints();
		gbc_pnlMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_pnlMensaje.fill = GridBagConstraints.BOTH;
		gbc_pnlMensaje.gridx = 0;
		gbc_pnlMensaje.gridy = 0;
		add(pnlMensaje, gbc_pnlMensaje);
		GridBagLayout gbl_pnlMensaje = new GridBagLayout();
		gbl_pnlMensaje.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlMensaje.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlMensaje.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlMensaje.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pnlMensaje.setLayout(gbl_pnlMensaje);

		lstMensajes = new JList();
		lstMensajes.addMouseListener(new LstMensajesMouseListener());
		GridBagConstraints gbc_lstMensajes = new GridBagConstraints();
		gbc_lstMensajes.gridwidth = 3;
		gbc_lstMensajes.gridheight = 2;
		gbc_lstMensajes.fill = GridBagConstraints.BOTH;
		gbc_lstMensajes.gridx = 0;
		gbc_lstMensajes.gridy = 0;
		pnlMensaje.add(lstMensajes, gbc_lstMensajes);

		pnlDatos = new JPanel();
		pnlDatos.setBorder(new TitledBorder(null, "Datos Mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
		gbc_pnlDatos.fill = GridBagConstraints.BOTH;
		gbc_pnlDatos.gridx = 1;
		gbc_pnlDatos.gridy = 0;
		add(pnlDatos, gbc_pnlDatos);
		GridBagLayout gbl_pnlDatos = new GridBagLayout();
		gbl_pnlDatos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlDatos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlDatos.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlDatos.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		pnlDatos.setLayout(gbl_pnlDatos);

		lblMensaje = new JLabel("Mensaje:");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 1;
		pnlDatos.add(lblMensaje, gbc_lblMensaje);

		txtMensaje = new JTextField();
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.gridwidth = 3;
		gbc_txtMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.gridx = 3;
		gbc_txtMensaje.gridy = 1;
		pnlDatos.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);

		lblEnviadoPor = new JLabel("Enviado por:");
		GridBagConstraints gbc_lblEnviadoPor = new GridBagConstraints();
		gbc_lblEnviadoPor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnviadoPor.gridx = 1;
		gbc_lblEnviadoPor.gridy = 3;
		pnlDatos.add(lblEnviadoPor, gbc_lblEnviadoPor);

		txtEnviado = new JTextField();
		GridBagConstraints gbc_txtEnviado = new GridBagConstraints();
		gbc_txtEnviado.gridwidth = 3;
		gbc_txtEnviado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnviado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnviado.gridx = 3;
		gbc_txtEnviado.gridy = 3;
		pnlDatos.add(txtEnviado, gbc_txtEnviado);
		txtEnviado.setColumns(10);

		rdbtnLeido = new JRadioButton("Leido");
		rdbtnLeido.addActionListener(new RdbtnLeidoActionListener());

		lblAsunto = new JLabel("Asunto:");
		GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
		gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsunto.gridx = 1;
		gbc_lblAsunto.gridy = 5;
		pnlDatos.add(lblAsunto, gbc_lblAsunto);

		txtAsunto = new JTextField();
		GridBagConstraints gbc_txtAsunto = new GridBagConstraints();
		gbc_txtAsunto.gridwidth = 3;
		gbc_txtAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_txtAsunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAsunto.gridx = 3;
		gbc_txtAsunto.gridy = 5;
		pnlDatos.add(txtAsunto, gbc_txtAsunto);
		txtAsunto.setColumns(10);

		lblMarcarMensajeComo = new JLabel("Marcar mensaje como:");
		GridBagConstraints gbc_lblMarcarMensajeComo = new GridBagConstraints();
		gbc_lblMarcarMensajeComo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarcarMensajeComo.gridx = 1;
		gbc_lblMarcarMensajeComo.gridy = 7;
		pnlDatos.add(lblMarcarMensajeComo, gbc_lblMarcarMensajeComo);
		GridBagConstraints gbc_rdbtnLeido = new GridBagConstraints();
		gbc_rdbtnLeido.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLeido.gridx = 3;
		gbc_rdbtnLeido.gridy = 7;
		pnlDatos.add(rdbtnLeido, gbc_rdbtnLeido);

		rdbtnNoLeido = new JRadioButton("No leido");
		rdbtnNoLeido.addActionListener(new RdbtnNoLeidoActionListener());
		GridBagConstraints gbc_rdbtnNoLeido = new GridBagConstraints();
		gbc_rdbtnNoLeido.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNoLeido.gridx = 5;
		gbc_rdbtnNoLeido.gridy = 7;
		pnlDatos.add(rdbtnNoLeido, gbc_rdbtnNoLeido);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 9;
		pnlDatos.add(btnBorrar, gbc_btnBorrar);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 5;
		gbc_btnAceptar.gridy = 9;
		pnlDatos.add(btnAceptar, gbc_btnAceptar);
		btnBorrar.setEnabled(false);

		lblMensajeNumero = new JLabel("");
		GridBagConstraints gbc_lblMensajeNumero = new GridBagConstraints();
		gbc_lblMensajeNumero.gridwidth = 6;
		gbc_lblMensajeNumero.insets = new Insets(0, 0, 0, 5);
		gbc_lblMensajeNumero.gridx = 0;
		gbc_lblMensajeNumero.gridy = 10;
		pnlDatos.add(lblMensajeNumero, gbc_lblMensajeNumero);
	}

	public void rellenarLista() {
		model.removeAllElements();
		mensajes = m.lecturaMensajes();
		for (int i = 0; i < mensajes.size(); i++) {
			model.addElement(mensajes.get(i).getAsunto());
		}
		lstMensajes.setModel(model);
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mensajeMod.setAsunto(txtAsunto.getText());
			mensajeMod.setTexto(txtMensaje.getText());
			mensajeMod.setEnviado(txtEnviado.getText());
			mensajeMod.setLeido(rdbtnLeido.isSelected());
			lblMensajeNumero
					.setText("Mensaje número: " + (mensajes.indexOf(mensajeMod) + 1) + " modificado correctamente");
			lblMensajeNumero.setForeground(Color.GRAY);
			lecturaEscritura();

		}
	}

	public int getNumeroTareas() {
		int cont = 0;
		for (int i = 0; i < mensajes.size(); i++) {
			if (mensajes.get(i).isLeido()) {
				cont++;
			}
		}
		return cont;
	}

	private class RdbtnLeidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnLeido.setSelected(true);
			rdbtnNoLeido.setSelected(false);
		}
	}

	private class RdbtnNoLeidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnLeido.setSelected(false);
			rdbtnNoLeido.setSelected(true);
		}
	}

	private class LstMensajesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			btnBorrar.setEnabled(true);
			int index = lstMensajes.getSelectedIndex();
			lblMensajeNumero.setText("Mensaje numero: " + (index + 1));
			lblMensajeNumero.setForeground(Color.GRAY);
			mensajeMod = mensajes.get(index);
			mensajeMod = mensajes.get(index);
			txtAsunto.setText(mensajeMod.getAsunto());
			txtMensaje.setText(mensajeMod.getTexto());
			txtEnviado.setText(mensajeMod.getEnviado());
			if (mensajeMod.isLeido() == true) {
				rdbtnLeido.setSelected(true);
				rdbtnNoLeido.setSelected(false);
			} else {
				rdbtnNoLeido.setSelected(true);
				rdbtnLeido.setSelected(false);
			}

		}
	}

	public void lecturaEscritura() {
		m.EscrituraMensajes(mensajes);
		mensajes = m.lecturaMensajes();
		rellenarLista();
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mensajes.remove(mensajeMod);
			lecturaEscritura();
		}
	}

	public int mensajesSinLeer() {
		int msg = 0;
		for (int i = 0; i < mensajes.size(); i++) {
			if(mensajes.get(i).isLeido()==true) {
				msg++;
			}
		}
		return msg;
	}

	public void setUsuario(Usuario u, ArrayList<Usuario> us) {
		user = u;
		mensajes = m.lecturaMensajes();
		users = us;
		rellenarLista();
	}
}
