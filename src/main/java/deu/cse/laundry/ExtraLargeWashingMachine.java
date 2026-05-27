package deu.cse.laundry;
import javax.swing.JOptionPane;

public class ExtraLargeWashingMachine implements WashingMachine {
    @Override
    public void wash(int weight) {
        JOptionPane.showMessageDialog(null, "초대형 세탁기(30kg)로 세탁을 시작합니다.\n무게: " + weight + "kg");
    }
}

