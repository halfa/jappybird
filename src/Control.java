/**
 * Gestion des déplacments à la souris
 * @author Maximilien
 */

import java.awt.event.MouseAdapter;

public class Control extends MouseAdapter {

	public Control() {
	} 
	
	//Déclenchement sur un click souris
	public void mousePressed(){
		JappyBird.bird.bump();
	}

}
