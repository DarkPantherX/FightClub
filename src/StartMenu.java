import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

public class StartMenu implements Menu {
	private String[] options = { "Singleplayer", "Multiplayer", "About" };
	private int select = 0;
	private FightClub fightclub;
	private boolean[] a;
	private Font registerFont;
	private ArrayList<IntroEnemy> introenemies = new ArrayList<IntroEnemy>(); // change
																				// please
	private ArrayList<IntroEnemy> introenemiess = new ArrayList<IntroEnemy>();
	private Image title;

	public StartMenu() {

		title = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("img/Title.png"));
		try {
			registerFont = Font
					.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader()
							.getResource("font/crac.ttf").openStream());
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics2D g2) {

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(title, 40, 20, 400 + (FightClub.WIDTH - 500),
				150 + (FightClub.HEIGHT - 500), null);

		for (int i = 0; i < options.length; i++) {
			String msg = options[i];

			if (i == select) {
				msg = "--> " + msg;

			}

			g2.setColor(Color.red);
			g2.setFont(registerFont.deriveFont(17f));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(127, 32, 32));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 2,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(64, 34, 35));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 4,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			int ou = (int) (Math.random() * 4); // change
			// System.out.println(ou);
			if (!introenemies.isEmpty()) {

				if (introenemies.size() * 30 + 25 < FightClub.WIDTH
						&& ((IntroEnemy) introenemies
								.get(introenemies.size() - 1)).getX_Point() > 50) {

					IntroEnemy enim = new IntroEnemy(-50,
							FightClub.HEIGHT - 120, 30, 30, ou, 0);
					introenemies.add(enim);
				}
			} else { // introenemies.isEmpty() == true

				IntroEnemy enim = new IntroEnemy(-50, FightClub.HEIGHT - 120,
						30, 30, ou, 0);
				introenemies.add(enim);
			}

			for (int g = 0; g < introenemies.size(); g++) {
				IntroEnemy en = (IntroEnemy) introenemies.get(g);

				en.render(g2);
				en.update();
				if (en.getDir() == 0) {
					en.setY_Point(FightClub.HEIGHT - 120);

					if (en.getX_Point() > FightClub.WIDTH) {
						introenemies.remove(en);
					}
				}
			}

			if (!introenemiess.isEmpty()) {
				if (introenemiess.size() * 30 + 25 < FightClub.WIDTH
						&& ((IntroEnemy) introenemiess
								.get(introenemiess.size() - 1)).getX_Point() < FightClub.WIDTH - 50) {

					IntroEnemy enim = new IntroEnemy(FightClub.WIDTH + 50,
							180 + (FightClub.HEIGHT - 500), 30, 30, ou, 1);
					introenemiess.add(enim);
				}
			} else {

				IntroEnemy enim = new IntroEnemy(FightClub.WIDTH + 50,
						180 + (FightClub.HEIGHT - 500), 30, 30, ou, 1);
				introenemiess.add(enim);
			}

			for (int g = 0; g < introenemiess.size(); g++) {
				IntroEnemy en = (IntroEnemy) introenemiess.get(g);

				en.render(g2);
				en.update();

				en.setY_Point(180 + (FightClub.HEIGHT - 500));

				if (en.getX_Point() < -20) {
					introenemiess.remove(en);

				}
			}

		}

		g2.setFont(registerFont.deriveFont(12f));
		g2.setColor(new Color(49, 83, 111));
		g2.drawString("Copyright (C) by DarKCoder", 0, FightClub.HEIGHT - 20);
	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub = fightclub;
		this.a = a;

		if (a[1]) {
			select++;
			aIsDone(); // ersetzen durch else if ??
		}
		if (a[0]) {
			select--;
			aIsDone();
		}
		if (select < 0) {
			select = options.length - 1;
		}
		if (select >= options.length) {
			select = 0;
		}
		if (a[5] && select == 0) { // a[5]=ENTER
			fightclub.setMenu(null);
		}
		// ...

	}

	public void aIsDone() {

		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}

		fightclub.setA(a);
	}
}
