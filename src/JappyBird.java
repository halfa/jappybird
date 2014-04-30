import java.util.Vector;

/**
 * Classe de gestion du jeu
 * 
 * @author Maximilien
 * @author Julien
 */
public class JappyBird {
	
	public static final String gameName = "Jappy Bird";
	public static Window fenetre;
	
	static Bird bird;
	public static Vector<Tube> tubes;
	public static int score = 0;
	
	public JappyBird() {
		//Initialisation de l'IHM
		fenetre = new Window(this);
		bird = new Bird();
		//initialisation des tuyaux
		for(int i=0; i<500; i++)
			tubes.add(new Tube());
	}
	
	/**
	 * Boucle de jeu principale
	 */
	public int start(){
		//tant que l'oiseau n'est pas en collision
		while(!collision()){
			//on avance les tubes
			for(Tube t:tubes)
				t.avance();
			//waiting
			try {Thread.sleep(50);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
		
		return score;
	}
	
	//retourne l'état actuel de collision
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
