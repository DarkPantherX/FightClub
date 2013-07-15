package ch.ilikechickenwings.GraphicsObject;


import java.awt.Image;
import java.awt.Toolkit;

import ch.ilikechickenwings.Menu.Menu;



public class GCheckbox extends GObject {

	
	private boolean checked;

	private Image check=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("/ch/ilikechickenwings/img/checked.png")));
	private Image uncheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("/ch/ilikechickenwings/img/unchecked.png")));
	private Image selcheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("/ch/ilikechickenwings/img/selchecked.png")));
	private Image seluncheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("/ch/ilikechickenwings/img/selunchecked.png")));
	
	
	public GCheckbox(int xCor, int yCor, int width, int height, String str, String name, boolean state) {
		super(xCor, yCor, width, height,str, name);
		setChecked(state);
		
	}
	
	@Override
	public void switched() {
		if(selected){
			if(checked){
				setImg(selcheck);
			}else{
				setImg(seluncheck);
			}
		}else{
			if(checked){
				setImg(check);				
			}else{
				setImg(uncheck);
			}
		}
		
	}
	
	
	public void clicked(Menu menu){
		checked=!checked;
		if(checked){
			setImg(selcheck);
			menu.getgListener().actionPerformed(new GEvent(getName(),checked));
		}else{
			setImg(seluncheck);
			menu.getgListener().actionPerformed(new GEvent(getName(),checked));
		}
		
	}
	
	
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}


}
