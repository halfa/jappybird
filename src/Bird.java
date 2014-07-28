/**
 * @author Maximilien
 * @author Julien
 */
public class Bird extends InGameObj{

	//private int y;
	public int sinceLastBump;
	
	public Bird() {
		super(12,17);
		//les coordonnées sont en haut à gauche
		x = 144/3-6;
		sinceLastBump = 0;
		y = 256/2; //altitude
	}
	
	//initialise le compteur de monté suite à un clic souris
	public void bump() {
		y += 25;
	}
	
	//Chute libre de l'oiseau -- action par défaut
	public void fall(){
		sinceLastBump++;
		y += sinceLastBump; //chute linéaire
	}
}