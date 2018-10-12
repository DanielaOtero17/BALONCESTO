package Interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonsPanel extends JPanel implements ActionListener{

	private JButton search;
	private JButton delete;
	private JButton modified;
	
		
	public ButtonsPanel() {
		super();
		this.search = new JButton("Buscar Jugador");
		this.delete = new JButton("Eliminar Jugador");
		this.modified = new JButton("Modificar Jugador");
		
		setLayout(new GridLayout(1,3));
		add(search);
		add(delete);
		add(modified);
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
		// TODO Auto-generated method stub
		
	}

	
}
