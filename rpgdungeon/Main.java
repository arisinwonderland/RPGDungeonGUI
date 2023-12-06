/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arisinwonderland.rpgdungeon;

/**
 *
 * @author Aris Yu
 */
public class Main {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                Combat combat = new Combat();
                
                mainWindow.setVisible(true);
                mainWindow.setCurrentCombat(combat);
                
                Bestiary bestiary = Bestiary.getInstance();
                
                Character ch1 = new Character("Nio Tamanegi", 80, 90, 70, 50, 30, 90);
                Character ch2 = new Character("Zoie Kaji", 40, 90, 60, 33, 28, 95);
                Character ch3 = new Character("Yggmar Ulcros", 69, 69, 69, 45, 45, 92);
                
                Ability ab = Ability.builder("Final Blow")
                    .setDamageType(Ability.DamageType.PHYSICAL)
                    .setStatMultiplier(1.5)
                    .build();
                
                ch1.addAbility(ab);
                
                ab = Ability.builder("Brave Sword Slash")
                    .setDamageType(Ability.DamageType.PHYSICAL)
                    .setDamageMultiplier(0.75)
                    .build();
                
                ch1.addAbility(ab);
                
                ab = Ability.builder("Psychic Fire")
                    .setDamageType(Ability.DamageType.NONPHYSICAL)
                    .build();
                
                ch2.addAbility(ab);
                
                ab = Ability.builder("Pitch Hitter")
                    .setDamageType(Ability.DamageType.PHYSICAL)
                    .setDamageMultiplier(1.25)
                    .build();
                
                ch2.addAbility(ab);
                
                ab = Ability.builder("Bold Move")
                    .setDamageType(Ability.DamageType.PHYSICAL)
                    .build();
                
                ch3.addAbility(ab);
                
                bestiary.add(ch1);
                bestiary.add(ch2);
                bestiary.add(ch3);
                
                CharacterStatus status1 = combat.addAlly("Nio Tamanegi");
                CharacterStatus status2 = combat.addEnemy("Zoie Kaji");
                
                mainWindow.updateView();
            }
        });
    }
    
}
