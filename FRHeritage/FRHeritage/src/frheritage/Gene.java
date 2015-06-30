/**
 * Published under the "i'm not fucking done with this, don't fuck with it" license
 * Terms: I'm not fucking done working on this, so don't fuck around with it.
 */
package frheritage;

/**
 * @author Sigoshi
 *
 */
public class Gene 
	implements java.io.Serializable{
	private static final long serialVersionUID = 2000;

	int slot; //1= primary, 2=secondary, 3=tertiary
	String col;
	String type;
	
	/**
	 * TODO somehow turn the colors and types of genes into quantified variables,
	 * so that breeding calculations can be made. This likely means assigning each
	 * color and each gene type an ID. Each Gene's ID would then have it's rarity
	 * factor and calculations associated with it so that breeding possibilities
	 * can be calculated.
	 */
	public Gene(int slot, String col, String type) {
		super();
		this.slot=slot;
		this.col=col;
		this.type=type;
	}
	public Gene(int slot){
		super();
		this.slot=slot;
		this.col="Black";
		this.type="Basic";
	}

}
