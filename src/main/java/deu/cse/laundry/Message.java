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
public class Message {
    
    public void printMessage(int number, int failcount) {
        switch (number) {
            case 1:
                JOptionPane.showMessageDialog(null, "관리자님, 오신 것을 환영합니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "세탁방에 오신 것을 환영합니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                if(failcount < 5){
                JOptionPane.showMessageDialog(null, failcount + "번 틀렸습니다. 5번 이상 틀릴시 강제 종료됩니다.", "경고", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "5번 틀렸기에. 시스템을 종료합니다.", "경고", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                break;
            default:
                break;
        }
    }
}

