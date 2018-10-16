package Interfaz;

import java.awt.*;
import javax.swing.*;
import Model.*;


public class PlayerPanel extends JPanel{
	
	

	private PrincipalWindow pw;
	private List l;
	
	public PlayerPanel(PrincipalWindow pw) {
		
		this.pw = pw;
		l = new List();
	
		JPanel aux = new JPanel();

		setLayout(new BorderLayout());
		add(l, BorderLayout.CENTER);
		
	}
	
	public List getL(){
		
		return l;
	}
	public void addNewElementList(Player p){
		
		l.add(p.getName());
		
	}
	
	
	
	
	

}
