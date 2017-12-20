package PresentacionV1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DominioV1.Usuario;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Rectangle;

public class JFrameNuevoUsario extends JFrame {

	private JPanelDatosUsuario contentPane;
	private Usuario u;
	private ArrayList<Usuario> users;

	public JFrameNuevoUsario(Usuario user, ArrayList<Usuario> us,JFrame login) {
		u = user;
		users = us;
		setBounds(new Rectangle(500, 500, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 538);
		contentPane = new JPanelDatosUsuario();
		contentPane.setUsuario(u);
		contentPane.setArrayListUsuario(users);
		contentPane.setBounds(new Rectangle(500, 500, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

	public void cerrar() {
		dispose();
	}

}
