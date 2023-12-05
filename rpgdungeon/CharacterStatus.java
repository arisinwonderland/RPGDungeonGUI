/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Aris Yu
 */
public class CharacterStatus {
    public class AbilityNotFoundException extends RuntimeException { 
        public AbilityNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
    
    public static int currentID = 0;
    
    protected final int id;
    protected final int pos;
    
    protected final Character chr;
    protected Stats stats;
    
    protected List<Effect> effects;
    
    public CharacterStatus(Character chr, int pos) {
        id = currentID;
        currentID++;
        this.chr = chr;
        this.pos = pos;
        stats = new Stats(chr.getStats());
        effects = new LinkedList<>();
    }
    
    public void updateStats() {
        // add function here
    }
    
    public int changeHP(int change) {
        int startingHP = stats.getHP();
        int newHP = startingHP + change;
        
        if (newHP > chr.getHP()) {
            newHP = chr.getHP();
        } else if (newHP < 0) {
            newHP = 0;
        }
        
        stats.setHP(newHP);
                
        return newHP - startingHP;
    }
    
    public String useAbility(int id, CharacterStatus target) {
        Ability ab = chr.getAbility(id);
        
        if (ab == null) {
            throw new AbilityNotFoundException("Ability with id" + id + "not found");
        }
        
        double attackStat;
        double defenseStat;
        
        if (ab.getAttackType() == Ability.DamageType.PHYSICAL) {
            attackStat = chr.getPA();
        } else {
            attackStat = chr.getNPA();
        }
        
        attackStat *= ab.getStatMultiplier();
        
        if (ab.getDefenseType() == Ability.DamageType.PHYSICAL) {
            defenseStat = target.getPD();
        } else {
            defenseStat = target.getNPD();
        }
        
        int damage = (int) ((attackStat - defenseStat) * ab.getDamageMultiplier());
        int actualDamage = target.changeHP(damage * -1);
        
        String log = String.format("%s used %s on %s, ", chr.getName(), ab.getName(), target.getName());
        
        if (actualDamage <= 0) {
            log += String.format("dealing %d damage.", actualDamage * -1);
            if (target.getHP() == 0) {
                log += " It's a knockout!";
            }
        } else {
            log += String.format("healing for %d damage.", actualDamage);
        }
        
        return log;
    }
    
    public int getID() {
        return id;
    }
    public String getName() {
        return chr.getName();
    }
    public int getHP() {
        return stats.getHP();
    }
    public int getMaxHP() {
        return chr.getHP();
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
    
    @Override
    public String toString() {
        return String.format("%s\nHP: %d/%d", 
            chr.getName(), stats.getHP(), chr.getHP());
    }
}