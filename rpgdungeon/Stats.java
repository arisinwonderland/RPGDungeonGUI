/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

/**
 *
 * @author Aris Yu
 */
public class Stats {
    protected int hp;
    protected int pa;
    protected int npa;
    protected int pd;
    protected int npd;
    protected int spd;
    
    public Stats() {
        this(0, 0, 0, 0, 0, 0);
    }
    
    public Stats(Stats s) {
        this(s.getStats());
    }
    
    public Stats(int[] s) {
        this(s[0], s[1], s[2], s[3], s[4], s[5]);
    }
    
    public Stats(int hp, int pa, int npa, int pd, int npd, int spd) {
        this.hp = hp;
        this.pa = pa;
        this.npa = npa;
        this.pd = pd;
        this.npd = npd;
        this.spd = spd;
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

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setPA(int pa) {
        this.pa = pa;
    }

    public void setNPA(int npa) {
        this.npa = npa;
    }

    public void setPD(int pd) {
        this.pd = pd;
    }

    public void setNPD(int npd) {
        this.npd = npd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }
    
    @Override
    public String toString() {
        return String.format("HP: %d\nPA: %d\nNPA: %d\nPD: %d\nNPD: %d\nSPD: %d", 
            hp, pa, npa, pd, npd, spd);
    }
}
