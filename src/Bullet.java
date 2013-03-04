import java.awt.Color;
import java.awt.Graphics2D;


public class Bullet extends GameComponents implements Renderer{


	public int dirX;
	public int dirY;
	
	
	public Bullet(int width, int height, int dirX, int dirY,int x_Point, int y_Point){
		this.setWidth(width);
		this.setHeight(height);
		this.setDirX(dirX);
		this.setDirY(dirY);
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		
		
		
		
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
		g.setColor(Color.white);
		g.fillRect(getX_Point(),getY_Point(),getWidth(),getHeight());
		
	}



	
}
