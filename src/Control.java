/**
 * Gestion des d�placments � la souris
 * @author Maximilien
 */

import java.awt.event.MouseAdapter;

public class Control extends MouseAdapter {

	public Control() {
	} 
	
	//D�clenchement sur un click souris
	public void mousePressed(){
		JappyBird.bird.bump();
	}

}
