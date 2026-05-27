package deu.cse.laundry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FaultConfirmationDialog extends JDialog {
    public FaultConfirmationDialog(JFrame parent, int washingMachineNumber) {
        super(parent, "고장 확인", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        
        JLabel label = new JLabel("세탁기 " + washingMachineNumber + "에 고장이 있습니다.");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }
}

