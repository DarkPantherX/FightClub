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
		 g.drawImage(getImg(), getX_Point(), getY_Point(), null);
		
	}
	
	
	public void update(){
		Player player = FightClub.getNearestPlayer();
		if(player.getX_Point()>getX_Point()){
			setX_Point(getX_Point()+1);
		}
		
		if(player.getX_Point()<getX_Point()){
			setX_Point(getX_Point()-1);
		}
		if(player.getY_Point()<getY_Point()){
			setY_Point(getY_Point()-1);
		}
		if(player.getY_Point()>getY_Point()){
			setY_Point(getY_Point()+1);
		}
		rect = new Rectangle(getX_Point(),getY_Point(),30,30);
		
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return rect;
	}
	

}
