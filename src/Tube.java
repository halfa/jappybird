/**
 * Un tube est constitu� d'une partie sup�rieur et inf�rieur
 * @param position est d�finie par le point en bas � gauche du tube sup�rieur
 * @param espacement entre les deux tubes
 * @author Maximilien
 */
public class Tube extends InGameObj{
	
	public static int l_tube = 26;
	public int espacement;
	public int vitesse = 5;
	

	public Tube() {
		//TODO: d�placer les initialisations et g�rer le rand
	}
	
	/**
	 * 
	 */
	public Tube(int posX, int posY, int e) {
		x = posX;
		y = posY;
		espacement = e;
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
