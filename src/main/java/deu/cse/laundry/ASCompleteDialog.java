package deu.cse.laundry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ASCompleteDialog extends JDialog {
    public ASCompleteDialog(JFrame parent) {
        super(parent, "A/S 완료", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        
        JLabel label = new JLabel("A/S가 완료되었습니다.");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}