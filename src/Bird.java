/**
 * @author Maximilien
 * @author Julien
 */
public class Bird extends InGameObj{

	public int sinceLastBump;

	public Bird() {
		super(12,17);
		x = 144/3-6; //bird position is fixed in the middle of the screen
		sinceLastBump = 0;
		y = 256/2; //altitude
	}

	//initialise the counter based on last mouse click
	public void bump() {
		for(int i=5; i>0; i--){
			this.y-=Math.pow(i,2);
			if(y<0)
				y=0;
			//tubes are going foward
			for(Tube t:JappyBird.tubes) //TODO need more cleaning
				t.foward();
			JappyBird.fenetre.refresh();
			//not so fast !
			try {Thread.sleep(40);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
		sinceLastBump = 0;
	}

	//by default -> fall !
	public void fall(){
		sinceLastBump++;
		y += sinceLastBump/3; //linear fall
	}
}
