 import java.util.Vector;

/********************************
 * Game management, scoring...
 * @author Maximilien Richer
 * @author Julien Vifflanzef
 * @author Axel Caro
 * @version 0.0.1
 ********************************/
public class JappyBird {

	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	//ingame objects
	public static final Bird bird = new Bird();
	public static Vector<Tube> tubes = new Vector<Tube>();
	//numbers
	public static int score = 0;
	public static int betweenTubes = 30; //distance between top and bot tube here because it is a game parameter
	public static int speed = 5;

	public JappyBird() {
		// tubes init.
		for(int i=0; i<500; i++)
			tubes.add(new Tube());
		fenetre = new Window(this); //IHM
	}

	/*************
	 * Main loop *
	 *************/
	public void start(){
		while(this.isItTheEnd()){
			//tubes are going foward
			for(Tube t:tubes)
				t.foward();
			fenetre.refresh();
			bird.fall();
			//not so fast !
			try {Thread.sleep(40);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	/**
	 *
	 */
	public boolean isItTheEnd(){
		//Out screen
		if(bird.getYhaut()<Window.getHeight())
			return true;
		else return false;
	}

	/** Collisions between game elements
	 *  @return true if a collision occur
	 */
	public boolean collision(){
		for(Tube t:tubes)
			if(t.collideWith(getBird()))
				return true;
		return false;
	}

	//getSet
	public Bird getBird() {  return bird; }

	public static void main(String[] args) {
		JappyBird J = new JappyBird();
		J.start();
		System.exit(0);
	}

}
