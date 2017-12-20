package PresentacionV1;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;

public class JPanelEnvioMensaje extends JPanel {
	private JLabel lblAsunto;
	private JLabel lblDestinatario;
	private JLabel lblContendo;
	private JTextField txtDestinatario;
	private JTextField txtAsunto;
	private JTextField txtMensaje;
	private JPanel lblUsuarios;
	private JPanel panel;
	private JList list;
	private JButton btnEnviarMensaje;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public JPanelEnvioMensaje() {
		setBorder(new TitledBorder(null, "Nuevo Mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 30, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblUsuarios = new JPanel();
		lblUsuarios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.gridwidth = 21;
		gbc_lblUsuarios.gridheight = 9;
		gbc_lblUsuarios.fill = GridBagConstraints.BOTH;
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 0;
		add(lblUsuarios, gbc_lblUsuarios);
		GridBagLayout gbl_lblUsuarios = new GridBagLayout();
		gbl_lblUsuarios.columnWidths = new int[]{0, 0, 0, 0, 0, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_lblUsuarios.rowHeights = new int[]{0, 39, 0, 0, 0, 0};
		gbl_lblUsuarios.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_lblUsuarios.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		lblUsuarios.setLayout(gbl_lblUsuarios);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		lblUsuarios.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 4;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel.add(list, gbc_list);
		
		lblDestinatario = new JLabel("Destinatario:");
		GridBagConstraints gbc_lblDestinatario = new GridBagConstraints();
		gbc_lblDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatario.gridx = 3;
		gbc_lblDestinatario.gridy = 0;
		lblUsuarios.add(lblDestinatario, gbc_lblDestinatario);
		
		txtDestinatario = new JTextField();
		GridBagConstraints gbc_txtDestinatario = new GridBagConstraints();
		gbc_txtDestinatario.gridwidth = 9;
		gbc_txtDestinatario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_txtDestinatario.gridx = 5;
		gbc_txtDestinatario.gridy = 0;
		lblUsuarios.add(txtDestinatario, gbc_txtDestinatario);
		txtDestinatario.setColumns(10);
		
		lblAsunto = new JLabel("Asunto:");
		GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
		gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsunto.gridx = 3;
		gbc_lblAsunto.gridy = 1;
		lblUsuarios.add(lblAsunto, gbc_lblAsunto);
		
		txtAsunto = new JTextField();
		GridBagConstraints gbc_txtAsunto = new GridBagConstraints();
		gbc_txtAsunto.gridwidth = 9;
		gbc_txtAsunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_txtAsunto.gridx = 5;
		gbc_txtAsunto.gridy = 1;
		lblUsuarios.add(txtAsunto, gbc_txtAsunto);
		txtAsunto.setColumns(10);
		
		lblContendo = new JLabel("Contenido:");
		GridBagConstraints gbc_lblContendo = new GridBagConstraints();
		gbc_lblContendo.insets = new Insets(0, 0, 5, 5);
		gbc_lblContendo.gridx = 3;
		gbc_lblContendo.gridy = 2;
		lblUsuarios.add(lblContendo, gbc_lblContendo);
		
		txtMensaje = new JTextField();
		GridBagConstraints gbc_txtMensaje = new GridBagConstraints();
		gbc_txtMensaje.gridwidth = 9;
		gbc_txtMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensaje.gridx = 5;
		gbc_txtMensaje.gridy = 2;
		lblUsuarios.add(txtMensaje, gbc_txtMensaje);
		txtMensaje.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridwidth = 3;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 3;
		lblUsuarios.add(btnCancelar, gbc_btnCancelar);
		
		btnEnviarMensaje = new JButton("Enviar Mensaje");
		GridBagConstraints gbc_btnEnviarMensaje = new GridBagConstraints();
		gbc_btnEnviarMensaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviarMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnviarMensaje.gridx = 11;
		gbc_btnEnviarMensaje.gridy = 3;
		lblUsuarios.add(btnEnviarMensaje, gbc_btnEnviarMensaje);

	}

}
