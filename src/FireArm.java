public class FireArm extends Weapon {

	private double speed;
	private int bulletSizeX;
	private int bulletSizeY;
	
	
	public FireArm(String weaponName, int ammo, int power, double speed, int bulletSizeX, int bulletSizeY,boolean eternalAmmo){
		setWeaponName(weaponName);
		setAmmo(ammo);
		setMAX_AMMO(ammo);
		setPower(power);
		setSpeed(speed);
		setBulletSizeX(bulletSizeX);
		setBulletSizeY(bulletSizeY);
		setEternalAmmo(eternalAmmo);
		
	}

	//creating a gun, that's already made!

	public static FireArm createGun(){
		FireArm arm= new FireArm("Gun",0,1,5,10,10,true);
		
		return arm;
	}
	
	
	
	
	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the bulletSize
	 */
	public int getBulletSizeX() {
		return bulletSizeX;
	}

	/**
	 * @param bulletSize the bulletSize to set
	 */
	public void setBulletSizeX(int bulletSizeX) {
		this.bulletSizeX = bulletSizeX;
	}

	/**
	 * @return the bulletSizeY
	 */
	public int getBulletSizeY() {
		return bulletSizeY;
	}

	/**
	 * @param bulletSizeY the bulletSizeY to set
	 */
	public void setBulletSizeY(int bulletSizeY) {
		this.bulletSizeY = bulletSizeY;
	}
	
	
}
