
import java.awt.Image;



public class Entity {

	
	private int x_Point;
	private int y_Point;
	private int width;
	private int height;
	private Image img;
	private int life;
	private double grad;
	
	
	
	
	
	public void update(boolean a[],double b) {
		if(a[0]){setY_Point(getY_Point()-1);}
		if(a[1]){setY_Point(getY_Point()+1);}
		if(a[2]){setX_Point(getX_Point()-1);}
		if(a[3]){setX_Point(getX_Point()+1);}
		grad=grad+b;
		
	}
	
	
	
	/**
	 * @return the x_Point
	 */
	public int getX_Point() {
		return x_Point;
	}



	/**
	 * @param x_Point the x_Point to set
	 */
	public void setX_Point(int x_Point) {
		this.x_Point = x_Point;
	}



	/**
	 * @return the y_Point
	 */
	public int getY_Point() {
		return y_Point;
	}



	/**
	 * @param y_Point the y_Point to set
	 */
	public void setY_Point(int y_Point) {
		this.y_Point = y_Point;
	}



	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}



	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}



	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
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
	
	
	
	
	
	
}
