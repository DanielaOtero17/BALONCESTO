package model;

public class Player implements Comparable<Player> {
	
	public static final int BIZQ =1;
	public static final int BAL =0;
	public static final int BDER =-1;

	public int balance;
	
	private String name;

	private int years;
	private String team;
	
	private double matchPoints;
	private int matchRebounds;
	private int matchAssistances;
	private int matchTheft;
	private int matchBlocking;
	private double matchPercent;
		
	private Player izq;
	private Player der;
	
	public Player(String n, int y, String t, double p, int r, int a, int h, int b,double po){
		name=n;
		years=y;
		team=t;
		matchPoints=p;
		matchRebounds=r;
		matchAssistances=a;
		matchTheft=h;
		matchBlocking=b;
		matchPercent=po;
		
		der=null;
		izq=null;
		
		balance =0;
	}

	public Player raiz(){
		return this;
	}
	
	public Player getHijoIzq() {
		return izq;
	}

	public void setIzq(Player izq) {
		this.izq = izq;
	}

	public Player getHijoDer() {
		return der;
	}

	public void setDer(Player der) {
		this.der = der;
	}

	public boolean isHoja(){
		return izq==null && der==null;
	}
	
	
	public Player getMenor(){	
		if(izq==null){
			return izq;
		}else{
			return izq.getMenor();
		}
	}
	
	public Player getMayor(){	
		if(der==null){
			return der;
		}else{
			return der.getMayor();
		}
	}
	
	public double getMatchPercent() {
		return matchPercent;
	}

	public void setMatchPercent(double matchPercent) {
		this.matchPercent = matchPercent;
	}
	

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getMatchPoints() {
		return matchPoints;
	}

	public void setMatchPoints(double matchPoints) {
		this.matchPoints = matchPoints;
	}

	public int getMatchRebounds() {
		return matchRebounds;
	}

	public void setMatchRebounds(int matchRebounds) {
		this.matchRebounds = matchRebounds;
	}

	public int getMatchAssistances() {
		return matchAssistances;
	}

	public void setMatchAssistances(int matchAssistances) {
		this.matchAssistances = matchAssistances;
	}

	public int getMatchTheft() {
		return matchTheft;
	}

	public void setMatchTheft(int matchTheft) {
		this.matchTheft = matchTheft;
	}

	public int getMatchBlocking() {
		return matchBlocking;
	}

	public void setMatchBlocking(int matchBlocking) {
		this.matchBlocking = matchBlocking;
	}

	public String getName() {
		return name;
	}

	public int getYears() {
		return years;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int getAltura(){
		int a1 =(izq==null)? 0 :izq.getAltura();
		int a2 =(der==null)? 0 :der.getAltura();
		
		return (a1>=a2) ? a1+1 : a2+1;
	}

	@Override
	public int compareTo(Player o) {
		if(o.getName().compareTo(o.getName())==0){
			return 0;
		}
		else if(o.getName().compareTo(o.getName())>0){
			return 1;
		}
		else{
			return -1;
		}
	}
}
