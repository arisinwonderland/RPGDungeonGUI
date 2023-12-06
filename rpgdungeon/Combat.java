/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

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
        return new ArrayList<>(allies);
    }
    
    public List<CharacterStatus> getEnemies() {
        return new ArrayList<>(enemies);
    }
    
    public List<String> getAllyList() {
        List<String> allyNames = new ArrayList<>();
        List<String> allyList = new ArrayList<>();
        
        Map<String, Integer> allyCount = new HashMap<>();
        Set<String> duplicates = new HashSet<>();
        
        for (CharacterStatus ally : allies) {
            allyNames.add(ally.getName());
            Object countObj = allyCount.putIfAbsent(ally.getName(), 1);
            
            if (countObj != null) {
                duplicates.add(ally.getName());
            }
        }
        
        for (String name : allyNames) {
            if (duplicates.contains(name)) {
                allyList.add(name + " #" + allyCount.get(name));
                allyCount.put(name, allyCount.get(name) + 1);
            } else {
                allyList.add(name);
            }
        }
        
        return allyList;
    }
    
    public List<String> getEnemyList() {
        List<String> enemyNames = new ArrayList<>();
        List<String> enemyList = new ArrayList<>();
        
        Map<String, Integer> enemyCount = new HashMap<>();
        Set<String> duplicates = new HashSet<>();
        
        for (CharacterStatus enemy : enemies) {
            enemyNames.add(enemy.getName());
            Object countObj = enemyCount.putIfAbsent(enemy.getName(), 1);
            
            if (countObj != null) {
                duplicates.add(enemy.getName());
            }
        }
        
        for (String name : enemyNames) {
            if (duplicates.contains(name)) {
                enemyList.add(name + " #" + enemyCount.get(name));
                enemyCount.put(name, enemyCount.get(name) + 1);
            } else {
                enemyList.add(name);
            }
        }
        
        return enemyList;
    }
    
    public int getAllyCount() {
        return allies.size();
    }
    
    public int getEnemyCount() {
        return allies.size();
    }
}
