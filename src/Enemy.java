import java.awt.Graphics2D;
import java.awt.Image;


public class Enemy extends Entity implements Renderer{
	
	
	
	
	public Enemy(int x_Point,int  y_Point,int width,int height,Image img,int life){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void update(){
		
		
		
	}
	

}
