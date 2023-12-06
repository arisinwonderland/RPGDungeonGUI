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
        CharacterStatus status = new CharacterStatus(chr, position);
        allies.add(status);
        
        return allies.get(position);
    }
    
    public CharacterStatus addEnemy(Character chr) {
        int position = enemies.size();
        CharacterStatus status = new CharacterStatus(chr, position * -1);
        enemies.add(status);
        
        return enemies.get(position);
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
