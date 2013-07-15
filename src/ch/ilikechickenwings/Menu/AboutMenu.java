package ch.ilikechickenwings.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.ArrayList;

import ch.ilikechickenwings.FightClub;

public class AboutMenu extends Menu{

	private String[] options = { "Return to Main Menu", "Exit"};
	private int select = 0;
	private FightClub fightclub;
	private boolean[] a;
	private Font registerFont;

	public AboutMenu() {

		try {
			registerFont = Font
					.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader()
							.getResource("font/bobcat.ttf").openStream());
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics2D g2) {

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setFont(registerFont.deriveFont(80f));
		g2.setColor(new Color(255, 255, 0));
		g2.drawString("About!", FightClub.WIDTH / 2 - 176, 75);
		g2.setColor(new Color(215, 230, 138));
		g2.drawString("About!", FightClub.WIDTH / 2 - 173, 75);
		g2.setColor(new Color(216,216,216));
		g2.drawString("About!", FightClub.WIDTH / 2 - 170, 75);

		for (int i = 0; i < options.length; i++) {
			String msg = options[i];

			if (i == select) {
				msg = "--> " + msg;

			}

			g2.setColor(new Color(255,255,0));
			g2.setFont(registerFont.deriveFont(29f));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(215, 230, 138));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 2,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(216, 216, 216));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 4,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));

			

		}

		g2.setFont(registerFont.deriveFont(12f));
		g2.setColor(new Color(49, 83, 111));
		g2.drawString("Copyright © by DarKCoder", 0, FightClub.HEIGHT - 20);
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
			select = options.length - 1;
		}
		if (select >= options.length) {
			select = 0;
		}
		if (a[5] && select == 0) {
			fightclub.setMenu(new StartMenu());
		}
		if (a[5] && select == 1) {
			System.exit(0);
		}


		

	}

	public void aIsDone() {

		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}

		fightclub.setA(a);
	}
	
}
