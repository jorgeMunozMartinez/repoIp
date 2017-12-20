package PresentacionV1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import DominioV1.DatosLogIn;
import DominioV1.LecturaEscritura;
import DominioV1.Mensaje;
import DominioV1.Usuario;

public class VentanaLogIn {

	private JFrame frmVentanaLogIn;
	private JPanel pnlLogIn;
	private JLabel lblIdioma;
	private JCheckBox cbxEspaol;
	private JCheckBox cbxEnglish;
	private JLabel lblIdiomaPrograma;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField pswContraseña;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnNuevoUsuario;
	private JLabel lblCheckUsuario;
	private JLabel lblCheckContraseña;
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
	public ArrayList<Usuario> listUsuarios = new ArrayList();
	private int id = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn window = new VentanaLogIn();
					window.frmVentanaLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getfrmVentanaLogIn() {
		return frmVentanaLogIn;
	}

	private void initialize() {

		LecturaEscritura e = new LecturaEscritura();
		listUsuarios = e.lecturaUsuario();
		frmVentanaLogIn = new JFrame();
		frmVentanaLogIn.setResizable(false);
		frmVentanaLogIn.setTitle("Ventana Log In");
		frmVentanaLogIn.setBounds(100, 100, 578, 331);
		frmVentanaLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnlLogIn = new JPanel();
		pnlLogIn.setBorder(new TitledBorder(null, "LogIn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmVentanaLogIn.getContentPane().add(pnlLogIn, BorderLayout.CENTER);
		GridBagLayout gbl_pnlLogIn = new GridBagLayout();
		gbl_pnlLogIn.columnWidths = new int[] { 100, 63, 64, 59, 190, 0 };
		gbl_pnlLogIn.rowHeights = new int[] { 50, 54, 54, 50, 50, 0 };
		gbl_pnlLogIn.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlLogIn.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlLogIn.setLayout(gbl_pnlLogIn);

		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setToolTipText("Seleccione el idioma del programa");
		GridBagConstraints gbc_lblIdioma = new GridBagConstraints();
		gbc_lblIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdioma.gridx = 0;
		gbc_lblIdioma.gridy = 0;
		pnlLogIn.add(lblIdioma, gbc_lblIdioma);

		cbxEspaol = new JCheckBox("Español");
		cbxEspaol.addActionListener(new CbxEspaolActionListener());
		cbxEspaol.setToolTipText("El idioma cambia a Español");
		cbxEspaol.setSelected(true);
		GridBagConstraints gbc_cbxEspaol = new GridBagConstraints();
		gbc_cbxEspaol.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEspaol.gridx = 1;
		gbc_cbxEspaol.gridy = 0;
		pnlLogIn.add(cbxEspaol, gbc_cbxEspaol);

		cbxEnglish = new JCheckBox("English");
		cbxEnglish.addActionListener(new CbxEnglishActionListener());
		cbxEnglish.setToolTipText("The program will change to English");
		GridBagConstraints gbc_cbxEnglish = new GridBagConstraints();
		gbc_cbxEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_cbxEnglish.gridx = 2;
		gbc_cbxEnglish.gridy = 0;
		pnlLogIn.add(cbxEnglish, gbc_cbxEnglish);

		lblIdiomaPrograma = new JLabel("");
		lblIdiomaPrograma.setText("El programa se ejecutara en Español");
		GridBagConstraints gbc_lblIdiomaPrograma = new GridBagConstraints();
		gbc_lblIdiomaPrograma.gridwidth = 2;
		gbc_lblIdiomaPrograma.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdiomaPrograma.gridx = 3;
		gbc_lblIdiomaPrograma.gridy = 0;
		pnlLogIn.add(lblIdiomaPrograma, gbc_lblIdiomaPrograma);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setToolTipText("Intoduzca el usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		pnlLogIn.add(lblUsuario, gbc_lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new TxtUsuarioActionListener());
		txtUsuario.addFocusListener(new MiFocusListener());
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 3;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 1;
		pnlLogIn.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		lblCheckUsuario = new JLabel("");
		GridBagConstraints gbc_lblCheckUsuario = new GridBagConstraints();
		gbc_lblCheckUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckUsuario.gridx = 4;
		gbc_lblCheckUsuario.gridy = 1;
		pnlLogIn.add(lblCheckUsuario, gbc_lblCheckUsuario);

		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setToolTipText("Introduzca la contraseña");
		lblContrasea.setEnabled(false);
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 2;
		pnlLogIn.add(lblContrasea, gbc_lblContrasea);

		pswContraseña = new JPasswordField();
		pswContraseña.addActionListener(new PswContraseñaActionListener());
		pswContraseña.setEnabled(false);
		pswContraseña.addFocusListener(new MiFocusListener());
		GridBagConstraints gbc_pswContraseña = new GridBagConstraints();
		gbc_pswContraseña.gridwidth = 3;
		gbc_pswContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_pswContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_pswContraseña.gridx = 1;
		gbc_pswContraseña.gridy = 2;
		pnlLogIn.add(pswContraseña, gbc_pswContraseña);

		lblCheckContraseña = new JLabel("");
		GridBagConstraints gbc_lblCheckContraseña = new GridBagConstraints();
		gbc_lblCheckContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckContraseña.gridx = 4;
		gbc_lblCheckContraseña.gridy = 2;
		pnlLogIn.add(lblCheckContraseña, gbc_lblCheckContraseña);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.setIcon(null);
		btnCancelar.setToolTipText("Borrar todos los campos");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 3;
		pnlLogIn.add(btnCancelar, gbc_btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setEnabled(false);
		btnAceptar.setToolTipText("Entrar al sistema");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 3;
		pnlLogIn.add(btnAceptar, gbc_btnAceptar);

		btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new BtnNuevoUsuarioActionListener());
		btnNuevoUsuario.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/PresentacionV1/people.png")));
		btnNuevoUsuario.setToolTipText("Crear nuevo usuario");
		GridBagConstraints gbc_btnNuevoUsuario = new GridBagConstraints();
		gbc_btnNuevoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevoUsuario.gridwidth = 3;
		gbc_btnNuevoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevoUsuario.gridx = 1;
		gbc_btnNuevoUsuario.gridy = 4;
		pnlLogIn.add(btnNuevoUsuario, gbc_btnNuevoUsuario);
	}

	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 250));
		}

	}

	private class CbxEnglishActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			cbxEspaol.setSelected(false);
			cbxEnglish.setSelected(true);
			lblIdiomaPrograma.setText("The program will execute in English");
		}
	}

	private class CbxEspaolActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cbxEspaol.setSelected(true);
			cbxEnglish.setSelected(false);
			lblIdiomaPrograma.setText("El programa se ejecutara en Español");
		}
	}

	private class TxtUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = txtUsuario.getText();
			boolean usuario = false;
			for (int i = 0; i < listUsuarios.size(); i++) {
				if (listUsuarios.get(i).getNombre().equals(nombre)) {
					usuario = true;
					id = listUsuarios.get(i).getID();
				}
			}
			if (usuario == true) {
				lblContrasea.setEnabled(true);
				pswContraseña.setEnabled(true);
				pswContraseña.requestFocus();
				txtUsuario.setBorder(bordeVerde);
				lblCheckUsuario.setText("Usuario Correcto");
				txtUsuario.setEnabled(false);
				
			} else {
				txtUsuario.setBorder(bordeRojo);
				lblCheckUsuario.setText("Usuario Incorrecto");
			}

		}
	}

	private class PswContraseñaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String contraseña = listUsuarios.get(id).getContraseña();
			if (String.valueOf(pswContraseña.getPassword()).equals(contraseña)) {
				pswContraseña.setBorder(bordeVerde);
				btnAceptar.requestFocus();
				btnAceptar.setEnabled(true);
				lblCheckContraseña.setText("Contraseña Correcta");
				pswContraseña.setEnabled(false);
				btnCancelar.setEnabled(false);
			} else {
				pswContraseña.setBorder(bordeRojo);
				pswContraseña.requestFocus();
				lblCheckContraseña.setText("Contraseña Incorrrecta");
			}
		}
	}

	private class BtnNuevoUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int size = 0;
				if (listUsuarios.size() != 0) {
					size = listUsuarios.size() + 1;
				}
				Usuario u = new Usuario(size, null, null, null, null, null, null, null, null,null);
				JFrameNuevoUsario i = new JFrameNuevoUsario(u, listUsuarios, frmVentanaLogIn);
				i.setVisible(true);
				frmVentanaLogIn.dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pswContraseña.setText("");
			txtUsuario.setText("");
			pswContraseña.setBorder(bordeNegro);
			txtUsuario.setBorder(bordeNegro);
			pswContraseña.setEnabled(false);
			lblContrasea.setEnabled(false);
			btnAceptar.setEnabled(false);
			txtUsuario.setEnabled(true);
		}
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				JFrameTareas t = new JFrameTareas(listUsuarios.get(id), listUsuarios);
				t.setVisible(true);
				frmVentanaLogIn.dispose();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}
