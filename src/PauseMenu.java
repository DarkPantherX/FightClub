import java.awt.Graphics2D;
import java.awt.Color;

public class PauseMenu implements Menu {

	// private String[] options = { "Singleplayer", "Multiplayer", "About" };
	// private int select=0;
	private FightClub fightclub;
	private boolean[] a;

	private int pressing;

	@Override
	public void render(Graphics2D g2) {
		// removed unused picture
		g2.setColor(new Color(117, 171, 193, 120));
		g2.fillRect(0, 0, FightClub.WIDTH, FightClub.HEIGHT);

	}

	@Override
	public void update(FightClub fightclub, boolean[] a) {
		this.fightclub = fightclub;
		this.a = a;
		
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
