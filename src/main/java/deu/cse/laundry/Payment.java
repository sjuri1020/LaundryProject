package deu.cse.laundry;
import javax.swing.*;

public class Payment extends javax.swing.JFrame {
    
    private DefaultListModel<String> listModel;
    private Storage st;
    private int totalAmount = 0; // 최종 금액을 저장하는 변수

    public Payment() {
        initComponents();
        setTitle("Payment");
        setLocationRelativeTo(null);
        setResizable(false);
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        jRadioButton1.setSelected(true);
        
        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);
        
        st = new Storage(6);
        st.saveData("1", "4000"); //1번 토글
        st.saveData("2", "4500"); //2번 토글
        st.saveData("3", "3000"); //3번 토글
        st.saveData("4", "3500"); //4번 토글
        st.saveData("5", "5000"); //5번 토글
        st.saveData("6", "5500"); //6번 토글
    }
    
    // 커맨드 패턴(인터페이스)
    public interface PaymentCommand {
        void execute();
    }
    // 현금 결제
    public class CashPaymentCommand implements PaymentCommand {
        private PaymentProcessor processor;
        public CashPaymentCommand(PaymentProcessor processor) {
            this.processor = processor;
        }
        @Override
        public void execute() {
            processor.processCashPayment();
        }
    }
    // 신용카드 결제
    public class CreditCardPaymentCommand implements PaymentCommand {
        private PaymentProcessor processor;
        public CreditCardPaymentCommand(PaymentProcessor processor) {
            this.processor = processor;
        }
        @Override
        public void execute() {
            processor.processCreditCardPayment();
        }
    }

    // Invoker
    public class PaymentInvoker {
        private PaymentCommand cashPaymentCommand;
        private PaymentCommand creditCardPaymentCommand;

        public PaymentInvoker(PaymentProcessor processor) {
            cashPaymentCommand = new CashPaymentCommand(processor);
            creditCardPaymentCommand = new CreditCardPaymentCommand(processor);
        }

        public void processPayment() {
            if (jRadioButton1.isSelected()) {
                cashPaymentCommand.execute();
            } else if (jRadioButton2.isSelected()) {
                creditCardPaymentCommand.execute();
            } else {
                JOptionPane.showMessageDialog(null, "결제 방식을 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    // receiver
    public class PaymentProcessor {
        public void processCashPayment() {
            // 현금 결제 로직
            JOptionPane.showMessageDialog(null, "현금을 투입해 주세요.", "현금 결제", JOptionPane.INFORMATION_MESSAGE);
        }

        public void processCreditCardPayment() {
            // 신용카드 결제 로직
            JOptionPane.showMessageDialog(null, "IC 카드를 방향에 맞게 넣어주세요.", "신용카드 결제", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jToggleButton1.setText("세탁기(대형)");
        jToggleButton1.setPreferredSize(new java.awt.Dimension(110, 110));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("세탁기(특대)");
        jToggleButton2.setPreferredSize(new java.awt.Dimension(110, 110));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jRadioButton1.setText("현금");

        jRadioButton2.setText("신용카드");

        jButton5.setText("결제하기");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("건조기(대형)");
        jToggleButton3.setPreferredSize(new java.awt.Dimension(110, 110));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("건조기(특대)");
        jToggleButton4.setPreferredSize(new java.awt.Dimension(110, 110));
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("헹굼추가");
        jToggleButton5.setMaximumSize(new java.awt.Dimension(110, 110));
        jToggleButton5.setMinimumSize(new java.awt.Dimension(110, 110));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(110, 110));
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setText("향균세탁");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("결제 금액: 0원");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton1.getText());
            updatePrice(jToggleButton1.getText(),"1");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton1.getText());
            updatePrice(jToggleButton1.getText(),"1");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (jToggleButton2.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton2.getText());
            updatePrice(jToggleButton2.getText(),"2");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton2.getText());
            updatePrice(jToggleButton2.getText(),"2");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (jToggleButton3.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton3.getText());
            updatePrice(jToggleButton3.getText(),"3");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton3.getText());
            updatePrice(jToggleButton3.getText(),"3");
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if (jToggleButton4.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton4.getText());
            updatePrice(jToggleButton4.getText(),"4");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton4.getText());
            updatePrice(jToggleButton4.getText(),"4");
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        if (jToggleButton5.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton5.getText());
            updatePrice(jToggleButton5.getText(),"5");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton5.getText());
            updatePrice(jToggleButton5.getText(),"5");
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        if (jToggleButton6.isSelected()) {
            // 버튼이 선택된 상태일 때 JList에 아이템 추가
            listModel.addElement(jToggleButton6.getText());
            updatePrice(jToggleButton6.getText(),"6");
        } else {
            // 버튼이 선택되지 않은 상태일 때 JList에서 아이템 삭제
            listModel.removeElement(jToggleButton6.getText());
            updatePrice(jToggleButton6.getText(),"6");
        }
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        PaymentProcessor processor = new PaymentProcessor();
        PaymentInvoker paymentInvoker = new PaymentInvoker(processor);
        paymentInvoker.processPayment();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // jLabel1의 값을 업데이트하는 메서드
    private void updatePrice(String name, String item) {
        if (listModel.contains(name)) {
            // 버튼이 선택된 상태일 때 가격을 합산
            jLabel1.setText("결제 금액: " + calculateTotal(item, true) + "원");
        } else {
            // 버튼이 선택되지 않은 상태일 때 가격을 차감
            jLabel1.setText("결제 금액: " + calculateTotal(item, false) + "원");
        }
    }
    
    private int calculateTotal(String item, boolean isAdding) {
        String price = st.getData(item);
        if (price != null) {
            int priceInt = Integer.parseInt(price);
            if (isAdding) {
                totalAmount += priceInt;
            } else {
                totalAmount -= priceInt;
            }
        }
        return totalAmount;
    }

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}
