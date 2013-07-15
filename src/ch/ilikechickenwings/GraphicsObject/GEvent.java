package ch.ilikechickenwings.GraphicsObject;

public class GEvent {
	
	private String source;
	private int value;
	private boolean state;
	
	public GEvent(String str){
	
		this.setSource(str);
		
	}
	
	public GEvent(String str,int value){
		
		this.setSource(str);
		this.setValue(value);
		
	}
	public GEvent(String str, boolean state){
		
		this.setSource(str);
		this.setState(state);
		
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

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the state
	 */
	public boolean getState() {
		return state;
	}

	/**
	 * @param state2 the state to set
	 */
	public void setState(boolean state2) {
		this.state = state2;
	}

}
