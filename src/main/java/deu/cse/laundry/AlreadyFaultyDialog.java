package deu.cse.laundry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlreadyFaultyDialog extends JDialog {
    public AlreadyFaultyDialog(JFrame parent) {
        super(parent, "경고", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        
        JLabel label = new JLabel("이미 고장 문의가 들어간 세탁기입니다.");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}

