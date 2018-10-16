package Model;

public class Player {
	
	private String name;
	private int years;
	private String team;
	private double matchPoints;
	private int matchRebounds;
	private int matchAssistances;
	private int matchTheft;
	private int matchBlocking;
	
	public Player(String n, int y, String t, double p, int r, int a, int h, int b){
		name=n;
		years=y;
		team=t;
		matchPoints=p;
		matchRebounds=r;
		matchAssistances=a;
		matchTheft=h;
		matchBlocking=b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
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
	
	
	
	

}
