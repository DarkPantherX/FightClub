import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;



	

public class Bullet extends GameComponents implements Renderer{


	

	public int dirX;
	public int dirY;
	public double grad;
	private Image img=  Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/bullet.png"));
	private Point point;
	
	public Bullet(int width, int height, int dirX, int dirY,int x_Point, int y_Point, double grad){
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


		public int getDirX() {
		return dirX;
	}


	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
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
		
		double velx=((FightClub.WIDTH/500))*5;
		double vely=((FightClub.WIDTH/500))*5;

		setX_Point(getX_Point()+((getDirX()/20)*velx));
		setY_Point(getY_Point()+((getDirY()/20)*vely));
		setPoint(new Point((int)(getX_Point()+5),(int)(getY_Point()+5)));
		
		
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

	
}
