package Interfaz;

import java.awt.*;
import javax.swing.*;

public class PrincipalWindow extends JFrame{

	private PlayerPanel pPlayer;
	private JList list;
	private String data;

	public PrincipalWindow() {
		
		pPlayer = new PlayerPanel(this);
		data = "Hola";
		list = new JList();
		
		
		setSize(1000,700);
		setResizable(false);
		setTitle("B A L O N C E S T O ~ ~ ~ ~ ~ ~ ~ ~  B I E N V E N I D O  ~ ~ ~ ~ ~ ~ ~ ~  B A L O N C E S T O");
		
		add(list);
		add(pPlayer);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		PrincipalWindow principal = new PrincipalWindow();
		principal.setVisible(true);
	}
}
