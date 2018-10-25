package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Player;
import model.Programm_NBA;

public class InterfazMain extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Lista l;
	private Datos d;
	private Button b;
	
	private Programm_NBA pro;
	
	public InterfazMain(){
		
		pro = new Programm_NBA();
		
		setTitle("NBA ----> Reg_PLayers");
		setSize(600,600);
		setLocationRelativeTo(null);
		
		l = new Lista(this);
		d = new Datos(this);
		b = new Button(this);
		
		setLayout(new BorderLayout());
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1,2,10,5));
		
		aux.add(l);
		aux.add(d);
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new BorderLayout());
		aux2.add(b,BorderLayout.CENTER);
		
		add(aux,BorderLayout.CENTER);
		add(aux2,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		InterfazMain v = new InterfazMain();
		v.setVisible(true);
	}
	
	public void cargar() throws IOException {
		
		JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Empleados");
		int resultado = fc.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = fc.getSelectedFile();
			if (archivo != null) {
				File file = new File("data/" + archivo.getName());
				pro.cargar(file);
				l.updateList(pro.getParticipantes());
			}
		}
	}

	public void mostrarInformacion(Player p) {
		d.mostrarDatos(p);
	}
	
	public void EliminarPlayer(){
		Player p = l.getSelection();
		pro.delete(p.getMatchPoints());
		pro.deleteParticipante(p);
		l.updateList(pro.getParticipantes());
	}
	
	public void AgregarPlayer(){
		
		JLabel n = new JLabel("Nombre: ");
		JLabel y = new JLabel("Edad: ");
		JLabel t = new JLabel("Equipo: ");
		JLabel p = new JLabel("Puntos por partido: ");
		JLabel re = new JLabel("Rebotes por partido: ");
		JLabel a = new JLabel("Asitencias por partido: ");
		JLabel ro = new JLabel("Robos por partido: ");
		JLabel b = new JLabel("Bloqueos por Partido: ");
		JLabel po = new JLabel("Porcentaje de exito: ");
		
		JTextField nombre = new JTextField();
		JTextField puntos = new JTextField();
		JTextField edad = new JTextField();
		JTextField equipo = new JTextField();
		JTextField rebotes = new JTextField();
		JTextField asistencias = new JTextField();
		JTextField robos = new JTextField();
		JTextField bloqueos = new JTextField();
		JTextField porcentaje = new JTextField();
		
		JPanel aux2= new JPanel();
		aux2.setLayout(new GridLayout(9,2));
		
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
		
		JFrame frame = new JFrame("Add Player");
	    int respuesta=JOptionPane.showConfirmDialog(frame, aux2,JOptionPane.ICON_PROPERTY,JOptionPane.OK_CANCEL_OPTION);
	    
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	    if(respuesta==JOptionPane.CANCEL_OPTION){
	    	
	    }
	    else{
	    try{
	    	String name = nombre.getText();
	    	int years = Integer.parseInt(edad.getText());
	    	String team = equipo.getText();
	    	double points = Double.parseDouble(puntos.getText());
	    	int assistents = Integer.parseInt(asistencias.getText());
	    	int theft = Integer.parseInt(robos.getText());
	    	int block = Integer.parseInt(bloqueos.getText());
	    	int rebouns = Integer.parseInt(rebotes.getText());
	    	double percent = Double.parseDouble(porcentaje.getText());
	    	
	    	Player nuevo = new Player(name,years,team,points,rebouns,assistents,theft,block,percent);
	    	pro.insert(nuevo);
	    	
	    	l.updateList(pro.getParticipantes());
			JOptionPane.showMessageDialog(null, "El Jugador se agrego correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);	
	    }
	    catch( Exception e ){
	    JOptionPane.showMessageDialog(null, "El Jugador no se agrego correctamente, se debe verificar los datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);	
	    }
	    }
	}
	
	public void buscar(){
		 JPanel aux = new JPanel();
		 aux.setLayout(new BorderLayout());
		 
		 String[] options = new String[]{"Puntos","Asistencias","Rebotes","Porcentaje"};
		 JComboBox<String> combo = new JComboBox<String>(options);
		 
		 JTextField dato = new JTextField();
		 
		 aux.add(combo,BorderLayout.CENTER);
		 aux.add(dato,BorderLayout.SOUTH);
		 
		
		 JFrame frame = new JFrame("Search Players");
		 int respuesta=JOptionPane.showConfirmDialog(frame, aux,JOptionPane.ICON_PROPERTY,JOptionPane.OK_CANCEL_OPTION);
		 
		 frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		 if(respuesta==JOptionPane.CANCEL_OPTION){
		    	
		 }
		 else{
			try{
			pro.search(combo.getSelectedItem().toString(), Double.parseDouble(dato.getText()));
			l.updateList(pro.getParticipantes());
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Datos no encontrados", "Mensaje", JOptionPane.WARNING_MESSAGE);
			}
		 }
	}
	
	public void guardar(){
		Player p = l.getSelection();
		
		p.setMatchAssistances(d.getAsistencias());
		p.setTeam(d.getEquipo());
		p.setMatchBlocking(d.getBloqueos());
		p.setMatchPercent(d.getPorcentaje());
		p.setMatchPoints(d.getPuntos());
		p.setMatchRebounds(d.getRebotes());
		p.setName(d.getNombre());
		p.setMatchTheft(d.getRobos());
		p.setYears(d.getEdad());
	}
	
	public void editar(){
		d.habilitar();
	}
	
}
