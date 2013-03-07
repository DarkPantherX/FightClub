import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	private long currentTime;
	private long oldTime=0;
	private long lastTime=0;
	private long timeBetweenFrames=0;
	private boolean a[]= new boolean[NUMKEYS];





	private double b=0;
	
	
	
	public static final int NUMKEYS=5;
	public static ArrayList<Bullet> bullets= new ArrayList<Bullet>();
	public static double lasttime=0;
	


	/**
	 * @param args
	 * 
	 */
	
	public FightClub(){
		Image imgp1= new ImageIcon(getClass().getResource("img/player.png")).getImage();
		
		

		
		
		bullets = new ArrayList<Bullet>();
		player = new Player(50,50,50,50, imgp1,10);
		inHandler = new InputHandler();
		addKeyListener(inHandler);
		
		new Thread(this).start();
	}
	

	
	public void paintComponent(Graphics g){
		
		
		Graphics2D g2 = (Graphics2D)g;

		g2.clearRect(0, 0, 500, 500);

		for(int w=0; w<bullets.size();w++){
		Bullet bul = (Bullet) bullets.get(w);
		
		if(bul.getX_Point()>500||bul.getX_Point()<0||bul.getY_Point()>500||bul.getY_Point()<0){
			bullets.remove(w);
		}else{
			System.out.println("Works: "+w);
		bul.render(g2);
			}
		}
		player.render(g2);
		
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
			
			currentTime = System.nanoTime();
			timeBetweenFrames =1000000000/( currentTime - lastTime);
			System.out.println(timeBetweenFrames);
			lastTime = currentTime;
//			System.out.println(1000/timeBetweenFrames);


			
			
			
			
			update();
			repaint();

			try {
				Thread.sleep((long) 1.0);
			} catch (InterruptedException e) {
				System.out.println("Coulden't start sleep:" +e);
				e.printStackTrace();
			}
		}
	}

	public void update(){
		
		
		if(currentTime >(oldTime+2000000)){

		
		getA();
		
		player.update(a,b);
		
		for(int w=0; w<bullets.size();w++){
			Bullet bul = (Bullet) bullets.get(w);
			bul.update();
		}
		
		
		for(int i=0;i<NUMKEYS;i++){
			a[i]=false;
		
			}	
		oldTime=currentTime;
		}
	}

	public static ArrayList<Bullet> getBullets() {
		return bullets;
	}



	public static double getLasttime() {
		return lasttime;
	}



	public static void setLasttime(double lasttime) {
		FightClub.lasttime = lasttime;
	}


	public boolean[] getA() {
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
		
		
		if(inHandler.getKeys()[KeyEvent.VK_SPACE]){
			a[4]=true;
			
		}
		
		
		return a;
	}

	
	//asdf

}
