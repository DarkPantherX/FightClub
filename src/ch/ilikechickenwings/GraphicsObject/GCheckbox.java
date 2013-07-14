package ch.ilikechickenwings.GraphicsObject;


import java.awt.Image;
import java.awt.Toolkit;



public class GCheckbox extends GObject {

	
	private boolean checked=false;


	private Image check=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("img/checked.png")));
	private Image uncheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("img/unchecked.png")));
	private Image selcheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("img/selchecked.png")));
	private Image seluncheck=Toolkit.getDefaultToolkit().getImage(
			(getClass().getResource("img/selunchecked.png")));
	
	
	public GCheckbox(int xCor, int yCor, int width, int height, String str) {
		super(xCor, yCor, width, height,str);
		
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
	
	
	public void clicked(OptionsMenu optionsMenu){
		checked=!checked;
		if(checked){
			setImg(selcheck);
		}else{
			setImg(seluncheck);
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
