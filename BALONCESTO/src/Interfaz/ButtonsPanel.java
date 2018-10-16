package Interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonsPanel extends JPanel implements ActionListener{

	private JButton search;
	private JButton delete;
	private JButton modified;
	private JButton create;
	private PrincipalWindow w;
	
 ButtonsPanel(PrincipalWindow w) {
		super();
		this.w = w;
		this.search = new JButton("Buscar Jugador");
		this.delete = new JButton("Eliminar Jugador");
		this.modified = new JButton("Modificar Jugador");
		this.create = new JButton("Agregar Nuevo Jugador");
		
		setLayout(new GridLayout(1,4));
		add(search);
		add(delete);
		add(modified);
		add(create);
		
		create.addActionListener(this);
		create.setActionCommand("Agregar");
		delete.addActionListener(this);
		delete.setActionCommand("Eliminar");
		modified.addActionListener(this);
		modified.setActionCommand("Modificar");
		search.addActionListener(this);
		search.setActionCommand("Buscar");
	}

	public JButton getSearch() {
		return search;
	}


	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getModified() {
		return modified;
	}

	public void setModified(JButton modified) {
		this.modified = modified;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String aux = e.getActionCommand();
		
		switch(aux){
		
		case "Buscar" :
			
			break;
			
		case "Eliminar":
			
			break;
			
		case "Modificar":
			
			w.modifiedPlayer();
			
			break;
			
		case "Agregar":
			
			w.addPlayer();
			break;
					
		}
		
	}

	
}
