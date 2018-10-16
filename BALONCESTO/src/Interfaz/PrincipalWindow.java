package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import javax.swing.*;
import java.util.*;

public class PrincipalWindow extends JFrame implements ActionListener{

	private PlayerPanel pPlayer;
	private ButtonsPanel buttons;
	private ArrayList<Player> playerList;
	private PrincipalWindow auxiliary;
	private int counter;
	private JLabel n;
	private JLabel a1;
	private JLabel t1;
	private JLabel as1;
	private JLabel p1;
	private JLabel r1;
	private JLabel ro1;
	private JLabel bl1;
	private boolean found;
	private int auxCounter;
	
	
	public PrincipalWindow() {		
		pPlayer = new PlayerPanel(this);
		buttons = new ButtonsPanel(this);
		playerList = new ArrayList<>();
		counter = 0;
		auxiliary = null;
		found = false;
				
		setSize(1000,700);
		setResizable(false);
		setTitle("B A L O N C E S T O ~ ~ ~ ~ ~ ~ ~ ~  B I E N V E N I D O  ~ ~ ~ ~ ~ ~ ~ ~  B A L O N C E S T O");
		
		setLayout(new BorderLayout());
		add(pPlayer,BorderLayout.CENTER);
		add(buttons,BorderLayout.NORTH);

		
		}
		
	public PlayerPanel getpPlayer() {
		return pPlayer;
	}

	public void setpPlayer(PlayerPanel pPlayer) {
		this.pPlayer = pPlayer;
	}

	public ButtonsPanel getButtons() {
		return buttons;
	}

	public void setButtons(ButtonsPanel buttons) {
		this.buttons = buttons;
	}
	
	public boolean searchPlayerList(){
		
		counter = 0;
		
		String name = pPlayer.getL().getSelectedItem();
		while(found == false && counter < playerList.size()){
			if(name.equalsIgnoreCase(playerList.get(counter).getName())){
				found = true;}
			
			counter ++;}	
		System.out.println(name);
		System.out.println(playerList.size());
		return found;
	}


	public void modifiedPlayer(){
		
		System.out.println("El contador es: " + counter);
		
		this.setVisible(false);
		auxiliary = new PrincipalWindow();
		
		boolean founder = searchPlayerList();

		if(founder){
		JLabel n1 = new JLabel("Nombre : ");
		
		
		
		n = new JLabel( playerList.get(counter-1).getName());
		JLabel a = new JLabel("Edad : ");
		a1 = new JLabel(playerList.get(counter-1).getYears() +"");
		JLabel t = new JLabel("Equipo : ");
		t1 = new JLabel( playerList.get(counter-1).getTeam());
		JLabel as = new JLabel("Asistencias : ");
		as1 = new JLabel(playerList.get(counter-1).getMatchAssistances() + "");
		JLabel p = new JLabel("Puntos : ");
		p1 = new JLabel(playerList.get(counter-1).getMatchPoints() + "");
		JLabel r = new JLabel("Rebotes : ");
		r1 = new JLabel( playerList.get(counter-1).getMatchRebounds() + "");
		JLabel ro= new JLabel("Robos : ");
		 ro1 = new JLabel(playerList.get(counter-1).getMatchTheft() + "");
		JLabel bl= new JLabel("Bloqueos : ");
		 bl1 = new JLabel( playerList.get(counter-1).getMatchBlocking() + "");
		JButton exit = new JButton("Salir");
		JButton edit = new JButton("Guardar Cambios");
		JButton e1 = new JButton("Editar");
		JButton e2 = new JButton("Editar");
		JButton e3 = new JButton("Editar");
		JButton e4 = new JButton("Editar");
		JButton e5 = new JButton("Editar");
		JButton e6 = new JButton("Editar");
		JButton e7 = new JButton("Editar");
		JButton e8 = new JButton("Editar");
		
		Panel aux = new Panel();
		aux.setLayout(new GridLayout(8,3));
		aux.add(n1);
		aux.add(n);
		aux.add(e1);
		aux.add(a);
		aux.add(a1);
		aux.add(e2);
		aux.add(t);
		aux.add(t1);
		aux.add(e3);
		aux.add(as);
		aux.add(as1);
		aux.add(e4);
		aux.add(p);
		aux.add(p1);
		aux.add(e5);
		aux.add(r);
		aux.add(r1);
		aux.add(e6);
		aux.add(ro);
		aux.add(ro1);
		aux.add(e7);
		aux.add(bl);
		aux.add(bl1);
		aux.add(e8);
		Panel la = new Panel();
		la.setSize(10,20);
		la.setLayout(new GridLayout(1,2));
		la.add(exit);
		la.add(edit);
		
		auxiliary.setSize(500,500);
		auxiliary.setLayout(new BorderLayout());
		auxiliary.setTitle("Modificar Jugador");
		
		auxiliary.add(aux, BorderLayout.CENTER);
		auxiliary.add(la, BorderLayout.SOUTH);
		
		
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		edit.setActionCommand("Edit");
		edit.addActionListener(this);
		e1.setActionCommand("Nombre");
		e1.addActionListener(this);
		e2.setActionCommand("Edad");
		e2.addActionListener(this);
		e3.setActionCommand("Equipo");
		e3.addActionListener(this);
		e4.setActionCommand("Asistencias");
		e4.addActionListener(this);
		e5.setActionCommand("Puntos");
		e5.addActionListener(this);
		e6.setActionCommand("Rebotes");
		e6.addActionListener(this);
		e7.setActionCommand("Robos");
		e7.addActionListener(this);
		e8.setActionCommand("Bloqueos");
		e8.addActionListener(this);

		auxiliary.setVisible(true);
		
		
		
		}
	
	}
	public void addPlayer(){
		
		String name = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador", "",3);
		String e= JOptionPane.showInputDialog(this, "Ingrese la edad del jugador", "",3);
		int age = Integer.parseInt(e);
		String team = JOptionPane.showInputDialog(this, "Ingrese el nombre del equipo del jugador", "",3);
		String po= JOptionPane.showInputDialog(this, "Ingrese los puntos por partido del jugador", "",3);
		double points = Double.parseDouble(po);
		String re = JOptionPane.showInputDialog(this, "Ingrese los rebotes por partido del jugador", "",3);
		int backs = Integer.parseInt(re);
		String as = JOptionPane.showInputDialog(this, "Ingrese el número de asistencias del jugador", "",3);
		int assist = Integer.parseInt(as);
		String ti = JOptionPane.showInputDialog(this, "Ingrese el número de robos del jugador", "",3);
		int tief = Integer.parseInt(ti);
		String bl = JOptionPane.showInputDialog(this, "Ingrese el número de bloqueos por partido del jugador", "",3);
		int block = Integer.parseInt(bl);
				
		Player p = new Player(name,age,team,points,backs,assist,tief,block);
		pPlayer.addNewElementList(p);
		playerList.add(p);
	}
	
