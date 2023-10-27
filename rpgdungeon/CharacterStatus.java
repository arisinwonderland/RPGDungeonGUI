/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

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
    
    protected int currentHP;
    
    public CharacterStatus(Character chr, int pos) {
        id = currentID;
        currentID++;
        this.chr = chr;
        this.pos = pos;
        currentHP = chr.getHP();
    }
    
    public int changeHP(int change) {
        int startingHP = currentHP;
        
        currentHP += change;
        
        if (currentHP > chr.getHP()) {
            currentHP = chr.getHP();
        } else if (currentHP < 0) {
            currentHP = 0;
        }
        
        return currentHP - startingHP;
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
        return currentHP;
    }
    
    public int getMaxHP() {
        return chr.getHP();
    }

    public int getPA() {
        return chr.getPA();
    }

    public int getNPA() {
        return chr.getNPA();
    }

    public int getPD() {
        return chr.getPD();
    }

    public int getNPD() {
        return chr.getNPD();
    }

    public int getSpd() {
        return chr.getSpd();
    }
    
    @Override
    public String toString() {
        return String.format("%s\nHP: %d/%d", 
            chr.getName(), currentHP, chr.getHP());
    }
}