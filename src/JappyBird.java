 import java.util.Vector;

/********************************
 * Gestion du jeu, scoring...
 * @author Maximilien Richer
 * @author Julien
 ********************************/
public class JappyBird {

	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	//ingame objects
	public static final Bird bird = new Bird();
	public static Vector<Tube> tubes = new Vector<Tube>();
	//numbers
	public static int score = 0;
	//distance entre le tube du haut et celui du bas
	public static int betweenTubes = 15; //pas dans <Tube> car paramètre du jeu ?
	public static int speed = 5;

	public JappyBird() {
		//initialisation des tuyaux
		for(int i=0; i<500; i++)
			tubes.add(new Tube());
		fenetre = new Window(this); //IHM
	}

	/***************************
	 * Boucle de jeu principale
	 ***************************/
	public int start(){
		//tant que l'oiseau n'est pas en collision
		while(!collision()){
			//on avance les tubes
			for(Tube t:tubes)
				t.avance();
			//l'écran est raffraichi lors de la prochaine itération de paint()
			fenetre.refresh();
			//temporisation
			try {Thread.sleep(50);}
			catch (InterruptedException e) {e.printStackTrace();}
		}

		return score;
	}

	/** l'état actuel de collision aux niveau des éléments du jeu
	 *  @return vrai si il y a collision
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
