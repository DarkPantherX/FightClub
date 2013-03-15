import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;



	

public class Bullet extends GameComponents implements Renderer{


	

	public double dirX;
	public double dirY;
	public double grad;
	private Image img=  Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/bullet.png"));
	private Point point;
	private Rectangle rect;
	
	public Bullet(int width, int height, double dirX, double dirY,int x_Point, int y_Point, double grad){
		this.setWidth(width);
		this.setHeight(height);
		this.setDirX(dirX);
		this.setDirY(dirY);
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setGrad(grad);
		
		
		
		
	}
	

	
	
	
		private void setGrad(double grad) {
		this.grad=grad;
		
	}


		private double getGrad() {
			
			return grad;
		}


		public double getDirX() {
		return dirX;
	}


	public void setDirX(double dirX) {
		this.dirX = dirX;
	}

	public double getDirY() {
		return dirY;
	}

	public void setDirY(double dirY) {
		this.dirY = dirY;
	}



	public void render(Graphics2D g) {
		
		
		AffineTransform trans = new AffineTransform();
	    trans.rotate(getGrad(),getX_Point()+getWidth() / 2, getY_Point()+getHeight() / 2);
	    g.setTransform(trans);
	    g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(getImg(), (int)getX_Point(), (int)getY_Point(), null);
		
	}

	private Image getImg() {
		
		return img;
	}





	public void update(){
		
		double velx=((FightClub.WIDTH/(double)500))*5;
		double vely=((FightClub.HEIGHT/(double)500))*5;
		System.out.println(velx);
		setX_Point(getX_Point()+((getDirX()/20)*velx));
		setY_Point(getY_Point()+((getDirY()/20)*vely));
		setPoint(new Point((int)(getX_Point()+5),(int)(getY_Point()+5)));
		rect = new Rectangle((int)getX_Point(),(int)getY_Point(),30,30);
		
	}





	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}





	/**
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}





	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return rect;
	}

	
}
