
public class JShoterLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Player player =new Player(10,460,20);
		new GameJShot(player);
		
		(new Thread(new ClientThread(player))).start();

	}

}
