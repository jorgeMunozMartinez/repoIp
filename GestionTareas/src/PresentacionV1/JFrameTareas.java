package PresentacionV1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DominioV1.Mensaje;
import DominioV1.Tarea;
import DominioV1.Usuario;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class JFrameTareas extends JFrame {

	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTree tree;
	private JPanel pnlTabbedInformacion;
	private JLabel lblInformacionInicio;
	private JTabbedPane tabbedPane;
	private JPanelTareas pnlGestorTareas;
	private JPanelDatosUsuario pnlGestorUsuario;
	private JPanelMensaje pnlGestorMensajes;
	private JPanelEnvioMensaje pnlEnvioMensajes;
	private int indiceTarea;

	private ArrayList<Tarea> tareasU= new ArrayList<Tarea>();

	public JFrameTareas(Usuario u, ArrayList<Usuario> users) {

		getContentPane().setBounds(new Rectangle(0, 0, 850, 850));
		setBounds(new Rectangle(0, 0, 900, 900));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 957, 526);

		JPanel panelCard = new JPanel();
		panelCard.setBounds(new Rectangle(0, 0, 825, 825));
		getContentPane().add(panelCard, BorderLayout.CENTER);
		panelCard.setLayout(new CardLayout(0, 0));

		splitPane = new JSplitPane();
		panelCard.add(splitPane, "name_163211111952370");

		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		tree = new JTree();
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		RellenarArbol(u);
		scrollPane.setViewportView(tree);

		pnlTabbedInformacion = new JPanel();
		splitPane.setRightComponent(pnlTabbedInformacion);
		GridBagLayout gbl_pnlTabbedInformacion = new GridBagLayout();
		gbl_pnlTabbedInformacion.columnWidths = new int[] { 825, 0 };
		gbl_pnlTabbedInformacion.rowHeights = new int[] { 437, 0, 0 };
		gbl_pnlTabbedInformacion.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTabbedInformacion.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		pnlTabbedInformacion.setLayout(gbl_pnlTabbedInformacion);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		pnlTabbedInformacion.add(tabbedPane, gbc_tabbedPane);

		pnlGestorTareas = new JPanelTareas();
		pnlGestorTareas.setArrayListUsuarios(users);
		pnlGestorTareas.setUsuario(u);
		pnlGestorTareas.setFramePadre(this);
		tabbedPane.addTab("Gestor Tareas", null, pnlGestorTareas, null);
		pnlGestorTareas.setLayout(new CardLayout(0, 0));

		pnlGestorUsuario = new JPanelDatosUsuario();
		pnlGestorUsuario.setUsuario(u);
		pnlGestorUsuario.setArrayListUsuario(users);
		pnlGestorUsuario.setJFrame(this);
		pnlGestorUsuario.comprobar();
		tabbedPane.addTab("Gestor Usuario", null, pnlGestorUsuario, null);
		pnlGestorUsuario.setLayout(new CardLayout(0, 0));

		pnlGestorMensajes = new JPanelMensaje();
		pnlGestorMensajes.setUsuario(u,users);
		tabbedPane.addTab("Mensajes", null, pnlGestorMensajes, null);

		pnlEnvioMensajes = new JPanelEnvioMensaje();
		tabbedPane.addTab("Nuevo Mensaje", null, pnlEnvioMensajes, null);
		pnlEnvioMensajes.setLayout(new CardLayout(0, 0));

		lblInformacionInicio = new JLabel("");
		GridBagConstraints gbc_lblInformacionInicio = new GridBagConstraints();
		gbc_lblInformacionInicio.gridx = 0;
		gbc_lblInformacionInicio.gridy = 1;
		pnlTabbedInformacion.add(lblInformacionInicio, gbc_lblInformacionInicio);
		Datos(u.getUltimaConexion(),tareasPrioridad(u), mensajesLeidos(u));

	}
	
	public int mensajesLeidos(Usuario user) {
		int mensajes = 0;
		if (user.getMensajes() != null) {
			ArrayList<Mensaje> m = user.getMensajes();
			for (int i = 0; i < m.size(); i++) {
				if (m.get(i).isLeido() == true) {
					mensajes++;
				}
			}
		}
		return mensajes;
	}

	public int tareasPrioridad(Usuario user) {
		int tareas = 0;
		if (user.getTareas() != null) {
			ArrayList<Tarea> t = user.getTareas();
			for (int i = 0; i < t.size(); i++) {
				if (t.get(i).getPrioridad() == 1) {
					tareas++;
				}
			}
		}

		return tareas;
	}
	
	public void EliminarTarea() {
		tareasU.remove(indiceTarea);
	}
	
	public void RellenarArbol(Usuario u) {
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Actividades") {
			{
				DefaultMutableTreeNode node_1;
				DefaultMutableTreeNode node_2;
				DefaultMutableTreeNode node_3;
				 tareasU = u.getTareas();
				for (int i = 0; i < tareasU.size(); i++) {				
					node_1 = new DefaultMutableTreeNode("Tarea " + (i+1));
					node_1.add(new DefaultMutableTreeNode(tareasU.get(i).getDescripion()));
					node_2=new DefaultMutableTreeNode("Trabajadores Tarea "+(i+1));
					ArrayList<String> p = tareasU.get(i).getParticipantes();
					for(int j=0;j<p.size();j++) {
						node_3=new DefaultMutableTreeNode(p.get(j));
						node_2.add(node_3);
					}
					node_1.add(node_2);
				add(node_1);
				}
			}
		}));
	}

	public void Datos(String u, int tareas, int mensajes) {
		
		String text = "Ultima conexión: " + u + " Tareas en prioridad maxima:" + tareas
				+ " Tiene " + mensajes + " mensajes si leer";
		lblInformacionInicio.setText(text);
	}
	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			char letra=0;
			String nodo = (arg0.getPath().getLastPathComponent()).toString();
			for (int i = 0; i < nodo.length(); i++){
			   letra  = nodo.charAt(i);
			}
			 indiceTarea=Character.getNumericValue(letra);
			pnlGestorTareas.setTarea(tareasU.get(indiceTarea-1));
			
		}
	}
}