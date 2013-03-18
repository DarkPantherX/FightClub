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

			double dx = player.getX_Point() + 25 - (this.getX_Point() + 15);
			double dy = player.getY_Point() + 25 - (this.getY_Point() + 15);
			
			// Movement
			double dist = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)); // distance
			double rad1 = (FightClub.HEIGHT + FightClub.WIDTH)/4; // Radius
			
			
		    // Enemy moves if it is outside the viewable field or if it is farther away than rad1 from the nearest player	
			if (dist > rad1 || getX_Point()<0 || getX_Point()>FightClub.WIDTH-this.WIDTH || getY_Point()<0 || getY_Point()>FightClub.HEIGHT-30) { 
				setX_Point(getX_Point() + dx / dist * vel * FightClub.WIDTH
						/ (double) 500);
				setY_Point(getY_Point() + dy / dist * vel * FightClub.HEIGHT
						/ (double) 500);
			}
			// Shoot
			long currentTime = System.currentTimeMillis();
			if (currentTime > oldTime + 5000) {
				/* 
				 * Good, your method is good, nearly to good, the player has almost no chance...
				 * You can delete my method, it isn't usable anymore...
				 * 
				double d[] = new double[2];
				d[0] = player.getX_Point() + 25 - (getX_Point() + 15);
				d[1] = player.getY_Point() + 25 - (getY_Point() + 15);
				double c[] = getDig(d); // dear DP, i do not understand this

				// sorry sc, had to add a number to your enemy, because of
				// changed
				// bullet strength (look under Bullet ->power)
				Bullet bul = new Bullet(10, 10, c[0], c[1],
						(int) (getX_Point() - c[0]),
						(int) (getY_Point() + c[1]), 0, 1);
				FightClub.bullets.add(bul);
				*/
				
				// TODO the X-Point and Y-Point of Bullet has to be changed
				Bullet bul = new Bullet(10,10,dx,dy,(int)getX_Point(),(int)getY_Point(),Math.tan(dy/dx),1,2);
				FightClub.bullets.add(bul);
				oldTime = currentTime;

			}

			rect = new Rectangle((int) getX_Point(), (int) getY_Point(), 30, 30);
			point = new Point((int) (getX_Point() + (getWidth() / 2)),
					(int) (getY_Point() + (getHeight() / 2)));
		}
	}

	
	//SC, Method not needed, delete it if you want!
//	private double[] getDig(double[] d) {  
//
//		if (d[0] > 2 || d[1] > 2) {
//			d[0] = d[0] / 2;
//			d[1] = d[1] / 2;
//			getDig(d);
//		}
//		return d;
//
//	}

}
