import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


public class Enemy extends Entity implements Renderer{
	
	Rectangle rect;
	
	
	public Enemy(int x_Point,int  y_Point,int width,int height,Image img,int life){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		
		rect = new Rectangle(getX_Point(),getY_Point(),30,30);
	}

	@Override
	public void render(Graphics2D g) {
		 g.drawImage(getImg(), getX_Point(), getY_Point(),getWidth(),getHeight(), null);
		
	}
	
	
	public void update(){
		Player player = FightClub.getNearestPlayer();
		double b=FightClub.HEIGHT/500+1;
		int vel=(int)b;
		
		
		if(player.getX_Point()+25>getX_Point()+15){
			setX_Point(getX_Point()+vel);
		}
		
		if(player.getX_Point()+25<getX_Point()+15){
			setX_Point(getX_Point()-vel);
		}
		if(player.getY_Point()+25<getY_Point()+15){
			setY_Point(getY_Point()-vel);
		}
		if(player.getY_Point()+25>getY_Point()+15){
			setY_Point(getY_Point()+vel);
		}
		rect = new Rectangle(getX_Point(),getY_Point(),30,30);
		
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return rect;
	}
	

}
