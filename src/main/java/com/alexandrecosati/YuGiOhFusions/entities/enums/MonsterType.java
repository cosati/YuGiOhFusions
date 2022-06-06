package com.alexandrecosati.YuGiOhFusions.entities.enums;

public enum MonsterType {
    DRAGON(1, "Dragon"),
    SPELLCASTER(2, "Spellcaster"),
    BEASTWARRIOR(3, "Beast-Warrior"),
    FIEND(4, "Fiend"),
    PLANT(5, "Plant"),
    ZOMBIE(6, "Zombie"),
    DINOSAUR(7, "Dinossaur"),
    WARRIOR(8, "Warrior"),
    WINGEDBEAST(9, "Winged Beast"),
    BEAST(10, "Beast"),
    ROCK(11, "Rock"),
    PYRO(12, "Pyro"),
    THUNDER(13, "Thunder"),
    INSECT(14, "Insect"),
    REPTILE(15, "Reptile"),
    FISH(16, "Fish"),
    AQUA(17, "Aqua"),
    SEASERPENT(18, "Sea Serpent"),
    FAIRY(19, "Fairy"),
    MACHINE(20, "Machine"),
    OTHER(21, "");

    private int cod;
    private String description;

    private MonsterType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return this.cod;
    }

    public String getDescription() {
        return this.description;
    }

    public static MonsterType toEnum(Integer cod) {
        if (cod == null) return null;

        for (MonsterType cardType : MonsterType.values()) {
            if (cod.equals(cardType.getCod()))
                return cardType;
        }

        throw new IllegalArgumentException("Invalid ID: " + cod);
    }
}
