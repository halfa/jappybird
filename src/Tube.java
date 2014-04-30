/**
 * Un tube est constitué d'une partie supérieur et inférieur
 * @param position est définie par le point en bas à gauche du tube supérieur
 * @param espacement entre les deux tubes
 * @author Maximilien
 */
public class Tube extends InGameObj{
	
	public static int l_tube = 26;
	public int espacement;
	public int vitesse = 5;
	

	public Tube() {
		//TODO: déplacer les initialisations et gérer le rand
	}
	
	/**
	 * 
	 */
	public Tube(int posX, int posY, int e) {
		x = posX;
		y = posY;
		espacement = e;
	}
	
	//Décale le tube
	public void avance(){
		x -= vitesse;
	}
	//regarde si le tube est sorti de l'écran
	public boolean offScreen(){
		return x+l_tube<0;
	}

}
