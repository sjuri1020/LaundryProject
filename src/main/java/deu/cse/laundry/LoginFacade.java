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
// 퍼사드 패턴을 적용한 클래스
public class LoginFacade {
    // realLogin, 실제 로그인 기능을 수행하는 객체
    private LoginCheck check;
    private Message message;
    private Failcount failcount;
    private FrameOpen fopen;
    private NewFrameMain frame;
     // 각 생성자에서 필요한 객체를 초기화
    public LoginFacade(NewFrameMain frame) {
        this.frame = frame;
        this.check = new LoginCheck();
        this.message = new Message();
        this.failcount = new Failcount();
        this.fopen = new FrameOpen(frame);
    }
    
    // login 함수, ID와 비밀번호를 받아 realLogin 객체의 login 함수를 호출, 결과 반환
    // exitstart 함수, 로그아웃 메시지 출력 후 종료
    public void exitstart(){
        JOptionPane.showMessageDialog(null, "시스템을 종료합니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    public void start(String ID, String Password){
        int LoginResult = check.login(ID, Password);
        int failnum = failcount.Fail5(LoginResult);
        message.printMessage(LoginResult, failnum);
        fopen.Open(LoginResult);
    }
}
