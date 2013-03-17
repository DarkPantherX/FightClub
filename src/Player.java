import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Player extends Entity implements Renderer {

	private AffineTransform rot = new AffineTransform();
	private Rectangle rect;
	private FightClub fightclub;
	private boolean[] a;
	private long oldTime = 0;
	private double grad;
	private Bullet bullet;

	public Player(int x_Point, int y_Point, int width, int height, Image img,
			int life, boolean visible) {
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		this.setMaxLife(life);
		this.setVisible(visible);

	}

	public void render(Graphics2D g) {

		rot.setToRotation(getGrad(), getX_Point() + getWidth() / 2,
				getY_Point() + getHeight() / 2);
		setRect(new Rectangle((int) getX_Point(), (int) getY_Point(),
				getWidth(), getHeight()));

		AffineTransform trans = new AffineTransform();
		trans.rotate(getGrad(), getX_Point() + getWidth() / 2, getY_Point()
				+ getHeight() / 2);
		g.setTransform(trans);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(getImg(), (int) getX_Point(), (int) getY_Point(), null);

		double lifePiece = getWidth() / getMaxLife();
		// draws the life of the player
		for (int i = 1; i <= getLife(); i++) {
			g.setColor(Color.green);
			g.fillRect((int) (getX_Point() - lifePiece + lifePiece * i),
					(int) getY_Point(), (int) lifePiece, 7);

		}
		// this draws the life, that has been lost
		for (int i = getLife() + 1; i < getMaxLife() + 1; i++) {
			g.setColor(Color.red);
			g.fillRect((int) (getX_Point() - lifePiece + lifePiece * i),
					(int) getY_Point(), (int) lifePiece, 7);

		}

	}

	public void update(boolean a[], double b, FightClub fightclub) {
		this.a = a;
		this.fightclub = fightclub;
		long currentTime = System.currentTimeMillis();

		double vel = 1; // 1 means 1/5 of the size of the field per second

		int dx = 0; // can be 0, -1, 1 just for the direction
		int dy = 0;
		if (a[0]) { // W
			dy -= 1;
		}
		if (a[1]) { // S
			dy += 1;
		}
		if (a[2]) { // A
			dx -= 1;
		}
		if (a[3]) { // D
			dx += 1;
		}
		if (dx != 0 && dy != 0) { // diagonal
			setX_Point(getX_Point() + dx / Math.sqrt(2) * vel * FightClub.WIDTH
					/ (double) 500);
			setY_Point(getY_Point() + dy / Math.sqrt(2) * vel
					* FightClub.HEIGHT / (double) 500);
		} else if (dy != 0) {
			setY_Point(getY_Point() + dy * vel * FightClub.HEIGHT
					/ (double) 500);
		} else if (dx != 0) {
			setX_Point(getX_Point() + dx * vel * FightClub.WIDTH / (double) 500);
		}

		if (currentTime > oldTime + 500) {
			if (a[6]) {
				fightclub.setMenu(new PauseMenu());
				aIsDone();
				oldTime = currentTime;
			}
		}

		grad = b;
		double i = (getX_Point() + 25 - Math.cos(grad) * 25);
		double j = (getY_Point() + 25 - Math.sin(grad) * 25);

		double m = (getX_Point() + 25 + Math.cos(grad) * 25);
		double n = (getY_Point() + 25 + Math.sin(grad) * 25);

		double dirX = (i - m);
		double dirY = (j - n);

		if (a[4]) {
			long time = System.currentTimeMillis();
			if (FightClub.getLasttime() + 500 < time) {
				FightClub.setLasttime(time);
				bullet = new Bullet(10, 10, dirX, dirY, (int) i - 5,
						(int) j - 5, grad, getPower());
				// System.out.println("Works over here!" + bullet.getY_Point());
				FightClub.getBullets().add(bullet);
			}

		}

		// System.out.println(i + " "+ j);
		// System.out.println(m + " "+ n);
		// System.out.println(dirX+" "+ dirY);
	}

	private int getPower() {
		int power = 1;

		return power;
	}

	/**
	 * @return the rect
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * @param rect
	 *            the rect to set
	 */
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public AffineTransform getRot() {
		return rot;
	}

	public void setRot(AffineTransform rot) {
		this.rot = rot;
	}

	public void aIsDone() {

		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}

		fightclub.setA(a);
	}

	/**
	 * @return the fightclub
	 */
	public FightClub getFightclub() {
		return fightclub;
	}

	/**
	 * @param fightclub
	 *            the fightclub to set
	 */
	public void setFightclub(FightClub fightclub) {
		this.fightclub = fightclub;
	}

	/**
	 * @param grad
	 *            the grad to get
	 */

	public double getGrad() {
		return grad;
	}

	/**
	 * @param grad
	 *            the grad to set
	 */
	public void setGrad(double grad) {
		this.grad = grad;
	}

}
