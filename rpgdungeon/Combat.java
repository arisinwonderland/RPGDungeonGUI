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
public class Combat {
    protected List<CharacterStatus> allies;
    protected List<CharacterStatus> enemies;
    
    public Combat() {
        allies = new ArrayList<>();
        enemies = new ArrayList<>();
    }
    
    public CharacterStatus addAlly(Character chr) {
        int position = allies.size();
        CharacterStatus status = new CharacterStatus(chr);
        allies.add(status);
        
        return allies.get(position);
    }
    
    public CharacterStatus addAlly(String name) {
        Bestiary bestiary = Bestiary.getInstance();
        CharacterStatus status = bestiary.instantiate(name);
        
        if (status != null) {
            int position = allies.size();
            allies.add(status);

            return allies.get(position);
        } else {
            return null;
        }
    }
    
    public CharacterStatus addEnemy(Character chr) {
        int position = enemies.size();
        CharacterStatus status = new CharacterStatus(chr);
        enemies.add(status);
        
        return enemies.get(position);
    }
    
    public CharacterStatus addEnemy(String name) {
        Bestiary bestiary = Bestiary.getInstance();
        CharacterStatus status = bestiary.instantiate(name);
        
        if (status != null) {
            int position = enemies.size();
            enemies.add(status);

            return enemies.get(position);
        } else {
            return null;
        }
    }
    
    public CharacterStatus getAlly(int pos) {
        try {
            return allies.get(pos);
        } catch (IndexOutOfBoundsException exc) {
            return null;
        }
    }
    
    public CharacterStatus getEnemy(int pos) {
        try {
            return enemies.get(pos);
        } catch (IndexOutOfBoundsException exc) {
            return null;
        }
    }
    
    public List<CharacterStatus> getAllies() {
        return new ArrayList<> (allies);
    }
    
    public List<CharacterStatus> getEnemies() {
        return new ArrayList<> (enemies);
    }
}
