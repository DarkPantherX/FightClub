package ch.ilikechickenwings.Menu;


import java.awt.Graphics2D;

import ch.ilikechickenwings.FightClub;
import ch.ilikechickenwings.GraphicsObject.GListener;



public class Menu {
	
	private GListener gListener;
	
	public void render(Graphics2D g2){}
	public void update(FightClub fightclub, boolean[] a){}
	
	protected void addGListener() {
		setgListener(gListener);
		
	}
	/**
	 * @return the gListener
	 */
	public GListener getgListener() {
		return gListener;
	}
	/**
	 * @param gListener the gListener to set
	 */
	public void setgListener(GListener gListener) {
		this.gListener = gListener;
	}
	
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
	 * > About
	 * > Quit // TODO
	 * 
	 * - PauseMenu.java:
	 * Pause can be summoned with Esc during the Singleplayergame
	 * With "Links to"
	 * > Resume 
	 * > Restart
	 * > Main menu
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
	 * - AboutMenu.java
	 * Shows those who worked in this Project // TODO
	 * With "Link to"
	 * > Main menu 
	 * > Exit 
	 * 
	 */
	
	
}
