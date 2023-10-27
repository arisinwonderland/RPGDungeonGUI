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
    
    protected final int hp;
    protected final int pa;
    protected final int npa;
    protected final int pd;
    protected final int npd;
    protected final int spd;
    
    protected final List<Ability> abilities;
    
    public Character() {
        this("Character");
    }
    
    public Character(String name) {
        this(name, 50, 50, 50, 50, 50, 50);
    }
    
    public Character(String name, int hp, int pa, int npa, int pd, int npd, int spd) {
        this.name = name;
        this.hp = hp;
        this.pa = pa;
        this.npa = npa;
        this.pd = pd;
        this.npd = npd;
        this.spd = spd;
        
        abilities = new ArrayList<Ability>();
    }
    
    public Character addAbility(Ability ab) {
        abilities.add(ab);
        return this;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getPA() {
        return pa;
    }

    public int getNPA() {
        return npa;
    }

    public int getPD() {
        return pd;
    }

    public int getNPD() {
        return npd;
    }

    public int getSpd() {
        return spd;
    }
    
    public int[] getStats() {
        int[] stats = {hp, pa, npa, pd, npd, spd};
        return stats;
    }
    
    public Ability getAbility(int id) {
        try {
            return abilities.get(id);
        } catch(IndexOutOfBoundsException exc) {
            exc.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s \nHP: %d\nPA: %d\nNPA: %d\nPD: %d\nNPD: %d\nSPD: %d", 
            name, hp, pa, npa, pd, npd, spd);
    }
}
