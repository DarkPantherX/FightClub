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
		Image backg = new ImageIcon(getClass().getResource("img/pausbg.png")).getImage();
		g2.drawImage(backg,0,0,FightClub.WIDTH,FightClub.HEIGHT,null);
		g2.setColor(Color.blue);
		
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
