import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Player extends Entity implements Renderer{

	private Bullet bullet;
	
	
	public Player(int x_Point,int  y_Point,int width,int height,Image img,int life){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
			
		
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


	
	
	



}


