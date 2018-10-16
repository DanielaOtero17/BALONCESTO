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
	private JTextField n;
	private JTextField a1;
	private JTextField t1;
	private JTextField as1;
	private JTextField p1;
	private JTextField r1;
	private JTextField ro1;
	private JTextField bl1;
	
	
	public PrincipalWindow() {		
		pPlayer = new PlayerPanel(this);
		buttons = new ButtonsPanel(this);
		playerList = new ArrayList<>();
		counter = 0;
				
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
	
	public void modifiedPlayer(){
		String name = pPlayer.getL().getSelectedItem();
		System.out.println(name);
		boolean encontrado = false;
			while(encontrado == false && counter < playerList.size()){
				if(name.equalsIgnoreCase(playerList.get(counter).getName())){
					encontrado = true;}
				counter ++;}		
		if(encontrado){
		JLabel n1 = new JLabel("Nombre : ");
		n = new JTextField( playerList.get(counter-1).getName());
		JLabel a = new JLabel("Edad : ");
		a1 = new JTextField(playerList.get(counter-1).getYears() +"");
		JLabel t = new JLabel("Equipo : ");
		t1 = new JTextField( playerList.get(counter-1).getTeam());
		JLabel as = new JLabel("Asistencias : ");
		as1 = new JTextField(playerList.get(counter-1).getMatchAssistances() + "");
		JLabel p = new JLabel("Puntos : ");
		p1 = new JTextField(playerList.get(counter-1).getMatchPoints() + "");
		JLabel r = new JLabel("Rebotes : ");
		r1 = new JTextField( playerList.get(counter-1).getMatchRebounds() + "");
		JLabel ro= new JLabel("Robos : ");
		 ro1 = new JTextField(playerList.get(counter-1).getMatchTheft() + "");
		JLabel bl= new JLabel("Bloqueos : ");
		 bl1 = new JTextField( playerList.get(counter-1).getMatchBlocking() + "");
		JButton exit = new JButton("Salir");
		JButton edit = new JButton("Guardar Cambios");
		Panel aux = new Panel();
		aux.setLayout(new GridLayout(10,2));
		aux.add(n1);
		aux.add(n);
		aux.add(a);
		aux.add(a1);
		aux.add(t);
		aux.add(t1);
		aux.add(as);
		aux.add(as1);
		aux.add(p);
		aux.add(p1);
		aux.add(r);
		aux.add(r1);
		aux.add(ro);
		aux.add(ro1);
		aux.add(bl);
		aux.add(bl1);
		aux.add(exit);
		aux.add(edit);
		
		auxiliary = new PrincipalWindow();
		auxiliary.setSize(500,500);
		auxiliary.setLayout(new BorderLayout());
		auxiliary.setTitle("Modificar Jugador");
		
		auxiliary.add(aux, BorderLayout.CENTER);
		this.setVisible(false);
		auxiliary.setVisible(true);
		
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		edit.setActionCommand("Edit");
		edit.addActionListener(this);

		
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
	
	public void editPlayer(JTextField a, JTextField b, JTextField c,JTextField d,JTextField 
			e,JTextField f,JTextField g,JTextField h){
		
		
		playerList.get(counter-1).setName(a.getText());
		playerList.get(counter-1).setYears(Integer.parseInt(b.getText()));
		playerList.get(counter-1).setTeam(c.getText());
		playerList.get(counter-1).setMatchAssistances(Integer.parseInt(d.getText()));
		playerList.get(counter-1).setMatchPoints(Double.parseDouble(e.getText()));
		playerList.get(counter-1).setMatchRebounds(Integer.parseInt(f.getText()));
		playerList.get(counter-1).setMatchTheft(Integer.parseInt(g.getText()));
		playerList.get(counter-1).setMatchBlocking(Integer.parseInt(h.getText()));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String l = e.getActionCommand();
	
	if(l.equals("Exit")){
		
		this.setVisible(true);
		auxiliary.setVisible(false);
		
	}else if(l.equals("Edit")){
		
		editPlayer(n,a1,t1,as1,p1,r1,ro1,bl1);
	
	}
		
	}

	public static void main(String[] args) {
		
		PrincipalWindow principal = new PrincipalWindow();
		principal.setVisible(true);
		
	}

	
}
