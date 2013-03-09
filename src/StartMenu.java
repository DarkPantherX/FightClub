import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class StartMenu implements Menu{
	private String[] options = { "Singleplayer", "Multiplayer", "About" };
	private int select=0;
	private FightClub fightclub;
	private boolean[] a;
	
	@Override
	public void render(Graphics2D g2) {
		Image title = new ImageIcon(getClass().getResource("img/title.png")).getImage();
		g2.setColor(Color.red);
		g2.drawImage(title, 40,20,400+(FightClub.WIDTH-500),150+(FightClub.HEIGHT-500),null);
		
		for(int i=0;i<options.length;i++){
			String msg=options[i];
			
			if(i==select){
				msg="-->"+options[i];
				
			}
		g2.drawString(msg,FightClub.WIDTH/2-130,(50*i+200+(FightClub.HEIGHT-500)));
		}
		
		
		
		g2.drawString("Copyright (C) by TeamMongoAffenClan", FightClub.WIDTH/2-130,FightClub.HEIGHT-30);
	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub=fightclub;
		this.a=a;

		
		if(a[1]){
			select++;
			aIsDone();
		}
		if(a[0]){
			select--;
			aIsDone();
		}
		if(select<0){
			select=options.length-1;
		}
		if(select>=options.length){
			select=0;
		}
		if(a[5]&&select==0){
			fightclub.setMenu(null);
		}
		
		
	}

	public void aIsDone(){
				
		for(int i=0;i<a.length;i++){
			a[i]=false;
		}
		
		
			fightclub.setA(a);
	}
}
