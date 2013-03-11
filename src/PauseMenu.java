import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class PauseMenu implements Menu {

	
	private String[] options = { "Singleplayer", "Multiplayer", "About" };
	private int select=0;
	private FightClub fightclub;
	private boolean[] a;
	
	
	
	@Override
	public void render(Graphics2D g2) {
		Image bg = new ImageIcon(getClass().getResource("img/pausbg.png"))
	.getImage();
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f);
		g2.setComposite(composite); // Set current alpha
		g2.drawImage(bg, 0, 0, FightClub.WIDTH,FightClub.HEIGHT,null);

		
	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub=fightclub;
		this.a=a;
		
		if(a[6]){
			fightclub.setMenu(null);
			aIsDone();
		}
		
	}

	public void aIsDone(){
		
		for(int i=0;i<a.length;i++){
			a[i]=false;
		}
		
		
			fightclub.setA(a);
	}

}
