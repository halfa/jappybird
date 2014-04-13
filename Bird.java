/**
 * @author Maximilien
 * @author Julien
 */
public class Bird {

	public static final int h_bird = 12;
	public static final int l_bird = 17;
	private final int x = 144/2; //l'oiseau reste au milieu de l'�cran
	private int y;
	public int sinceLastBump;
	
	public Bird() { 
		sinceLastBump = 0;
		y = 256/2;
	}
	
	public int getXgauche(){ return x; }
	public int getYhaut(){ return y; }
	public int getXdroit(){ return x+l_bird; }
	public int getYbas(){ return y+h_bird; }

	//initialise le compteur de mont� suite � un clic souris
	public void bump() {
		
	}
	
	//Chute libre de l'oiseau -- action par d�faut
	public void fall(){
		sinceLastBump++;
		y += sinceLastBump;
	}
}
