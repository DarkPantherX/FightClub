package ch.ilikechickenwings;


public class Weapon {
	
	private String weaponName;
	private int ammo;
	private int MAX_AMMO;
	private int power;
	private boolean eternalAmmo;
	
	/**
	 * @return the weaponName
	 */
	public String getWeaponName() {
		return weaponName;
	}
	/**
	 * @param weaponName the weaponName to set
	 */
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	/**
	 * @return the ammo
	 */
	public int getAmmo() {
		return ammo;
	}
	/**
	 * @param ammo the ammo to set
	 */
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	/**
	 * @return the mAX_AMMO
	 */
	public int getMAX_AMMO() {
		return MAX_AMMO;
	}
	/**
	 * @param mAX_AMMO the mAX_AMMO to set
	 */
	public void setMAX_AMMO(int mAX_AMMO) {
		MAX_AMMO = mAX_AMMO;
	}
	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/**
	 * @return the eternalAmmo
	 */
	public boolean hasEternalAmmo() {
		return eternalAmmo;
	}
	/**
	 * @param eternalAmmo the eternalAmmo to set
	 */
	public void setEternalAmmo(boolean eternalAmmo) {
		this.eternalAmmo = eternalAmmo;
	}
	
	
}
