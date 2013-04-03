import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class ShooterEnemy extends Enemy {

	private long oldTime = 0;

	public ShooterEnemy(int x_Point, int y_Point, int width, int height,
			Image img, int life, boolean visible) {
		super(x_Point, y_Point, width, height, img, life, visible);

	}

	@Override
	public void update() {
		Player player = FightClub.getNearestPlayer();
		double vel = 1;

		if (!player.isVisible()) {

			// setX_Point(getX_Point() + 1);

		} else {

			double dx = player.getX_Point() + player.getWidth()
					- (this.getX_Point() + this.getWidth() / 2);
			double dy = player.getY_Point() + player.getHeight()
					- (this.getY_Point() + this.getHeight() / 2);

			// Movement
			double dist = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)); // distance
			double rad1 = (FightClub.HEIGHT + FightClub.WIDTH) / 4; // Radius

			// Enemy moves if it is outside the viewable field or if it is
			// farther away than rad1 from the nearest player
			if (dist > rad1 || getX_Point() < 0
					|| getX_Point() > FightClub.WIDTH - this.getWidth()
					|| getY_Point() < 0
					|| getY_Point() > FightClub.HEIGHT - this.getHeight()) {
				setX_Point(getX_Point() + dx / dist * vel * FightClub.WIDTH
						/ (double) 500);
				setY_Point(getY_Point() + dy / dist * vel * FightClub.HEIGHT
						/ (double) 500);
			}
			
			// Shoot
			long currentTime = System.currentTimeMillis();
			if (currentTime > oldTime + 5000) {

				
				Bullet bul = new Bullet(
						10,
						10,
						dx,
						dy,
						(int) (getX_Point() + getWidth()/2+dx/dist*2*getWidth()),
						(int) (getY_Point() + getHeight()/2+dy/dist*2*getHeight()),
						Math.atan(dy / dx), 1, 2);
				FightClub.bullets.add(bul);
				oldTime = currentTime;

			}

			rect = new Rectangle((int) getX_Point(), (int) getY_Point(),
					this.getWidth(), this.getHeight());
			point = new Point((int) (getX_Point() + (getWidth() / 2)),
					(int) (getY_Point() + (getHeight() / 2)));
		}
	}

}
