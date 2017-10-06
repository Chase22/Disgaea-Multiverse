package org.disgea.data.character;

public class Attributes {
	private int strength;
	private int defense;
	private int intelligence;
	private int resistance;
	private int hit;
	private int speed;
	private int initiative;
	private int movement;
	private int luck;

	public void changeAttributes(int strength, int defense, int intelligence, int resistance, int hit, int speed,
			int initiative, int movement, int luck) {
		changeDefense(defense);
		changeHit(hit);
		changeInitiative(initiative);
		changeIntelligence(intelligence);
		changeLuck(luck);
		changeMovement(movement);
		changeResistance(resistance);
		changeSpeed(speed);
		changeStrength(strength);
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void changeStrength(int change) {
		this.strength += change;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void changeDefense(int change) {
		this.defense += change;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void changeIntelligence(int change) {
		this.intelligence += change;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public void changeResistance(int change) {
		this.resistance += change;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public void changeHit(int change) {
		this.hit += change;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void changeSpeed(int change) {
		this.speed += change;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public void changeInitiative(int change) {
		this.initiative += change;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public void changeMovement(int change) {
		this.movement += change;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public void changeLuck(int change) {
		this.luck += change;
	}

}
