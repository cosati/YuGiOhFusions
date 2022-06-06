package com.alexandrecosati.YuGiOhFusions.entities;

import java.util.Objects;

import com.alexandrecosati.YuGiOhFusions.entities.enums.CardType;
import com.alexandrecosati.YuGiOhFusions.entities.enums.MonsterType;

public class Card {

    private int cardID;
    private String cardName;
    private int cardType;
    private int monsterType;
    private int level;
    private int atk;
    private int def;
    private int cost;

    public Card() {}

    public Card(int id,
                String name,
                int cardType,
                int monsterType,
                int level,
                int atk,
                int def,
                int cost) {
        this.cardID = id;
        this.cardName = name;
        this.cardType = cardType;
        this.monsterType = monsterType;
        this.level = level;
        this.atk = atk;
        this.def = def;
        this.cost = cost;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardType() {
        return cardType;
    }

    public int getMonsterType() {
        return monsterType;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardID == card.cardID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardID);
    }

    public int getId() {
        return cardID;
    }

    @Override
    public String toString() {
        return String.format("%3d %-32s %2d %5d %5d | %-8s %-13s | %7d",
                cardID, cardName, level, atk, def,
                CardType.toEnum(cardType).getDescription(),
                MonsterType.toEnum(monsterType).getDescription(),
                cost);
    }
}