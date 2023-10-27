/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

/**
 *
 * @author Aris Yu
 */
public class Ability {
    protected final String name;
    
    protected final DamageType attackType;
    protected final DamageType defenseType;
    
    protected final double statMultiplier;
    protected final double damageMultiplier;
    
    public enum DamageType {
        PHYSICAL,
        NONPHYSICAL
    }
    
    public static class AbilityBuilder {
        private String name = "Ability";

        private DamageType attackType = Ability.DamageType.PHYSICAL;
        private DamageType defenseType = Ability.DamageType.PHYSICAL;

        private double statMultiplier = 1.0;
        private double damageMultiplier = 1.0;
        
        public Ability build() {
            return new Ability(this);
        }

        public AbilityBuilder setName(String name) {
            this.name = name;
            return this;
        }
        
        public AbilityBuilder setAttackType(DamageType attackType) {
            this.attackType = attackType;
            return this;
        }
        
        public AbilityBuilder setDefenseType(DamageType defenseType) {
            this.defenseType = defenseType;
            return this;
        }
        
        public AbilityBuilder setDamageType(DamageType damageType) {
            this.attackType = damageType;
            this.defenseType = damageType;
            return this;
        }
        
        public AbilityBuilder setStatMultiplier(double statMultiplier) {
            this.statMultiplier = statMultiplier;
            return this;
        }
        
        public AbilityBuilder setDamageMultiplier(double damageMultiplier) {
            this.damageMultiplier = damageMultiplier;
            return this;
        }
    }

    public static AbilityBuilder builder() {
        return new AbilityBuilder();
    }
    
    public static AbilityBuilder builder(String name) {
        return new AbilityBuilder().setName(name);
    }
    
    private Ability(AbilityBuilder builder) {
        name = builder.name;
        attackType = builder.attackType;
        defenseType = builder.defenseType;
        statMultiplier = builder.statMultiplier;
        damageMultiplier = builder.damageMultiplier;
    }

    public String getName() {
        return name;
    }

    public DamageType getAttackType() {
        return attackType;
    }

    public DamageType getDefenseType() {
        return defenseType;
    }

    public double getStatMultiplier() {
        return statMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s, %s, %f, %f", 
            name, attackType, defenseType, statMultiplier, damageMultiplier);
    }
}
