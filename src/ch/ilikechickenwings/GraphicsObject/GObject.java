package ch.ilikechickenwings.GraphicsObject;

import java.awt.Image;

public class GObject {

	private int xCor;
	private int yCor;
	private int width;
	private int height;
	private String str;
	protected boolean selected=false;
	private Image img;
	private String name;
	
	
	
	public GObject(int xCor, int yCor, int width, int height, String str,String name){
		this.setxCor(xCor);
		this.setyCor(yCor);
		this.setWidth(width);
		this.setHeight(height);
		this.setStr(str);
		this.setName(name);
	}


	/**
	 * @return the xCor
	 */
	public int getxCor() {
		return xCor;
	}


	/**
	 * @param xCor the xCor to set
	 */
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}


	/**
	 * @return the yCor
	 */
	public int getyCor() {
		return yCor;
	}


	/**
	 * @param yCor the yCor to set
	 */
	public void setyCor(int yCor) {
		this.yCor = yCor;
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
	 * @return the str
	 */
	public String getStr() {
		return str;
	}


	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}



	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(Image img) {
		this.img = img;
	}

	public void switched() {}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	
}
