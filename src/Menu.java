import java.awt.Graphics2D;


public interface Menu {

	public void render(Graphics2D g2);
	public void update(FightClub fightclub, boolean[] a);
	
	/*
	 * Short overview of the menus:
	 * 
	 * - IntroScreenMenu.java:
	 * Intro with DarkCoder
	 * 
	 * - StartMenu.java:
	 * Main menu with "Links to"
	 * > Singleplayer
	 * > Multiplayer // TODO longterm
	 * > About // TODO AboutMenu.java
	 * > Quit // TODO
	 * 
	 * - PauseMenu.java:
	 * Pause can be summoned with Esc during the Singleplayergame
	 * With "Links to"
	 * > Retry // TODO
	 * > Resume 
	 * > Main menu // TODO
	 * 
	 * - LooseMenu.java
	 * Displayed when live of player <= 0
	 * With "Links to"
	 * > Retry 
	 * > Main menu
	 * > Quit
	 * 
	 * TODO
	 * - WinMenu.java
	 * 
	 * TODO
	 * - AboutMenu.java
	 * With "Link to"
	 * > Main menu // TODO
	 * 
	 */
	
	
}
