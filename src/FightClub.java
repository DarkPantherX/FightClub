import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FightClub extends JPanel implements Runnable {

	/**
	 * 
	 */

	
	//2Coments
	
	private static final long serialVersionUID = 1L;

	private static boolean paused = false;

	private Player player;

	private InputHandler inHandler;
	private ComponentHandler compHandler;
	private long currentTime;
	private long oldTime = 0;
	private long lastTime = 0;
	private long timeBetweenFrames = 0;
	private long spawningTime = 0;
	private boolean a[] = new boolean[NUMKEYS];
	private Mode mode[] = new Mode[5];

	private double b = 0;

	private Menu menu;

	public static final int NUMKEYS = 7;
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static double lasttime = 0;
	public static int HEIGHT=500;
	public static int WIDTH=500;

	

	/**
	 * @param args
	 * 
	 */

	public FightClub() {
		Image imgp1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/player.png"));
		player = new Player(50, 50, 50, 50, imgp1, 10, false);
		players.add(player);
		inHandler = new InputHandler();
		compHandler =new ComponentHandler();
		addKeyListener(inHandler);
		addComponentListener(compHandler);
		setMenu(new IntroScreenMenu());
		
		new Thread(this).start();
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.black);
		g2.fillRect(0, 0, WIDTH, HEIGHT);

		
		if(menu==null){
		for (int w = 0; w < enemies.size(); w++) {
			Enemy enim = (Enemy) enemies.get(w);
			enim.render(g2);
		}

		for (int w = 0; w < bullets.size(); w++) {
			Bullet bul = (Bullet) bullets.get(w);

			if (bul.getX_Point() > WIDTH || bul.getX_Point() < 0
					|| bul.getY_Point() > HEIGHT || bul.getY_Point() < 0) {
				bullets.remove(w);
			} else {
				// System.out.println("Works: "+w);
				bul.render(g2);
			}
		}

		player.render(g2);
		}else{
			menu.render(g2);
			
			
		}
	}

	public void addNotify() {
		super.addNotify();
		requestFocus(); // nöf uf em frame, sondern uf em panel
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		paused = false;
		final FightClub mainP = new FightClub();
		frame.add(mainP);
		frame.setVisible(true);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void run() {
		while (!paused) {

			currentTime = System.nanoTime();
			timeBetweenFrames = 1000000000 / (currentTime - lastTime);
			// System.out.println(timeBetweenFrames);
			lastTime = currentTime;
			// System.out.println(1000/timeBetweenFrames);

			update();
			repaint(); // to paintcomponent

			try {
				Thread.sleep((long) 1.0);
			} catch (InterruptedException e) {
				System.out.println("Coulden't start sleep:" + e);
				e.printStackTrace();
			}
			
		}
	}

	public void update() {
		if(menu==null){
		player.setVisible(true); // Gehört da nicht rein
			if (currentTime > (oldTime + 10000000)) { // 1/100 sec
			
			getA();
			
			player.update(a,b,this);

			for (int w = 0; w < enemies.size(); w++) {
				Enemy enim = (Enemy) enemies.get(w);
				enim.update();
				enemyHittest(enim);
			}

			for (int w = 0; w < bullets.size(); w++) {
				Bullet bul = (Bullet) bullets.get(w);
				bul.update();
				bulletHittest(bul);
			}

			for (int i = 0; i < NUMKEYS; i++) {
				a[i] = false;

				}
			oldTime = currentTime;

			if (currentTime > (spawningTime + 3000000000L)) {

				spawnEnemies();
				spawningTime = currentTime;
			}

		}
		}else{
			if (currentTime > (oldTime + 100000000)) {	// jede 10tel sekunden
				menu.update(this,getA());
			
				oldTime=currentTime;
			}
		

		}
		}

	private void enemyHittest(Enemy enim) {
		if (player.getRot().createTransformedShape(player.getRect())
				.contains(enim.getPoint())) {

			
			enemies.remove(enim);
		}
		
	}

	private void bulletHittest(Bullet bullet) {
		if (player.getRot().createTransformedShape(player.getRect())
				.contains(bullet.getPoint())) {

			System.out.println("Autsch, selfshot");
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy enim = (Enemy) enemies.get(i);

			if (enim.getRect().intersects(bullet.getRect())) {

				enemies.remove(i);
				bullets.remove(bullet);

			}

		}

	}

	// aasfasdfasdfasdf

	private void spawnEnemies() {
		Image imge1 =  Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/enemy.png"));
		int x = 0;
		int y = 0;
		double o = Math.random();
		if (o < 0.25) {
			x = (int) (Math.random() * WIDTH);
			y = HEIGHT;
		} else if (o < 0.5) {
			x = (int) (Math.random() * WIDTH);
			y = 0;
		} else if (o < 0.75) {
			y = (int) (Math.random() * HEIGHT);
			x = WIDTH;
		} else if (o < 1) {
			y = (int) (Math.random() * HEIGHT);
			x = 0;
		}
		
		Enemy enim = new Enemy(x, y, 30, 30, imge1, 1, true);
		enemies.add(enim);

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
		
		if (inHandler.getKeys()[KeyEvent.VK_W]) {
			a[0] = true;

		}
		if (inHandler.getKeys()[KeyEvent.VK_S]) {
			a[1] = true;

		}
		if (inHandler.getKeys()[KeyEvent.VK_A]) {
			a[2] = true;

		}
		if (inHandler.getKeys()[KeyEvent.VK_D]) {
			a[3] = true;

		}

		if (inHandler.getKeys()[KeyEvent.VK_UP]) {
			b = b + 0.02;

		}

		if (inHandler.getKeys()[KeyEvent.VK_DOWN]) {
			b = b - 0.02;

		}

		if (inHandler.getKeys()[KeyEvent.VK_SPACE]) {
			a[4] = true;

		}
		if(inHandler.getKeys()[KeyEvent.VK_ENTER]){
			a[5]=true;
		}

		
		if(inHandler.getKeys()[KeyEvent.VK_ESCAPE]){
			a[6]=true;
		}
		
		return a;
	}
	

	
	
	
	

	public static Player getNearestPlayer() {
		Player play = null;
		for (int i = 0; i < players.size(); i++) {
			play = (Player) players.get(i);

		}
		return play;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;

	}

	public void setA(boolean[] a) {
		this.a = a;
	}



	// removed comments: also hinzugefüt
}
