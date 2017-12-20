package PresentacionV1;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import DominioV1.ImageFilter;
import DominioV1.LecturaEscritura;
import DominioV1.Usuario;

import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class JPanelDatosUsuario extends JPanel {
	private JLabel lblNombreUsuario;
	private JLabel lblNombreRealUsuario;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JLabel lblRepitaLaContrasea;
	private JTextField txtNombreUsuario;
	private JTextField txtNombreReal;
	private JTextField txtEmail;
	private JPasswordField pswContraseña;
	private JPasswordField pswRepetirContraseña;
	private JLabel lblNombreRepetido;
	private JLabel lblContraseñaTamaño;
	private JLabel lblContraseñasIguales;
	private String nombre;
	private String contraseña;
	private String contraseñaRep;
	private int numeroContraseña = 5;
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private Border bordeNegro = BorderFactory.createLineBorder(Color.GRAY);
	private JPanel pnlFoto;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JButton btnCargarImagen;
	private JTextField txtApellidos;
	private JLabel lblReal;
	private Usuario usuario;
	private ArrayList<Usuario> users;
	private JLabel lblApell;
	private JLabel lblEma;
	private JLabel lblNuevoUser;
	private boolean existente = false;
	private JPanel pnlBotones;
	private JFrame contentPane;
	private JButton btnVolverAlLogin;
	private JButton btnIniciarLaAplicaion;
	private JFrame login;
	private JPanel pnlImg;
	private JLabel lblFoto;
	private JFrame frame;

	public JPanelDatosUsuario() {
		setBounds(new Rectangle(0, 0, 800, 800));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Personal",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 812, 0 };
		gridBagLayout.rowHeights = new int[] { 372, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlFoto = new JPanel();
		pnlFoto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Usuario",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlFoto = new GridBagConstraints();
		gbc_pnlFoto.anchor = GridBagConstraints.WEST;
		gbc_pnlFoto.fill = GridBagConstraints.VERTICAL;
		gbc_pnlFoto.insets = new Insets(0, 0, 5, 0);
		gbc_pnlFoto.gridx = 0;
		gbc_pnlFoto.gridy = 0;
		add(pnlFoto, gbc_pnlFoto);
		GridBagLayout gbl_pnlFoto = new GridBagLayout();
		gbl_pnlFoto.columnWidths = new int[] { 0, 60, 0, 128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlFoto.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 0, 0, 0, 0, 0 };
		gbl_pnlFoto.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlFoto.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0,
				1.0, Double.MIN_VALUE };
		pnlFoto.setLayout(gbl_pnlFoto);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		pnlFoto.add(scrollPane, gbc_scrollPane);

		pnlImg = new JPanel();
		scrollPane.setViewportView(pnlImg);

		lblFoto = new JLabel("");
		pnlImg.add(lblFoto);

		btnCargarImagen = new JButton("Cargar Imagen");
		btnCargarImagen.setToolTipText("Pulse para seleccionar la imagen");
		btnCargarImagen.addActionListener(new BtnCargarImagenActionListener());

		lblNombreUsuario = new JLabel("Nombre Usuario:");
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 3;
		gbc_lblNombreUsuario.gridy = 1;
		pnlFoto.add(lblNombreUsuario, gbc_lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		GridBagConstraints gbc_txtNombreUsuario = new GridBagConstraints();
		gbc_txtNombreUsuario.fill = GridBagConstraints.BOTH;
		gbc_txtNombreUsuario.gridwidth = 6;
		gbc_txtNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreUsuario.gridx = 5;
		gbc_txtNombreUsuario.gridy = 1;
		pnlFoto.add(txtNombreUsuario, gbc_txtNombreUsuario);
		txtNombreUsuario.addKeyListener(new TxtNombreUsuarioKeyListener());
		txtNombreUsuario.addActionListener(new TxtNombreUsuarioActionListener());
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.addFocusListener(new MiFocusListener());

		lblNombreRepetido = new JLabel("");
		GridBagConstraints gbc_lblNombreRepetido = new GridBagConstraints();
		gbc_lblNombreRepetido.gridwidth = 6;
		gbc_lblNombreRepetido.fill = GridBagConstraints.BOTH;
		gbc_lblNombreRepetido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreRepetido.gridx = 12;
		gbc_lblNombreRepetido.gridy = 1;
		pnlFoto.add(lblNombreRepetido, gbc_lblNombreRepetido);

		lblNombreRealUsuario = new JLabel("Nombre Real Usuario:");
		GridBagConstraints gbc_lblNombreRealUsuario = new GridBagConstraints();
		gbc_lblNombreRealUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreRealUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreRealUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreRealUsuario.gridx = 3;
		gbc_lblNombreRealUsuario.gridy = 3;
		pnlFoto.add(lblNombreRealUsuario, gbc_lblNombreRealUsuario);

		txtNombreReal = new JTextField();
		GridBagConstraints gbc_txtNombreReal = new GridBagConstraints();
		gbc_txtNombreReal.fill = GridBagConstraints.BOTH;
		gbc_txtNombreReal.gridwidth = 6;
		gbc_txtNombreReal.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreReal.gridx = 5;
		gbc_txtNombreReal.gridy = 3;
		pnlFoto.add(txtNombreReal, gbc_txtNombreReal);
		txtNombreReal.addKeyListener(new TxtNombreRealKeyListener());
		txtNombreReal.setColumns(10);
		txtNombreReal.addFocusListener(new MiFocusListener());

		lblReal = new JLabel("");
		GridBagConstraints gbc_lblReal = new GridBagConstraints();
		gbc_lblReal.fill = GridBagConstraints.BOTH;
		gbc_lblReal.gridwidth = 7;
		gbc_lblReal.insets = new Insets(0, 0, 5, 5);
		gbc_lblReal.gridx = 11;
		gbc_lblReal.gridy = 3;
		pnlFoto.add(lblReal, gbc_lblReal);

		lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 3;
		gbc_lblApellidos.gridy = 5;
		pnlFoto.add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 6;
		gbc_txtApellidos.fill = GridBagConstraints.BOTH;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 5;
		gbc_txtApellidos.gridy = 5;
		pnlFoto.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.addKeyListener(new TxtApellidosKeyListener());
		txtApellidos.setColumns(10);
		txtApellidos.addFocusListener(new MiFocusListener());

		lblApell = new JLabel("");
		GridBagConstraints gbc_lblApell = new GridBagConstraints();
		gbc_lblApell.fill = GridBagConstraints.BOTH;
		gbc_lblApell.gridwidth = 7;
		gbc_lblApell.insets = new Insets(0, 0, 5, 5);
		gbc_lblApell.gridx = 11;
		gbc_lblApell.gridy = 5;
		pnlFoto.add(lblApell, gbc_lblApell);

		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.VERTICAL;
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 3;
		gbc_lblEmail.gridy = 7;
		pnlFoto.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.gridwidth = 6;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 5;
		gbc_txtEmail.gridy = 7;
		pnlFoto.add(txtEmail, gbc_txtEmail);
		txtEmail.addKeyListener(new TxtEmailKeyListener());
		txtEmail.setColumns(10);
		txtEmail.addFocusListener(new MiFocusListener());

		lblEma = new JLabel("");
		GridBagConstraints gbc_lblEma = new GridBagConstraints();
		gbc_lblEma.fill = GridBagConstraints.BOTH;
		gbc_lblEma.gridwidth = 7;
		gbc_lblEma.insets = new Insets(0, 0, 5, 5);
		gbc_lblEma.gridx = 11;
		gbc_lblEma.gridy = 7;
		pnlFoto.add(lblEma, gbc_lblEma);

		lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.fill = GridBagConstraints.VERTICAL;
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 3;
		gbc_lblContrasea.gridy = 9;
		pnlFoto.add(lblContrasea, gbc_lblContrasea);

		pswContraseña = new JPasswordField();
		GridBagConstraints gbc_pswContraseña = new GridBagConstraints();
		gbc_pswContraseña.fill = GridBagConstraints.BOTH;
		gbc_pswContraseña.gridwidth = 6;
		gbc_pswContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_pswContraseña.gridx = 5;
		gbc_pswContraseña.gridy = 9;
		pnlFoto.add(pswContraseña, gbc_pswContraseña);
		pswContraseña.addKeyListener(new PswContraseñaKeyListener());
		pswContraseña.addFocusListener(new MiFocusListener());

		lblContraseñaTamaño = new JLabel("");
		GridBagConstraints gbc_lblContraseñaTamaño = new GridBagConstraints();
		gbc_lblContraseñaTamaño.fill = GridBagConstraints.VERTICAL;
		gbc_lblContraseñaTamaño.gridwidth = 7;
		gbc_lblContraseñaTamaño.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseñaTamaño.gridx = 11;
		gbc_lblContraseñaTamaño.gridy = 9;
		pnlFoto.add(lblContraseñaTamaño, gbc_lblContraseñaTamaño);

		lblRepitaLaContrasea = new JLabel("Repita La Contraseña:");
		GridBagConstraints gbc_lblRepitaLaContrasea = new GridBagConstraints();
		gbc_lblRepitaLaContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblRepitaLaContrasea.fill = GridBagConstraints.VERTICAL;
		gbc_lblRepitaLaContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepitaLaContrasea.gridx = 3;
		gbc_lblRepitaLaContrasea.gridy = 11;
		pnlFoto.add(lblRepitaLaContrasea, gbc_lblRepitaLaContrasea);

		pswRepetirContraseña = new JPasswordField();
		GridBagConstraints gbc_pswRepetirContraseña = new GridBagConstraints();
		gbc_pswRepetirContraseña.fill = GridBagConstraints.BOTH;
		gbc_pswRepetirContraseña.gridwidth = 6;
		gbc_pswRepetirContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_pswRepetirContraseña.gridx = 5;
		gbc_pswRepetirContraseña.gridy = 11;
		pnlFoto.add(pswRepetirContraseña, gbc_pswRepetirContraseña);
		pswRepetirContraseña.setEnabled(false);
		pswRepetirContraseña.addActionListener(new PswRepetirContraseñaActionListener());
		pswRepetirContraseña.addFocusListener(new MiFocusListener());

		lblContraseñasIguales = new JLabel("");
		GridBagConstraints gbc_lblContraseñasIguales = new GridBagConstraints();
		gbc_lblContraseñasIguales.fill = GridBagConstraints.VERTICAL;
		gbc_lblContraseñasIguales.gridwidth = 6;
		gbc_lblContraseñasIguales.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseñasIguales.gridx = 12;
		gbc_lblContraseñasIguales.gridy = 11;
		pnlFoto.add(lblContraseñasIguales, gbc_lblContraseñasIguales);
		btnCargarImagen.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/PresentacionV1/cargarFoto.png")));
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.fill = GridBagConstraints.BOTH;
		gbc_btnCargarImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarImagen.gridx = 1;
		gbc_btnCargarImagen.gridy = 13;
		pnlFoto.add(btnCargarImagen, gbc_btnCargarImagen);

		btnBorrar = new JButton("Borrar campos");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.gridwidth = 2;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 3;
		gbc_btnBorrar.gridy = 13;
		pnlFoto.add(btnBorrar, gbc_btnBorrar);
		btnBorrar.setToolTipText("Borrar todos los datos introducidos");
		btnBorrar.addActionListener(new BtnBorrarActionListener());

		btnGuardar = new JButton("Crear usario");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 8;
		gbc_btnGuardar.gridy = 13;
		pnlFoto.add(btnGuardar, gbc_btnGuardar);
		btnGuardar.setToolTipText("Crear /Modificar usuario");
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setEnabled(false);

		lblNuevoUser = new JLabel("");
		GridBagConstraints gbc_lblNuevoUser = new GridBagConstraints();
		gbc_lblNuevoUser.gridwidth = 8;
		gbc_lblNuevoUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoUser.gridx = 10;
		gbc_lblNuevoUser.gridy = 13;
		pnlFoto.add(lblNuevoUser, gbc_lblNuevoUser);

		pnlBotones = new JPanel();
		pnlBotones
				.setBorder(new TitledBorder(null, "InicioSesion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlBotones = new GridBagConstraints();
		gbc_pnlBotones.fill = GridBagConstraints.BOTH;
		gbc_pnlBotones.gridx = 0;
		gbc_pnlBotones.gridy = 1;
		add(pnlBotones, gbc_pnlBotones);
		GridBagLayout gbl_pnlBotones = new GridBagLayout();
		gbl_pnlBotones.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlBotones.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_pnlBotones.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlBotones.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlBotones.setLayout(gbl_pnlBotones);
		pnlBotones.setVisible(false);

		btnVolverAlLogin = new JButton("Volver al login");
		btnVolverAlLogin.setToolTipText("Regresa al Login");
		btnVolverAlLogin.addActionListener(new BtnVolverAlLoginActionListener());
		GridBagConstraints gbc_btnVolverAlLogin = new GridBagConstraints();
		gbc_btnVolverAlLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVolverAlLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolverAlLogin.gridx = 2;
		gbc_btnVolverAlLogin.gridy = 1;
		pnlBotones.add(btnVolverAlLogin, gbc_btnVolverAlLogin);

		btnIniciarLaAplicaion = new JButton("Iniciar la aplicaion ");
		btnIniciarLaAplicaion.setToolTipText("Inicia la aplicacion");
		btnIniciarLaAplicaion.addActionListener(new BtnIniciarLaAplicaionActionListener());
		GridBagConstraints gbc_btnIniciarLaAplicaion = new GridBagConstraints();
		gbc_btnIniciarLaAplicaion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIniciarLaAplicaion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarLaAplicaion.gridx = 15;
		gbc_btnIniciarLaAplicaion.gridy = 1;
		pnlBotones.add(btnIniciarLaAplicaion, gbc_btnIniciarLaAplicaion);

	}

	public void comprobar() {
		if (usuario.getNombre() != null) {
			btnGuardar.setText("Guardar Datos");
			btnGuardar.setVisible(true);
			existente = true;
			txtNombreUsuario.setText(usuario.getNombre());
			txtNombreReal.setText(usuario.getNombreReal());
			txtApellidos.setText(usuario.getApellidos());
			txtEmail.setText(usuario.getApellidos());
			pswContraseña.setText(usuario.getContraseña());
			lblFoto.setIcon(new ImageIcon(usuario.getImagen()));
		}
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

	private class TxtNombreUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (existente == false) {

				boolean salidaNombre = true;
				nombre = txtNombreUsuario.getText();
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getNombre().equals(nombre)) {
						salidaNombre = false;
						lblNombreRepetido.setText("Nombre de usuario repetido");
						txtNombreUsuario.setBorder(bordeRojo);
						nombre = null;
					}
				}
				if (salidaNombre == true) {
					lblNombreRepetido.setText("Nombre de usuario correcto");
					txtNombreUsuario.setBorder(bordeVerde);
				}
			} else {
				lblNombreRepetido.setText("Nombre de usuario correcto");
				txtNombreUsuario.setBorder(bordeVerde);
			}
		}
	}

	private class TxtNombreUsuarioKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() != KeyEvent.VK_ENTER) {
				lblNombreRepetido.setText("Pulse enter para confirmar nombre");
			}
		}
	}

	private class PswContraseñaKeyListener extends KeyAdapter {

		public void keyTyped(KeyEvent arg0) {
			contraseña = String.valueOf(pswContraseña.getPassword());
			int size = contraseña.length();
			if ((size + 1) >= numeroContraseña) {
				lblContraseñaTamaño.setText("Contraseña suficiente larga");
				pswContraseña.setBorder(bordeVerde);
				pswRepetirContraseña.setEnabled(true);

			} else {
				lblContraseñaTamaño.setText("Faltan :" + ((size + 1) - numeroContraseña) + " carcateres");
				pswContraseña.setBorder(bordeRojo);
			}

		}

	}

	private class PswRepetirContraseñaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			contraseñaRep = String.valueOf(pswRepetirContraseña.getPassword());
			contraseña = String.valueOf(pswContraseña.getPassword());
			if (contraseñaRep.equals(contraseña)) {
				pswRepetirContraseña.setBorder(bordeVerde);
				lblContraseñasIguales.setText("Contraseñas iguales");
				btnGuardar.setEnabled(true);
			} else {
				pswRepetirContraseña.setBorder(bordeRojo);
				lblContraseñasIguales.setText("Contraseñas distintas");
			}
		}
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			usuario.setNombre(txtNombreUsuario.getText());
			usuario.setApellidos(txtApellidos.getText());
			usuario.setContraseña(String.valueOf(pswRepetirContraseña.getPassword()));
			usuario.setEmail(txtEmail.getText());
			usuario.setNombreReal(lblReal.getText());

			btnBorrar.setEnabled(false);
			LecturaEscritura es = new LecturaEscritura();
			if (existente == false) {
				users.add(usuario);
				pnlBotones.setVisible(true);
				lblNuevoUser.setText("Usuario creado correctamente");
			} else {
				lblNuevoUser.setText("Usuario modificado correctamente");
			}
			es.BorrarContenidoFicheroUsuario();
			es.EscrituraFicheroUsuario(users);
		}
	}

	private class TxtNombreRealKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lblReal.setText(txtNombreReal.getText());
			} else {
				lblReal.setText("Pulse enter para confirmar nombre");
			}
		}

	}

	private class TxtApellidosKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lblApell.setText(txtApellidos.getText());
			} else {
				lblApell.setText("Pulse enter para confirmar apellidos");
			}
		}
	}

	private class TxtEmailKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				lblEma.setText(txtEmail.getText());
			} else {
				lblEma.setText("Pulse enter para confirmar email");
			}
		}
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtNombreUsuario.setText("");
			txtNombreReal.setText("");
			txtApellidos.setText("");
			txtEmail.setText("");
			pswContraseña.setText("");
			pswRepetirContraseña.setText("");
			pswRepetirContraseña.setEnabled(false);
			pswContraseña.setBorder(bordeNegro);
			txtNombreUsuario.setBorder(bordeNegro);
			lblApell.setText("");
			lblContraseñasIguales.setText("");
			lblNombreRepetido.setText("");
			lblContraseñaTamaño.setText("");
			lblReal.setText("");
			lblEma.setText("");
			pswRepetirContraseña.setBorder(bordeNegro);
		}
	}

	private class BtnIniciarLaAplicaionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFrameTareas t = new JFrameTareas(usuario, users);
			t.setVisible(true);
			contentPane.dispose();
		}
	}

	private class BtnVolverAlLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaLogIn n = new VentanaLogIn();
			n.getfrmVentanaLogIn().setVisible(true);
			contentPane.dispose();
		}
	}

	private class BtnCargarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = null;
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				file = fcAbrir.getSelectedFile();
				JOptionPane.showMessageDialog(frame, "Fichero seleccionado: " + file.getName());
				lblFoto.setIcon(new ImageIcon(file.getAbsolutePath()));
				usuario.setImagen(file.getAbsolutePath());
			}

		}
	}

	public void setJFrame(JFrame pane) {
		contentPane = pane;
	}

	public void setJFrameLogin(JFrame frame) {
		login = frame;
	}

	public void setUsuario(Usuario user) {
		usuario = user;
	}

	public void setArrayListUsuario(ArrayList<Usuario> us) {
		users = us;
	}

}
