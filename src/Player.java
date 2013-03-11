import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Player extends Entity implements Renderer{

	private AffineTransform rot = new AffineTransform();
	private Rectangle rect;
	
	public Player(int x_Point,int  y_Point,int width,int height,Image img,int life, boolean visible){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		this.setVisible(visible);
			
		
	}

	public void render(Graphics2D g) {
		
        rot.setToRotation(getGrad(),getX_Point()+getWidth() / 2, getY_Point()+getHeight() / 2);  
        setRect(new Rectangle(getX_Point(), getY_Point(), getWidth(), getHeight()));  

		

	    AffineTransform trans = new AffineTransform();
	    trans.rotate(getGrad(),getX_Point()+getWidth() / 2, getY_Point()+getHeight() / 2);
	    g.setTransform(trans);
	    g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
	    g.drawImage(getImg(), getX_Point(), getY_Point(), null);

		
		

	}

	/**
	 * @return the rect
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * @param rect the rect to set
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


	
	
	



}


