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
    //실제 로그인이 진행되는 함수
public class LoginCheck{
    private String UserID = "user";
    private String UserPassword = "password";
    private String AdminiStratorID = "admin";
    private String AdminiStratorPassword = "admin";
    
    
    public int login(String ID, String Password) {
        if (ID.equals(AdminiStratorID) && Password.equals(AdminiStratorPassword)) {
           //관리자 로그인 성공
            return 1;
        } else if (ID.equals(UserID) && Password.equals(UserPassword)) {
            //일반 사용자 로그인 성공
            return 2;
        } else {
            //로그인 실패
            return 3;
        }
    }
}
