import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.io.IOException;

public class PauseMenu implements Menu {

	private String[] options = { "Retry", "Resume [ESC]", "Main-Menu" };
	private int select = 0;
	private FightClub fightclub;
	private boolean[] a;

	private Font registerFont;

	private int pressing;

	public PauseMenu() {
		try {
			registerFont = Font.createFont(Font.TRUETYPE_FONT, getClass()
					.getClassLoader().getResource("font/bobcat.ttf")
					.openStream());
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		for (int i = 0; i < options.length; i++) {
			String msg = options[i];

			if (i == select) {
				msg = "--> " + msg;

			}

			g2.setColor(new Color(55, 255, 0));
			g2.setFont(registerFont.deriveFont(29f));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(15, 230, 138));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 2,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));
			g2.setColor(new Color(16, 216, 216));
			g2.drawString(msg, FightClub.WIDTH / 2 - 130 + 4,
					(50 * i + 250 + (FightClub.HEIGHT - 500)));

		}

	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub = fightclub;
		this.a = a;


		if (a[1]) { // S
			select++;
			aIsDone();
		}
		if (a[0]) { // W
			select--;
			aIsDone();
		}
		if (select < 0) {
			select = options.length - 1;
		}
		if (select >= options.length) {
			select = 0;
		}
		if (a[5] && select == 1) { // a[5]=ENTER
			fightclub.setMenu(null);
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

}
