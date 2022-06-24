package com.alexandrecosati.YuGiOhFusions.entities;

import java.util.List;

public class Fusion {
	
	private Card firstCard;
	private Card secondCard;
	private Card monster;
	//private Fusion nextFusion;
	private List<Fusion> nextFusions;
	
	public Fusion() {}
	
	public Fusion(Card firstCard, Card secondCard, Card monster, List<Fusion> nextFusions) {
		this.firstCard = firstCard;
		this.secondCard = secondCard;
		this.monster = monster;
		//this.nextFusion = nextFusion;
		this.nextFusions = nextFusions;	
	}

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card first_card) {
		this.firstCard = first_card;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card second_card) {
		this.secondCard = second_card;
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
