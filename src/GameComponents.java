
public class GameComponents {

	private double x_Point;
	private double y_Point;
	private int width;
	private int height;
	private int disabledTime=0;
	private boolean visible;
	private boolean disabled;
	
	
	
	
	/**
	 * @return the x_Point
	 */
	public double getX_Point() {
		return x_Point;
	}



	/**
	 * @param d the x_Point to set
	 */
	public void setX_Point(double d) {
		this.x_Point = d;
	}



	/**
	 * @return the y_Point
	 */
	public double getY_Point() {
		return y_Point;
	}



	/**
	 * @param d the y_Point to set
	 */
	public void setY_Point(double d) {
		this.y_Point = d;
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



	public boolean isVisible() {
		return visible;
	}



	public void setVisible(boolean visible) {
		this.visible = visible;
	}



	/**
	 * @return the diabled
	 */
	public boolean isDisabled() {
		return disabled;
	}



	/**
	 * @param diabled the diabled to set
	 */
	public void setDisabled(boolean diabled) {
		this.disabled = diabled;
	}



	/**
	 * @return the disabledTime
	 */
	public int getDisabledTime() {
		return disabledTime;
	}



	/**
	 * @param disabledTime the disabledTime to set
	 */
	public void setDisabledTime(int disabledTime) {
		this.disabledTime = disabledTime;
	}




	
	
}
