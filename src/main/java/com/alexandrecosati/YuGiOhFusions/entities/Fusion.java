package com.alexandrecosati.YuGiOhFusions.entities;

import java.util.List;

public class Fusion {
	
	private int first_card_id;
	private int second_card_id;
	private Card monster;
	//private Fusion nextFusion;
	private List<Fusion> nextFusions;
	
	public Fusion() {}
	
	public Fusion(int id1, int id2, Card monster, List<Fusion> nextFusions) {
		this.first_card_id = id1;
		this.second_card_id = id2;
		this.monster = monster;
		//this.nextFusion = nextFusion;
		this.nextFusions = nextFusions;
		
	}

	public int getFirst_card_id() {
		return first_card_id;
	}

	public void setFirst_card_id(int first_card_id) {
		this.first_card_id = first_card_id;
	}

	public int getSecond_card_id() {
		return second_card_id;
	}

	public void setSecond_card_id(int second_card_id) {
		this.second_card_id = second_card_id;
	}

	public Card getMonster() {
		return monster;
	}

	public void setMonster(Card monster) {
		this.monster = monster;
	}

	public List<Fusion> getNextFusions() {
		return nextFusions;
	}

	public void setNextFusions(List<Fusion> nextFusions) {
		this.nextFusions = nextFusions;
	}
	
}
