/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.laundry;

import deu.cse.laundry.Administrator;
import deu.cse.laundry.Customer;
import deu.cse.laundry.NewFrameMain;

/**
 *
 * @author hesed
 */
public class FrameOpen {
    private NewFrameMain frame;
    public FrameOpen(NewFrameMain frame) {
        this.frame = frame;
    }
    
    public void Open(int number){
       if(number == 1){
                Administrator adminFrame = new Administrator();
                adminFrame.setVisible(true);
                frame.dispose();
        } else if (number == 2){
          Customer customerFrame = new Customer();
          customerFrame.setVisible(true);
          frame.dispose();
        }
    }
}