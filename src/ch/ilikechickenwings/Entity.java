package ch.ilikechickenwings;


import java.awt.Image;



public class Entity extends GameComponents{

	
	
	private Image img;
	private int life;
	private int maxLife;
	

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



	
	
	public int getMaxLife() {
		return maxLife;
	}





	public void setMaxLife(int mAXLIFE) {
		maxLife = mAXLIFE;
	}





	public boolean hasDamge(){
		
		if(maxLife>life){
			
			return false;
		}else{
			
			return true;
		}
		
		
	}
	
	
	
}
