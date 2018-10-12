package Interfaz;

import java.awt.*;
import javax.swing.*;

public class PrincipalWindow extends JFrame{

	private PlayerPanel pPlayer;
	private ButtonsPanel buttons;

	private String data;

	public PrincipalWindow() {
		
		pPlayer = new PlayerPanel(this);
		buttons = new ButtonsPanel();
		data = "Hola";

		
		
		setSize(1000,700);
		setResizable(false);
		setTitle("B A L O N C E S T O ~ ~ ~ ~ ~ ~ ~ ~  B I E N V E N I D O  ~ ~ ~ ~ ~ ~ ~ ~  B A L O N C E S T O");
		
		setLayout(new BorderLayout());
		add(pPlayer,BorderLayout.CENTER);
		
		}
	
	
	
	
	
	public static void main(String[] args) {
		
		PrincipalWindow principal = new PrincipalWindow();
		principal.setVisible(true);
	}
}
