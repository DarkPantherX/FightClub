import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;


public class Message {
	
	private String message;
	private int xCor;
	private int yCor;
	private double showTime;
	private float colorS=1;
	
	public Message(String message, int xCor, int yCor, double showTime){
		this.setMessage(message);
		this.setxCor(xCor);
		this.setyCor(yCor);
		this.setShowTime(showTime);
		
		
		
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the showTime
	 */
	public double getShowTime() {
		return showTime;
	}

	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(double showTime) {
		this.showTime = showTime;
	}

	
	
	
	public void render(Graphics2D g2) {
		
		
		Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, colorS);
		g2.setComposite(comp);
		g2.setColor(Color.WHITE);
		g2.drawString(message,xCor,yCor);
		
		
		
	}

	public void update() {
		
		showTime-=0.5;
		colorS-=0.2f;
		yCor-=2;
			
	}

	
	public int check(){
		if(showTime<=0){
			
			return 0;	
			}else{
				return 1;
			}
		
	}
	
	
	
}
