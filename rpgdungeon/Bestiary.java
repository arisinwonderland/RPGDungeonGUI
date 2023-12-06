/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

/**
 *
 * @author Aris Yu
 */

import java.util.Map;
import java.util.HashMap;

public class Bestiary {
    public static Bestiary m_instance;
    
    private Map<String, Character> map;
    
    public static Bestiary getInstance() {
        if (m_instance == null)
          m_instance = new Bestiary();
        return m_instance;
    }
    private Bestiary() {
        map = new HashMap<>();
    };
    
    public Character add(Character ch){
        return Character.copy(map.putIfAbsent(ch.getName(), ch));
    }
    
    public Character get(String name) {
        return map.get(name);
    }
    
    public CharacterStatus instantiate(String name) {
        Character chr = map.get(name);
        return new CharacterStatus(chr);
    }
}
