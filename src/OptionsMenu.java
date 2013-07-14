import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.ArrayList;

import ch.ilikechickenwings.GraphicsObject.*;

public class OptionsMenu extends Menu implements GListener{

	private int select = 0;
	private int pressing=0;
	private FightClub fightclub;
	private boolean[] a;
	private Font registerFont;
	


	private GCheckbox gCheck;
	private GSlider gSlide;
	public static ArrayList<GObject> gObjects = new ArrayList<GObject>();

	public OptionsMenu() {

		try {
			registerFont = Font.createFont(Font.TRUETYPE_FONT, getClass()
					.getClassLoader().getResource("font/bobcat.ttf")
					.openStream());
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addGListener(this);
		
		gCheck=new GCheckbox((FightClub.WIDTH / 2) - 60,
				(FightClub.HEIGHT / 2) - 60, 120, 30, "Mute Game");
		add(gCheck);

	}

	


	@Override
	public void render(Graphics2D g2) {

		g2.setColor(new Color(117, 171, 193, 120));
		g2.fillRect(0, 0, FightClub.WIDTH, FightClub.HEIGHT);

		// copied:
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setFont(registerFont.deriveFont(80f));
		g2.setColor(new Color(55, 255, 0));
		g2.drawString("Pause!", FightClub.WIDTH / 2 - 176, 75);
		g2.setColor(new Color(15, 230, 138));
		g2.drawString("Pause!", FightClub.WIDTH / 2 - 173, 75);
		g2.setColor(new Color(16, 216, 216));
		g2.drawString("Pause!", FightClub.WIDTH / 2 - 170, 75);

		for (int i = 0; i < gObjects.size(); i++) {
			
			GObject obs = (GObject) gObjects.get(i);
			
			String msg =obs.getStr();

			if (i == select) {
				obs.setSelected(true);
				obs.switched();
			}else{
				obs.setSelected(false);
				obs.switched();
			}
			g2.drawImage(obs.getImg(),obs.getxCor(),obs.getyCor(),null);
			g2.setColor(new Color(55, 255, 0));
			g2.setFont(registerFont.deriveFont(29f));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130,
					(obs.getxCor()+30 + obs.getyCor()));

		}

	}
	
	
	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub = fightclub;
		this.a = a;


		if (a[1] || a[9]) { // a[1]=S,a[9]=DOWN
			select++;
			aIsDone();
		}
		if (a[0] || a[8]) { // a[0]=W,a[8]=UP
			select--;
			aIsDone();
		}
		if (select < 0) {
			select = gObjects.size() - 1;
		}
		if (select >= gObjects.size()) {
			select = 0;
		}
		if (a[5] && select == 1) { // a[5]=ENTER
			gCheck.clicked(this);
		}
		if(a[5] && select == 2){
			fightclub.setMenu(new StartMenu());
		}
		
		
		if (!a[6] && pressing == 0 || a[6] && pressing == 1) { // a[6] = Esc
			pressing++;
		} else if (!a[6] && pressing == 2) {// a[6] = Esc
			fightclub.setMenu(null);
		}
		aIsDone();
	}

	public void aIsDone() {

		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}

		fightclub.setA(a);
	}
	
	
	private void add(GObject ob) {
		gObjects.add(ob);
	}


	@Override
	public void actionPerformed(GEvent ge) {
		// TODO Auto-generated method stub
		
	}

}