	public void editPlayer(JLabel a, JLabel b, JLabel c,JLabel d,JLabel 
			e,JLabel f,JLabel g,JLabel h){
		
		
		playerList.get(counter-1).setName(a.getText());
		playerList.get(counter-1).setYears(Integer.parseInt(b.getText()));
		playerList.get(counter-1).setTeam(c.getText());
		playerList.get(counter-1).setMatchAssistances(Integer.parseInt(d.getText()));
		playerList.get(counter-1).setMatchPoints(Double.parseDouble(e.getText()));
		playerList.get(counter-1).setMatchRebounds(Integer.parseInt(f.getText()));
		playerList.get(counter-1).setMatchTheft(Integer.parseInt(g.getText()));
		playerList.get(counter-1).setMatchBlocking(Integer.parseInt(h.getText()));
		
		pPlayer.getL().setName(playerList.get(counter-1).getName());
		
		JOptionPane.showConfirmDialog(null, "Se han realizado los cambios");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String l = e.getActionCommand();
	
	switch(l){
		
		case "Exit":{
			
			this.setVisible(true);
			auxiliary.setVisible(false);
			
			break;
		}
		case "Edit":{
			
			editPlayer(n,a1,t1,as1,p1,r1,ro1,bl1);
			this.setVisible(true);
			auxiliary.setVisible(false);
			
			break;
		}
		case "Nombre":{
			
			String nam = JOptionPane.showInputDialog("Por favor ingrese el nuevo nombre");
			
		pPlayer.getL().remove(playerList.get(counter-1).getName());
		playerList.get(counter-1).setName(nam);
		System.out.println(playerList.get(counter-1).getName());
		n.setText(nam);
		pPlayer.getL().add(nam);	
		
		break;
		
		}
		case "Edad":{
			
		}
		case "Equipo":{
			
		}
		case "Asistencias":{
			
		}
		case "Puntos":{
			
		}
		case "Rebotes":{
			
		}
		case "Robos":{
			
		}
		case "Bloqueos":{
			
		}
	
	}

		
	}

	public static void main(String[] args) {
		
		PrincipalWindow principal = new PrincipalWindow();
		principal.setVisible(true);
		
	}

	
}
