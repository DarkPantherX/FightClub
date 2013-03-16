import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


public class ShooterEnemy extends Enemy{

	
	private long oldTime=0;
	
	public ShooterEnemy(int x_Point, int y_Point, int width, int height,
			Image img, int life, boolean visible) {
		super(x_Point, y_Point, width, height, img, life, visible);
		
		
		
		
	}
	
	public void update(){
		Player player = FightClub.getNearestPlayer();
		double vely=FightClub.HEIGHT/500+1;
		double velx=FightClub.WIDTH/500+1;
		
		
		if(FightClub.WIDTH-25>getX_Point()+15){
			setX_Point(getX_Point()+velx);
		}
		
		if(FightClub.WIDTH-25<getX_Point()+15){
			setX_Point(getX_Point()-velx);
		}
		if(FightClub.HEIGHT-25<getY_Point()+15){
			setY_Point(getY_Point()-vely);
		}
		if(FightClub.HEIGHT-25>getY_Point()+15){
			setY_Point(getY_Point()+vely);
		}
			
		
		
		long currentTime = System.currentTimeMillis();
		if(currentTime>oldTime+5000){
			double d[] = new double[2];
			d[0]=player.getX_Point()-getX_Point();
			d[1]=player.getY_Point()-getY_Point();
			double c[]=getDig(d);
		
			//sorry sc, had to add a number to your enemy, because of changed bullet strength (look under Bullet ->power)
			Bullet bul = new Bullet(10,10,c[0],c[1],(int)(getX_Point()-c[0]),(int)(getY_Point()+c[1]),0,1);
			FightClub.bullets.add(bul);
			oldTime= currentTime;
			
		}
		
		rect = new Rectangle((int)getX_Point(),(int)getY_Point(),30,30);
		point = new Point((int)(getX_Point()+(getWidth()/2)),(int)(getY_Point()+(getHeight()/2)));
		
		}
	

	private double[] getDig(double[] d) {
		if(d[0]>2||d[1]>2){
			d[0]=d[0]/2;
			d[1]=d[1]/2;
			getDig(d);
			}
			return d;
			
		
		}
	

}
