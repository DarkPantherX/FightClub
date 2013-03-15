import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


public class Enemy extends Entity implements Renderer{
	
	Rectangle rect;
	Point point;
	
	
	public Enemy(int x_Point,int  y_Point,int width,int height,Image img,int life,boolean visible){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setImg(img);
		this.setLife(life);
		this.setVisible(visible);
		
		rect = new Rectangle((int)getX_Point(),(int)getY_Point(),30,30);
	}

	@Override
	public void render(Graphics2D g) {
		 g.drawImage(getImg(), (int)getX_Point(), (int)getY_Point(),getWidth(),getHeight(), null);
		
	}
	
	
	public void update(){
		Player player = FightClub.getNearestPlayer();
		double vely=FightClub.HEIGHT/500+1;
		double velx=FightClub.WIDTH/500+1;
		
		
		if(!player.isVisible()){
			
			setX_Point(getX_Point()+1);
			
		}else{
		
		if(player.getX_Point()+25>getX_Point()+15){
			setX_Point(getX_Point()+velx);
		}
		
		if(player.getX_Point()+25<getX_Point()+15){
			setX_Point(getX_Point()-velx);
		}
		if(player.getY_Point()+25<getY_Point()+15){
			setY_Point(getY_Point()-vely);
		}
		if(player.getY_Point()+25>getY_Point()+15){
			setY_Point(getY_Point()+vely);
		}
		rect = new Rectangle((int)getX_Point(),(int)getY_Point(),30,30);
		point = new Point((int)(getX_Point()+(getWidth()/2)),(int)(getY_Point()+(getHeight()/2)));
		}
	}

	public Rectangle getRect() {

		return rect;
	}

	public Point getPoint() {
		
		return point;
	}
	

}
