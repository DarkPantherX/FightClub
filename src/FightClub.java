import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FightClub extends JPanel implements Runnable{

	/**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;


	private static boolean paused=false;

	private Player player;
	private InputHandler inHandler;

	public static final int NUMKEYS=5;
	


	/**
	 * @param args
	 * 
	 */
	
	public FightClub(){
		Image img= new ImageIcon(getClass().getResource("img/player.png")).getImage();
		
		

		
		
		
		player = new Player(50,50,50,50, img,10);
		inHandler = new InputHandler();
		addKeyListener(inHandler);
		new Thread(this).start();
	}
	

	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;

		g2.clearRect(0, 0, 500, 500);
		player.draw(g2);
	}
	
	
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		paused=false;
		final FightClub mainP =new FightClub();
		frame.add(mainP);
		frame.setVisible(true);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}
	


	public void run() {
		while (!paused) {
			boolean a[]= new boolean[4];
			double b=0;
			
			if(inHandler.getKeys()[KeyEvent.VK_W]){
				a[0]=true;
				
			}
			if(inHandler.getKeys()[KeyEvent.VK_S]){
				a[1]=true;
				
			}
			if(inHandler.getKeys()[KeyEvent.VK_A]){
				a[2]=true;
				
			}
			if(inHandler.getKeys()[KeyEvent.VK_D]){
				a[3]=true;
				
			}
			
			if(inHandler.getKeys()[KeyEvent.VK_UP]){
				b=b+0.01;
				
			}
			
			if(inHandler.getKeys()[KeyEvent.VK_DOWN]){
				b=b-0.01;
				
			}
			
			player.update(a,b);
			
			for(int i=0;i<4;i++){
				a[i]=false;
			}
			
			
			repaint();
			dosleepover();
			try {
				Thread.sleep((long) 5.0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void dosleepover(){
		
		System.out.print("asdf");
		
	}
	
	
}
