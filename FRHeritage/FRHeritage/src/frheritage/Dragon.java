/**
 * Published under the "i'm not fucking done with this, don't fuck with it" license
 * Terms: I'm not fucking done working on this, so don't fuck around with it.
 */
package frheritage;

/**
 * @author Sigoshi
 *
 */
public class Dragon
	implements java.io.Serializable{
	private static final long serialVersionUID = 2000;
	/*
	 * serialVersionUID is the version number of the program backwards (just to make sure
	 * that the 0's don't get screwed up, ya know?). Keeping the serialVersionUID updated
	 * will make it so that no errors happen when I add variables in future versions.
	 */
	int id;
	String name;
	String breed; //i'm considering implementing breed (with flight) as a gene in the 0th slot for calculation purposes
	boolean gender; 
	/* 
	 * Yeah yeah, I know, gender isn't a binary, but FR uses binary gendering
	 * for mating purposes, so its easier to just use a boolean here
	 * When will my Social Justice Dragons return from the war.
	 * So yeah, for the sake of gender identification, True indicates male, False indcates female.
	*/
	// TODO Implement other characteristics (Flight, LVL, Stats, Hatch Date, etc.)
	Gene primary=new Gene(1);
	Gene secondary=new Gene(2);
	Gene tertiary=new Gene(3);
	// TODO Quantify Genetics (see Gene.java)
	boolean firstGen;
	Dragon mom;
	Dragon dad;
	Dragon[] children;
	
	public Dragon(int i, String n, String b, boolean g) {
		super();
	 	this.id = i;
		this.name = n;
		this.breed = b;
		this.gender = g;
	}

	public Dragon(int i) {
		super();
		this.id = i;
		this.name="Unnamed";
		this.breed="Guardian"; //i just randomly picked guardian to be the "basic" breed.
		this.gender=true;
	}
	
	public Dragon(Dragon temp){
		super();
		this.breed= temp.breed;
		this.gender= temp.gender;
		this.id= temp.id;
		this.name= temp.name;
		this.primary= temp.primary;
		this.secondary= temp.secondary;
		this.tertiary= temp.tertiary;
		temp.Destroy();
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String b) {
		this.breed = b;
	}

	public boolean isMale() {
		return gender;
	}

	public void setGender(boolean g) {
		this.gender = g;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String n){
		this.name=n;
	}

	public String IDasString() {
		return ("" + id);
	}
	
	public String DescSimple() {
		return ("Dragon has ID " + 
				this.IDasString() + 
				" and is named " + 
				this.name);
	}
	public String DescComplex() {
		return ("[ID: " +
				this.IDasString() +
				"]\n[name: " +
				this.name +
				"]\n[breed: " +
				this.breed +
				"]\n[gender:" +
				this.gender +
				"]");
	}
	public void Destroy() {
		this.breed= null;
		this.gender=false;
		this.id=0;
		this.name=null;
		this.primary=null;
		this.secondary=null;
		this.tertiary=null;
		
	}



}
