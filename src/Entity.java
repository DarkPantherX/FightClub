
import java.awt.Image;



public class Entity extends GameComponents{

	
	
	private Image img;
	private int life;
	private int MAXLIFE;
	private double grad;
	private Bullet bullet;
	private FightClub fightclub;
	private boolean a[];
	private long oldTime=0;
	
	
	
	public void update(boolean a[],double b,FightClub fightclub) {
		this.a=a;
		this.fightclub=fightclub;
		long currentTime=System.currentTimeMillis();
		
		double vely=(double)FightClub.HEIGHT/(double)500;
		double velx=(double)FightClub.WIDTH/(double)500;
		System.out.println(FightClub.HEIGHT);
		
		
		if(a[0]){setY_Point(getY_Point()-vely);}
		if(a[1]){setY_Point(getY_Point()+vely);}
		if(a[2]){setX_Point(getX_Point()-velx);}
		if(a[3]){setX_Point(getX_Point()+velx);}
		if(currentTime>oldTime+500){
		if(a[6]){
			fightclub.setMenu(new PauseMenu());
			aIsDone();
			oldTime=currentTime;
		}
		}
		
		
		
		grad=b;
		double i = ( getX_Point()+25-Math.cos( grad ) * 25);
		double j=(getY_Point()+25-Math.sin( grad ) * 25 );
		
		double m = ( getX_Point()+25+Math.cos( grad ) * 25);
		double n=(getY_Point()+25+Math.sin( grad ) * 25 );
		
		int dirX=(int)(i-m);
		int dirY=(int)(j-n);
		
		if(a[4]){
			long time = System.currentTimeMillis();
			if(FightClub.getLasttime()+500<time){
				FightClub.setLasttime(time);
				bullet= new Bullet(10,10,dirX,dirY,(int)i-5,(int)j-5,grad);
				//System.out.println("Works over here!" + bullet.getY_Point());
				FightClub.getBullets().add(bullet);
			}
			
		}
		
//	System.out.println(i + " "+ j);	
//	System.out.println(m + " "+ n);	
//	System.out.println(dirX+" "+ dirY);
	}
	
	
	
	public void aIsDone(){
		
		for(int i=0;i<a.length;i++){
			a[i]=false;
		}
		
		
			fightclub.setA(a);
	}
	
	

	/**
	 * @return the color
	 */
	public Image getImg() {
		return img;
	}





	/**
	 * @param color the color to set
	 */
	public void setImg(Image img) {
		this.img = img;
	}



	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}



	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}



	/**
	 * @return the grad
	 */
	public double getGrad() {
		return grad;
	}



	/**
	 * @param grad the grad to set
	 */
	public void setGrad(double grad) {
		this.grad = grad;
	}





	/**
	 * @return the fightclub
	 */
	public FightClub getFightclub() {
		return fightclub;
	}





	/**
	 * @param fightclub the fightclub to set
	 */
	public void setFightclub(FightClub fightclub) {
		this.fightclub = fightclub;
	}
	
	
	public boolean hasDamge(){
		
		if(MAXLIFE>life){
			
			return false;
		}else{
			
			return true;
		}
		
		
	}
	
	
	
}
