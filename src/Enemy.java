import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class Enemy extends Entity implements Renderer {

	Rectangle rect;
	Point point;

	public Enemy(int x_Point, int y_Point, int width, int height, Image img,
			int life, boolean visible) {
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		this.setVisible(visible);

		rect = new Rectangle((int) getX_Point(), (int) getY_Point(), 30, 30);
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(getImg(), (int) getX_Point(), (int) getY_Point(),
				getWidth(), getHeight(), null);

	}

	public void update() {
		Player player = FightClub.getNearestPlayer();
		double vely = FightClub.HEIGHT / (double) 500;
		double velx = FightClub.WIDTH / (double) 500;
		double vel = 1;

		if (!player.isVisible()) {

			// setX_Point(getX_Point() + 1);

		} else {
			double dx = player.getX_Point() + 25 - (this.getX_Point() + 15);
			double dy = player.getY_Point() + 25 - (this.getY_Point() + 15);

			this.setX_Point(getX_Point()+dx/Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2))*vel*FightClub.WIDTH/(double)500);
			this.setY_Point(getY_Point()+dy/Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2))*vel*FightClub.HEIGHT/(double)500);
			
			rect = new Rectangle((int) getX_Point(), (int) getY_Point(), 30, 30);
			point = new Point((int) (getX_Point() + (getWidth() / 2)),
					(int) (getY_Point() + (getHeight() / 2)));
		}
	}

	public Rectangle getRect() {

		return rect;
	}

	public Point getPoint() {

		return point;
	}

}
