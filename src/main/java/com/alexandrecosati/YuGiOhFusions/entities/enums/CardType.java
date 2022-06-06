package com.alexandrecosati.YuGiOhFusions.entities.enums;

public enum CardType {
    MONSTER(1, "Monster"),
    EQUIP(2, "Equip"),
    MAGIC(3, "Magic"),
    FIELD(4, "Field"),
    RITUAL(5, "Ritual"),
    TRAP(6, "Trap");

    private int cod;
    private String description;

    private CardType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return this.cod;
    }

    public String getDescription() {
        return this.description;
    }

    public static CardType toEnum(Integer cod) {
        if (cod == null) return null;

        for (CardType cardType : CardType.values()) {
            if (cod.equals(cardType.getCod()))
                return cardType;
        }

        throw new IllegalArgumentException("Invalid ID: " + cod);
    }
}
