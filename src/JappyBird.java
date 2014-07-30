 import java.util.Vector;

/********************************
 * Game management, scoring...
 * @author Maximilien Richer
 * @author Julien Vifflanzef
 * @author Axel Caro
 ********************************/
public class JappyBird {

	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	//ingame objects
	public static final Bird bird = new Bird();
	public static Vector<Tube> tubes = new Vector<Tube>();
	//numbers
	public static int score = 0;
	//distance between top and bot tube
	public static int betweenTubes = 30; //here because it is a game parameter
	public static int speed = 5;

	public JappyBird() {
		// tubes init.
		for(int i=0; i<500; i++)
			tubes.add(new Tube());
		fenetre = new Window(this); //IHM
	}

	/***************************
	 * Main loop
	 ***************************/
	public int start(){
		while(!collision()){
			//tubes are going foward
			for(Tube t:tubes)
				t.foward();
			fenetre.refresh();
			//not so fast !
			try {Thread.sleep(50);}
			catch (InterruptedException e) {e.printStackTrace();}
		}

		return score;
	}

	/** collisions between game elements
	 *  @return true if a collision occur
	 */
	public boolean collision(){
		for(Tube t:tubes)
			if(t.collisionAvec(getBird()))
				return true;
		return false;
	}


	public static void main(String[] args) {
		JappyBird J = new JappyBird();
		J.start();
	}

	//getSet
	public Bird getBird() {  return bird; }

}
