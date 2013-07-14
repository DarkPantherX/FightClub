package ch.ilikechickenwings.GraphicsObject;

public class GEvent {
	
	private String source;
	
	public GEvent(String str){
	
		this.setSource(str);
		
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

}
