package com.alexandrecosati.YuGiOhFusions.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Fusion {
	
	private Card firstCard;
	private Card secondCard;
	private Set<Card> materials; //Only used to avoid duplicates
	private Card monster;
	private Set<Fusion> nextFusions;
	
	public Fusion() {}
	
	public Fusion(Card firstCard, Card secondCard, Card monster, Set<Fusion> nextFusions) {
		this.firstCard = firstCard;
		this.secondCard = secondCard;
		this.materials = new HashSet<>();
		materials.add(firstCard);
		materials.add(secondCard);
		this.monster = monster;
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

	public Set<Fusion> getNextFusions() {
		return nextFusions;
	}

	public void setNextFusions(Set<Fusion> nextFusions) {
		this.nextFusions = nextFusions;
	}

	public Set<Card> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<Card> materials) {
		this.materials = materials;
	}

	@Override
	public int hashCode() {
		return Objects.hash(materials);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fusion other = (Fusion) obj;
		return Objects.equals(materials, other.materials);
	}
	
}
