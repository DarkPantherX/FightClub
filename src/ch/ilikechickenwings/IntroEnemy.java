package ch.ilikechickenwings;

import java.awt.Graphics2D;
import java.awt.Toolkit;



public class IntroEnemy extends Entity implements Renderer{
	
	private int id;
	private int dir;
	private long oldTime=0;
	
	
	public IntroEnemy(int x_Point,int y_Point,int width,int height, int id, int dir){
		this.setX_Point(x_Point);
		this.setY_Point(y_Point);
		this.setWidth(width);
		this.setHeight(height);
		this.setId(id);
		this.setDir(dir);
		
		if(id==0){
			setImg(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/enemy.png")));
		}else if(id==1){
			setImg(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/enemy2.png")));
		}else if(id==2){
			setImg(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/enemy3.png")));
		}else if(id==3){
			setImg(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/enemyking.png")));
		}
		
	}

	private void setDir(int dir) {
		this.dir=dir;
		
	}

	private void setId(int id2) {
		this.id=id2;
		
	}

	@Override
	public void render(Graphics2D g) {
		 g.drawImage(getImg(), (int)getX_Point(), (int)getY_Point(),getWidth(),getHeight(), null);
		
	}
	
	
	public void update(){
		 long currentTime= System.currentTimeMillis();
		
		if(currentTime>oldTime+10){
		if(dir==0){
			setX_Point(getX_Point()+1);
			
		}else if(dir==1){
			setX_Point(getX_Point()-1);
			
		}else if(dir==2){
			
			setX_Point(getX_Point()+1);
		
			
		}
		oldTime=currentTime;
		}
		
		
	}

	public int getId() {
		return id;
	}

	public int getDir() {
		
		return dir;
	}



}
