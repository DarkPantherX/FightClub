import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;


public class Bullet extends GameComponents implements Renderer{


	

	public int dirX;
	public int dirY;
	public double grad;
	private Image img= new ImageIcon(getClass().getResource("img/bullet.png")).getImage();
	
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
		g.drawImage(getImg(), getX_Point(), getY_Point(), null);
		
	}

	private Image getImg() {
		
		return img;
	}





	public void update(){
		
		setX_Point(getX_Point()+(getDirX()/20));
		setY_Point(getY_Point()+(getDirY()/20));
		
		
	}

	
}
