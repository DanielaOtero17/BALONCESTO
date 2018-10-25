package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Player;

import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Datos extends JPanel implements ActionListener{
	
	public static final String GUARDAR = "guardar";
	
	private JLabel avatar;

	private JTextField nombre;
	
    private JTextField edad;
	
	private JTextField equipo;
	
	private JTextField puntos;
	
	private JTextField rebotes;
	
	private JTextField asistencias;
	
	private JTextField robos;
	
	private JTextField bloqueos;
	
	private JTextField porcentaje;
	
	
	private JButton guardar;
	
	
	private InterfazMain principal;
	
	public Datos(InterfazMain principal){
		
		this.principal=principal;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Date Players", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		
		JPanel aux4 = new JPanel();
			
		aux4.setLayout(new GridLayout(2,1,10,10));
		
		JPanel aux = new JPanel();
		aux.setLayout(new BorderLayout());
		
		ImageIcon icono = new ImageIcon( "data/icono.jpg" );
		avatar = new JLabel( "" );
		avatar.setHorizontalAlignment(SwingConstants.CENTER);
		avatar.setIcon( icono );
	    aux.add( avatar );
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(9,2,10,5));
		
		JLabel n = new JLabel("Nombre: ");
		JLabel y = new JLabel("Edad: ");
		JLabel t = new JLabel("Equipo: ");
		JLabel p = new JLabel("Puntos por partido: ");
		JLabel re = new JLabel("Rebotes por partido: ");
		JLabel a = new JLabel("Asitencias por partido: ");
		JLabel ro = new JLabel("Robos por partido: ");
		JLabel b = new JLabel("Bloqueos por Partido: ");
		JLabel po = new JLabel("Porcentaje de exito: ");
		
		
		
		nombre = new JTextField();
		edad = new JTextField();
		equipo = new JTextField();
		puntos = new JTextField();
		rebotes = new JTextField();
		asistencias = new JTextField();
		robos = new JTextField();
		bloqueos = new JTextField();
		porcentaje = new JTextField();
		
		aux2.add(n);
		aux2.add(nombre);
		
		aux2.add(y);
		aux2.add(edad);
		
		aux2.add(t);
		aux2.add(equipo);
		
		aux2.add(p);
		aux2.add(puntos);
		
		aux2.add(re);
		aux2.add(rebotes);
		
		aux2.add(a);
		aux2.add(asistencias);
		
		aux2.add(ro);
		aux2.add(robos);
		
		aux2.add(b);
		aux2.add(bloqueos);
		
		aux2.add(po);
		aux2.add(porcentaje);
		
		aux4.add(aux);
		aux4.add(aux2);
		
		JPanel aux3 = new JPanel();
		
		guardar = new JButton("Save");
		guardar.setActionCommand(GUARDAR);
		guardar.addActionListener(this);
		aux3.setLayout(new GridLayout(1, 3, 10, 30));
		
		aux3.add(new JLabel());
		
		aux3.add(guardar);
		
		aux3.add(new JLabel());
		
		add(aux4,BorderLayout.CENTER);
		add(aux3,BorderLayout.SOUTH);
		
		deshabilitar();
	}
	
	public void mostrarDatos(Player p){
		
		nombre.setText(p.getName());
		edad.setText("" + p.getYears());
		equipo.setText(p.getTeam());
		puntos.setText("" + p.getMatchPoints());
		rebotes.setText("" + p.getMatchRebounds());
		asistencias.setText("" + p.getMatchAssistances());
		robos.setText("" + p.getMatchTheft());
		bloqueos.setText("" + p.getMatchBlocking());
		porcentaje.setText("" + p.getMatchPercent());
	}
	
	public void habilitar(){
		
		nombre.setEditable(true);
		edad.setEditable(true);
		equipo.setEditable(true);
		puntos.setEditable(true);
		rebotes.setEditable(true);
		asistencias.setEditable(true);
		robos.setEditable(true);
		bloqueos.setEditable(true);
		porcentaje.setEditable(true);
		guardar.setEnabled(true);
	}
	
	public void deshabilitar(){
		nombre.setEditable(false);
		edad.setEditable(false);
		equipo.setEditable(false);
		puntos.setEditable(false);
		rebotes.setEditable(false);
		asistencias.setEditable(false);
		robos.setEditable(false);
		bloqueos.setEditable(false);
		porcentaje.setEditable(false);
		guardar.setEnabled(false);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(GUARDAR)){
			principal.guardar();
			deshabilitar();
		}
	}

	public String getNombre() {
		return nombre.getText();
	}

	public int getEdad() {
		return Integer.parseInt(edad.getText());
	}

	public String getEquipo() {
		return equipo.getText();
	}

	public double getPuntos() {
		return Double.parseDouble(puntos.getText());
	}

	public int getRebotes() {
		return Integer.parseInt(rebotes.getText());
	}

	public int getAsistencias() {
		return Integer.parseInt(asistencias.getText());
	}

	public int getRobos() {
		return Integer.parseInt(robos.getText());
	}

	public int getBloqueos() {
		return Integer.parseInt(bloqueos.getText());
	}

	public double getPorcentaje() {
		return Double.parseDouble(porcentaje.getText());
	}
	
	
}


