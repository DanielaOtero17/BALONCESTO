package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Programm_NBA implements IFiba<Player>{
    
	private Player raiz;
	private ArrayList<Player> participantes;
	private int contador;
	
	public Programm_NBA() {
	raiz=null;
	participantes = new ArrayList<Player>();
	contador = 0;
	}
	
	public void cargar(File f)throws IOException{
		
		FileReader archivo = new FileReader(f);
		BufferedReader lector = new BufferedReader(archivo);
		
		String linea = lector.readLine();
		linea = lector.readLine();
		boolean termino = false;
		while (lector.ready() && !termino) {
			String[] datos = linea.split(",");
			
			String n = datos[0];
			int y = Integer.parseInt(datos[1]);
			String t = datos[2];
			double p = Double.parseDouble(datos[3]);
			int r = (int)Double.parseDouble(datos[4]);
			int a = (int)Double.parseDouble(datos[5]);
			int h = (int)Double.parseDouble(datos[6]);
			int b = (int)Double.parseDouble(datos[7]);
			double po = Double.parseDouble(datos[8]);
			
			Player nuevo = new Player(n, y, t, p, r, a, h, b, po); 
			insert(nuevo);
			
			linea = lector.readLine();
			if (linea == "") {
				termino = true;
			}
		}
		lector.close();
	}
	
	@Override
	public void insert(Player nuevo){
		Player j = nuevo;
		contador++;
		participantes.add(j);
		if(raiz==null){
			raiz=j;
		}
		else{
			raiz=insertAVL(j,raiz);
		}
	}
	
	public Player insertAVL(Player n, Player subAr){
		Player aux = subAr;
		if(n.getMatchPoints()<subAr.getMatchPoints()){
			if(subAr.getHijoIzq()==null){
				subAr.setIzq(n);
			}
			else{
				subAr.setIzq(insertAVL(n,subAr.getHijoIzq()));
				if(getBalance(subAr.getHijoIzq())-getBalance(subAr.getHijoDer())==2){
					if(n.getMatchPoints()<subAr.getHijoIzq().getMatchPoints()){
						aux=rotationIzq(subAr);
					}
					else{
						aux=rotationDobleIzq(subAr);
					}
				}
			}
		}
		else if(n.getMatchPoints()>subAr.getMatchPoints()){
			if(subAr.getHijoDer()==null){
				subAr.setDer(n);
			}
			else{
				subAr.setDer(insertAVL(n,subAr.getHijoDer()));
				if(getBalance(subAr.getHijoDer())-getBalance(subAr.getHijoIzq())==2){
					if(n.getMatchPoints()> subAr.getHijoDer().getMatchPoints()){
						aux=rotationDer(subAr);
					}
					else{
						aux=rotationDobleDer(subAr);
					}
				}
			}
		}
		else{
			System.out.println("Nodo Duplicado");
		}
		
		if(subAr.getHijoIzq()==null && subAr.getHijoDer()!=null){
			subAr.balance = subAr.getHijoDer().balance+1;
		}
		else if(subAr.getHijoDer()==null && subAr.getHijoIzq()!=null){
			subAr.balance = subAr.getHijoIzq().balance+1;
		}
		else{
			subAr.balance=Math.max(getBalance(subAr.getHijoIzq()), getBalance(subAr.getHijoDer())+1);
		}
		
		return aux;
	}
	
	public ArrayList<Player> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Player> participantes) {
		this.participantes = participantes;
	}

	@Override
	public Player getRaiz() {
		return raiz;
	}

	@Override
	public Player search(String criterio,Double dato) {
	
		if(criterio.equalsIgnoreCase("Puntos")){
			if (raiz == null) {
				return null;
			} else {
				return raiz.searchPoints(dato);
			}
		}
		else if(criterio.equalsIgnoreCase("Asistencias")){
			
			int a =(int) dato.doubleValue();
			
			if (raiz == null) {
				return null;
			} else {
				return raiz.searchAssistents(a);
			}
		}

		else if(criterio.equalsIgnoreCase("Rebotes")){
			int b =(int) dato.doubleValue();
			
			if (raiz == null) {
				return null;
			} else {
				return raiz.searchRebounds(b);
			}
		}

		else if(criterio.equalsIgnoreCase("Porcentaje")){
	
			if (raiz == null) {
				return null;
			} else {
				return raiz.searchPercent(dato);
			}
		}
		return null;
	}
	
	public Player buscar(double da ,Player r){
		if(raiz==null){
			return null;
		}
		else if(r.getMatchPoints()==da){
			return r;
		}
		else if(r.getMatchPoints()<da){
			return buscar(da,r.getHijoIzq());
		}
		else{
			return buscar(da,r.getHijoDer());
		}
	}
	
	@Override
	public int getBalance(Player x){
		if(x==null){
			return -1;
		}
		else{
		return x.balance;
		}
	}
	
	@Override
	public Player rotationIzq(Player c){
		
		Player aux =c.getHijoIzq();
		c.setIzq(aux.getHijoDer());
		aux.setDer(c);
		c.balance=Math.max(getBalance(c.getHijoIzq()), getBalance(c.getHijoDer()))+1;
		aux.balance=Math.max(getBalance(aux.getHijoIzq()), getBalance(aux.getHijoDer()))+1;
		return aux;
	}
	

	@Override
	public Player rotationDer(Player c){
		
		Player aux =c.getHijoDer();
		c.setDer(aux.getHijoIzq());
		aux.setIzq(c);
		c.balance=Math.max(getBalance(c.getHijoIzq()), getBalance(c.getHijoDer()))+1;
		aux.balance=Math.max(getBalance(aux.getHijoIzq()), getBalance(aux.getHijoDer()))+1;
		return aux;
	}
	
	@Override
	public Player rotationDobleIzq(Player c){
		
		Player aux ;
		c.setIzq(rotationDer(c.getHijoIzq()));
		aux = rotationIzq(c);
		return aux;
	}


	@Override
	public Player rotationDobleDer(Player c){
		
		Player aux = c.getHijoDer();
		c.setDer(rotationIzq(c.getHijoDer()));
		aux = rotationDer(c);
		return aux;
	}
	
	@Override
	public void delete (double v){
		raiz = deleteAux(v, raiz);
	}

	
	public Player deleteAux(double da,Player p) {
		if(p==null){
			return null;
		}
		else{
			if(p.getMatchPoints()<da){
				p.setDer(deleteAux(da,p.getHijoDer()));	
			}
			else if(p.getMatchPoints()>da){
				p.setIzq(deleteAux(da,p.getHijoIzq()));
			}
			else if(p.getHijoIzq()==null){
				p=p.getHijoDer();
			}
			else if(p.getHijoDer()==null){
				p  = p.getHijoIzq();
			}
			else if(getBalance(p.getHijoIzq())>getBalance(p.getHijoDer())){
				p = rotationDer(p);
				p.setIzq(deleteAux(da,p.getHijoIzq()));
			}
			else{
				p = rotationIzq(p);
				p.setDer(deleteAux(da,p.getHijoDer()));
			}
			
			if(p != null){
				p.balance=getBalance(p.getHijoIzq())+ getBalance(p.getHijoDer());
			}
		}
		return p;
	}
	
	public void inOrden(Player r){
		if(r!=null){
			inOrden(r.getHijoIzq());
			System.out.println(r.getName());
			inOrden(r.getHijoDer());
		}
	}
	
	public void posOrden(Player r){
		if(r!=null){
			posOrden(r.getHijoIzq());
			posOrden(r.getHijoDer());
			System.out.println(r.getName());
			
		}
	}
	
	public void preOrden(Player r){
		if(r!=null){
			System.out.println(r.getName());
			preOrden(r.getHijoIzq());
			preOrden(r.getHijoDer());
		}
	}
	
	public int getCantidad(){
		return contador;
	}
}
