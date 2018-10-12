package Interfaz;

import java.awt.*;
import javax.swing.*;


public class PlayerPanel extends JPanel {
	
	
	private JScrollBar bar;
	private PrincipalWindow pw;
	
	public PlayerPanel(PrincipalWindow pw) {
		
		this.pw = pw;
		
		bar = new JScrollBar();
		setSize(100,200);
		add(bar);
		
	}
	
	
	

}
