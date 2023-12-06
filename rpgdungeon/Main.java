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
                
                Character ch1 = new Character("Nio Tamanegi", 80, 90, 70, 50, 30, 90);
                Ability ab1 = Ability.builder("Final Blow")
                    .setDamageType(Ability.DamageType.PHYSICAL)
                    .setStatMultiplier(1.5)
                    .build();
                Character ch2 = new Character("Zoie Kaji", 40, 90, 60, 33, 28, 95);
                Ability ab2 = Ability.builder("Psychic Fire")
                    .setDamageType(Ability.DamageType.NONPHYSICAL)
                    .build();
                
                ch1.addAbility(ab1);
                ch2.addAbility(ab2);
                
                CharacterStatus status1 = combat.addAlly(ch1);
                CharacterStatus status2 = combat.addEnemy(ch2);
                
                mainWindow.updateView();
            }
        });
    }
    
}
