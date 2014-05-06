import java.awt.image.*;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window {
	protected static JappyBird jeu;
	protected static JFrame frame;
	private static DrawPanel screen;
	private static BufferedImage fond = null;
	private static BufferedImage bird = null;
	private static BufferedImage tubeDown = null;
	private static BufferedImage tubeUp = null;
	
	//Taille de la fenêtre + bordures
	private static final int height = 256;
	private static final int width = 144;
	
	public Window(JappyBird j) {
		jeu = j;
		frame = new JFrame(JappyBird.gameName);
		frame.setSize(width+15, height+38);
		//frame.setResizable(false); 
		
		//Chargement des sprites
		try{ load();
		} catch (IOException e) { System.out.println(e); }
		
		//Initialisatio de la fenêtre
		screen = new DrawPanel();
		frame.add(screen);
		frame.setVisible(true);
		
		//On passe la main au jeu !
	}
	
	//Charge les spites nécéssaires
	private void load() throws IOException{
		fond = ImageIO.read(new File("rsc/fond2.png"));
		bird = ImageIO.read(new File("rsc/bird.png"));
		tubeDown = ImageIO.read(new File("rsc/tubeDown.png"));
		tubeUp = ImageIO.read(new File("rsc/tubeUp.png"));
	}
	
	//Paneau de dessin pour la fenêtre
	public class DrawPanel extends JPanel {
		static final long serialVersionUID = 1L; //compatibilité
		public DrawPanel() {
			//Double buffering
			super(true);
		}
		
		/*****************************
		 * Moteur de rendu graphique *
		 *****************************/
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D g2d = (Graphics2D)g;
			//Création du composite pour l'overlay
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			//Wallpaper
			g2d.drawImage(Window.fond, 0, 0, this);
			//Draw tubes
			for(Tube t:JappyBird.tubes){
				g2d.drawImage(tubeUp, t.x, t.y, this);
				g2d.drawImage(tubeDown, t.x, t.getYBas(), this);
			}
			//Draw de l'oiseau en fonction de sa position
			g2d.drawImage(bird, jeu.getBird().getXgauche(), jeu.getBird().getYhaut(), this);
		}
		
		//Fork de la méthode ImageObserver pour les besoins de DrawImage
		public class ImageObs implements ImageObserver {
			public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
					int arg4, int arg5) {
				return false;
			}
		}


	}

	//Get&Set
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
}