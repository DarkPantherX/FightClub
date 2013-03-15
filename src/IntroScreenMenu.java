import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.IOException;


public class IntroScreenMenu implements Menu {

	private long timeOld;
	private int i=0;
	private Font registerFont;
	private Image intro;
	private Image intro2;
	private int count=0;
	
	
	public IntroScreenMenu(){
		
		try {
			registerFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource("font/narrow.ttf").openStream());
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		intro = Toolkit.getDefaultToolkit().getImage((getClass().getResource("img/intro.png")));
		intro2 = Toolkit.getDefaultToolkit().getImage((getClass().getResource("img/intro2.png")));
	}
	
	
	
	@Override
	public void render(Graphics2D g2) {
		
		
		
		g2.setRenderingHint( // smooth
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		if(count<=0){ // count == 0
		g2.setColor(Color.white);
		g2.fillRect(0, 0, FightClub.WIDTH, FightClub.HEIGHT);
		g2.drawImage(intro, FightClub.WIDTH/2-170,FightClub.HEIGHT/2-100,null);
		
		g2.setFont(registerFont.deriveFont(53f));
		g2.setColor(new Color(65,150,228));
		g2.drawString("DarkCoder Production", FightClub.WIDTH/2-216, 50);
		g2.setColor(new Color(31,52,102));
		g2.drawString("DarkCoder Production", FightClub.WIDTH/2-213, 50);
		g2.setColor(Color.black);
		g2.drawString("DarkCoder Production", FightClub.WIDTH/2-210, 50);
		}else{
			
			g2.setColor(Color.black);
			g2.fillRect(0, 0, FightClub.WIDTH, FightClub.HEIGHT);
			g2.drawImage(intro2, FightClub.WIDTH/2-170,FightClub.HEIGHT/2-100,null);

			g2.setFont(registerFont.deriveFont(53f));
			g2.setColor(new Color(190,105,27));
			g2.drawString("DarkCoder Production", FightClub.WIDTH/2-216, 50);
			g2.setColor(new Color(224,203,153));
			g2.drawString("DarkCoder Production", FightClub.WIDTH/2-213, 50);
			g2.setColor(Color.white);
			g2.drawString("DarkCoder Production", FightClub.WIDTH/2-210, 50);
			
		}
		
		
	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		long currentTime=System.currentTimeMillis();
		
		if(i==0){  
			timeOld=currentTime;
			i++;
		}
		
		if(currentTime>timeOld+5000){
			fightclub.setMenu(new StartMenu());			
		}
		
		if(currentTime>timeOld+2750&&currentTime<timeOld+3000){
			count=1; // change
		}
		
		if(currentTime>timeOld+3000&&currentTime<timeOld+3100){
			
			count=0;
		}
		
		if(currentTime>timeOld+3250&&currentTime<timeOld+3500){
			count=1;
		}
		
		if(currentTime>timeOld+3600){
			
			count=0;
		}

	}

}
