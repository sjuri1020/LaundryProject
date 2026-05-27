/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.laundry;
import javax.swing.JOptionPane;

/**
 *
 * @author hesed
 */
public class Failcount {
        private int failcount = 0;

        public int Fail5(int number) {
        if(number != 3){
            return failcount;
        }
        failcount++;
        return failcount;
    }
}

