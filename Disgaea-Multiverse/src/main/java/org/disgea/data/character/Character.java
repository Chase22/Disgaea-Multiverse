package org.disgea.data.character;

public class Character {
	private int id;
	private String charname;
	private String playername;
	private String race;
	private String gender;
	private String mainclass;
	private String mainclassrank;
	private String subclass;
	private String subclassrank;
	
	private int level;
	private int ext;
	private int nextexp;
	
	private int hitpoints;
	private int maxhitpoints;
	private int specialpoints;
	private int maxspecialpoints;
	
	private double rage;
	private int counter;
	private int counterchance;
	private int crit;
	
	private Attributes attributes;
	private Weaponskills weaponskills;
	private Resistances resistances;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharname() {
		return charname;
	}

	public void setCharname(String charname) {
		this.charname = charname;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMainclass() {
		return mainclass;
	}

	public void setMainclass(String mainclass) {
		this.mainclass = mainclass;
	}

	public String getMainclassrank() {
		return mainclassrank;
	}

	public void setMainclassrank(String mainclassrank) {
		this.mainclassrank = mainclassrank;
	}

	public String getSubclass() {
		return subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	public String getSubclassrank() {
		return subclassrank;
	}

	public void setSubclassrank(String subclassrank) {
		this.subclassrank = subclassrank;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExt() {
		return ext;
	}

	public void setExt(int ext) {
		this.ext = ext;
	}

	public int getNextexp() {
		return nextexp;
	}

	public void setNextexp(int nextexp) {
		this.nextexp = nextexp;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public int getMaxhitpoints() {
		return maxhitpoints;
	}

	public void setMaxhitpoints(int maxhitpoints) {
		this.maxhitpoints = maxhitpoints;
	}

	public int getSpecialpoints() {
		return specialpoints;
	}

	public void setSpecialpoints(int specialpoints) {
		this.specialpoints = specialpoints;
	}

	public int getMaxspecialpoints() {
		return maxspecialpoints;
	}

	public void setMaxspecialpoints(int maxspecialpoints) {
		this.maxspecialpoints = maxspecialpoints;
	}

	public double getRage() {
		return rage;
	}

	public void setRage(double rage) {
		this.rage = rage;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCounterchance() {
		return counterchance;
	}

	public void setCounterchance(int counterchance) {
		this.counterchance = counterchance;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getVitality() {
		//TODO insert formulas
		return 0;
	}
	public int getBodystrength() {
		//TODO insert formulas
		return 0;
	}

	public int getWisdom() {
		//TODO insert formulas
		return 0;
	}

	public int getSkill() {
		//TODO insert formulas
		return 0;
	}

	public int getUrge() {
		//TODO insert formulas
		return 0;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Weaponskills getWeaponskills() {
		return weaponskills;
	}

	public void setWeaponskills(Weaponskills weaponskills) {
		this.weaponskills = weaponskills;
	}

	public Resistances getResistances() {
		return resistances;
	}

	public void setResistances(Resistances resistances) {
		this.resistances = resistances;
	}

}
