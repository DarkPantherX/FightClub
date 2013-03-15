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

	}

	


	public void update(boolean a[], double b, FightClub fightclub) {
		this.a = a;
		this.fightclub = fightclub;
		long currentTime = System.currentTimeMillis();

		double vely = (double) FightClub.HEIGHT / (double) 500;
		double velx = (double) FightClub.WIDTH / (double) 500;
		// System.out.println(FightClub.HEIGHT);

		if (a[0]) {
			setY_Point(getY_Point() - vely);
		}
		if (a[1]) {
			setY_Point(getY_Point() + vely);
		}
		if (a[2]) {
			setX_Point(getX_Point() - velx);

		}
		if (a[3]) {
			setX_Point(getX_Point() + velx);
		}
		if (currentTime > oldTime + 500) {
			if (a[6]) {
				fightclub.setMenu(new PauseMenu());
				//aIsDone();
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
						(int) j - 5, grad);
				// System.out.println("Works over here!" + bullet.getY_Point());
				FightClub.getBullets().add(bullet);
			}

		}

		// System.out.println(i + " "+ j);
		// System.out.println(m + " "+ n);
		// System.out.println(dirX+" "+ dirY);
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
