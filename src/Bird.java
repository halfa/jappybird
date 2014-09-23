/**
 * @author Maximilien
 * @author Julien
 */
public class Bird extends InGameObj{

	public int sinceLastBump; //downward acceleration
	public int bump; //jump linear counter

	public Bird() {
		super(12,17);
		x = 144/3-6; //bird lateral position is fixed in the middle of the screen
		sinceLastBump = 0;
		bump=0;
		y = 256/2; //altitude
	}

	//
	public void act(){
		if (bump>0)
			this.actJump();
		else
			this.actFall();
	}
	

	//initialise the counter based on last mouse click
	public void triggerJump(){ bump = 5; }
	
	private void actJump() {
		this.y-=Math.pow(this.bump,2);
		if(y<0)
			y=0;
		sinceLastBump = 0;
		bump--;
	}
	private void actFall(){
		sinceLastBump++;
		y += sinceLastBump/3; //linear fall
	}
}
