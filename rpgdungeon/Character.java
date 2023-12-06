/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Aris Yu
 */
public class Character {
    protected final String name;
    
    protected final Stats stats;
    protected final List<Ability> abilities;
    
    public Character() {
        this("Character");
    }
    
    public Character(String name) {
        this(name, 50, 50, 50, 50, 50, 50);
    }
    
    public Character(String name, int hp, int pa, int npa, int pd, int npd, int spd) {
        this.name = name;
        
        stats = new Stats(hp, pa, npa, pd, npd, spd);
        abilities = new ArrayList<>();
    }
    
    public Character(Character c) {
        this.name = c.name;
        
        stats = new Stats(c.stats);
        abilities = new ArrayList<>();
        
        for (Ability ab : c.abilities) {
            abilities.add(new Ability(ab));
        }
    }
    
    public Character addAbility(Ability ab) {
        abilities.add(ab);
        return this;
    }

    public String getName() {
        return name;
    }
    public int getHP() {
        return stats.getHP();
    }
    public int getPA() {
        return stats.getPA();
    }
    public int getNPA() {
        return stats.getNPA();
    }
    public int getPD() {
        return stats.getPD();
    }
    public int getNPD() {
        return stats.getNPD();
    }
    public int getSpd() {
        return stats.getSpd();
    }
    
    public int[] getStats() {
        return stats.getStats();
    }
    
    public Ability getAbility(int id) {
        try {
            return new Ability(abilities.get(id));
        } catch (IndexOutOfBoundsException exc) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s \n%s", name, stats);
    }
}
