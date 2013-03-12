
import java.awt.Image;



public class Entity extends GameComponents{

	
	
	private Image img;
	private int life;
	private int MAXLIFE;
	

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



	
	
	public boolean hasDamge(){
		
		if(MAXLIFE>life){
			
			return false;
		}else{
			
			return true;
		}
		
		
	}
	
	
	
}
