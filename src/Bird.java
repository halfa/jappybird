/**
 * @author Maximilien
 * @author Julien
 */
public class Bird extends InGameObj{

	//private int y;
	public int sinceLastBump;

	public Bird() {
		super(12,17);
		x = 144/3-6; //bird position is fixed in the middle of the screen
		sinceLastBump = 0;
		y = 256/2; //altitude
	}

	//initialise the counter based on last mouse click
	public void bump() {
		y += 25;
	}

	//by default -> fall !
	public void fall(){
		sinceLastBump++;
		y += sinceLastBump; //linear fall
	}
}
