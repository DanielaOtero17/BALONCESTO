package Model;

public class Player {
	
	private String name;
	private int years;
	private String team;
	private int matchs;
	private double matchPoints;
	private int matchRebounds;
	private int matchAssistances;
	private int matchTheft;
	private int matchBlocking;
	
	public Player(String n, int y, String t, int m, double p, int r, int a, int h, int b){
		name=n;
		years=y;
		team=t;
		matchs=m;
		matchPoints=p;
		matchRebounds=r;
		matchAssistances=a;
		matchTheft=h;
		matchBlocking=b;
	}
	
	
	

}
