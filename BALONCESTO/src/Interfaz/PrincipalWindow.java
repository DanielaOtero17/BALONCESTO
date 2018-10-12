package Interfaz;

import java.awt.*;
import javax.swing.*;

public class PrincipalWindow extends JFrame{


	public PrincipalWindow() {
		
		setSize(1000,700);
		setResizable(false);
		setTitle("B I E N V E N I D O  ~ ~ ~ ~ ~ ~ ~ ~  B A L O N C E S T O");
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		PrincipalWindow principal = new PrincipalWindow();
		principal.setVisible(true);
	}
}
