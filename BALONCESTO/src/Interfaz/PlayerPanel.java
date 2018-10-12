package Interfaz;

import java.awt.*;
import javax.swing.*;


public class PlayerPanel extends JPanel {
	
	

	private PrincipalWindow pw;
	private List l;
	private JList list;
	
	public PlayerPanel(PrincipalWindow pw) {
		
		this.pw = pw;
		l = new List();

		for(int i=1; i<=100; i++){
			
			l.add("Jugador" + i);
		}
		
		
		
	
		JPanel aux = new JPanel();
		
		list = new JList();
		list.add(l);
		
		setLayout(new BorderLayout());
		add(l, BorderLayout.CENTER);
		
	}
	
	
	

}
