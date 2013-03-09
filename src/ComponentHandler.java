import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class ComponentHandler implements ComponentListener{
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent ce) {
		Component c = ce.getComponent();
       FightClub.HEIGHT=c.getHeight();
       FightClub.WIDTH=c.getWidth();
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
