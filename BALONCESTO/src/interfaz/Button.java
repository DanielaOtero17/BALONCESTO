package interfaz;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.io.IOException;

public class Button extends JPanel implements ActionListener {
	
	public static final String AGREGAR = "agregar";
	public static final String BUSCAR = "buscar";
	public static final String ELIMINAR = "eliminar";
	public static final String EDITAR = "editar";
	public static final String CARGAR = "cargar";
	
	private JButton agregar;
	private JButton buscar;
	private JButton eliminar;
	private JButton editar;
	private JButton cargar;
	
	private InterfazMain principal;
	
	public Button(InterfazMain principal) {
		
		this.principal=principal;
		setBorder(new TitledBorder(null, "Options", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		setLayout(new GridLayout(1, 5, 0, 0));
		
		agregar = new JButton("Add");
		agregar.setActionCommand(AGREGAR);
		agregar.addActionListener(this);
		add(agregar);
		
		buscar = new JButton("Search");
		buscar.setActionCommand(BUSCAR);
		buscar.addActionListener(this);
		add(buscar);
		
		eliminar = new JButton("Delete");
		eliminar.setActionCommand(ELIMINAR);
		eliminar.addActionListener(this);
		add(eliminar);
		
		editar = new JButton("Edit");
		editar.setActionCommand(EDITAR);
		editar.addActionListener(this);
		add(editar);
		
		cargar = new JButton("Load");
		cargar.setActionCommand(CARGAR);
		cargar.addActionListener(this);
		add(cargar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(BUSCAR)){
			principal.buscar();
		}
		

		else if(comando.equals(AGREGAR)){
			principal.AgregarPlayer();
		}

		else if(comando.equals(ELIMINAR)){
			principal.EliminarPlayer();
		}
		
		else if(comando.equals(EDITAR)){
			principal.editar();
		}

		else if(comando.equals(CARGAR)){
			try {
				principal.cargar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
