/**
 * Un tube est constitu� d'une partie sup�rieur et inf�rieur
 * @param position est d�finie par le point en bas � gauche du tube sup�rieur
 * @param espacement entre les deux tubes
 * @author Maximilien
 */
public class Tube {
	public static int l_tube = 26;

	public int x;
	public int y;
	public int espacement;
	public int vitesse = 5;
	
	/**
	 * 
	 */
	public Tube(int posX, int posY, int e) {
		x = posX;
		y = posY;
		espacement = e;
	}
	
	//Analyse des collisions
	public boolean collision (Bird b){
		return false;
	}
	//D�cale le tube
	public void avance(){
		x -= vitesse;
	}
	//regarde si le tube est sorti de l'�cran
	public boolean offScreen(){
		return x+l_tube<0;
	}

}
