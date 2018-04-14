package example.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdleGame {
    private JButton Click;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel Update;
    private JPanel Game;
    private JTextField counter;
    private JButton buyButton;
    private JTextField a10TextField;
    private JTextField a0TextField;
    private JTextField textField1;
    private JButton OKButton;
    private JTextField depositText;
    private JTextField accountBalanceText;
    private JTextField interestRateText;
    private JTextField finalRate;
    private JButton OKButton1;
    private int balance = 0;
    private double accountBalance = 0;
    private boolean time = false;

    private int multiply = 1;


    public IdleGame() {
        Click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                balance += multiply;
                counter.setText(String.valueOf(balance));
                textField1.setText("+"+multiply);

            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = a10TextField.getText();
                Integer i = Integer.parseInt(a);
                String a1 = a0TextField.getText();
                Integer i1 = Integer.parseInt(a1);
                if (balance >= i) {
                    {
                        i1 = i1 + 1;
                        String a11 = String.valueOf(i1);
                        a0TextField.setText(a11);
                        balance = balance - i;
                    }

                    multiply = multiply + 1;

                    i = i * 2;
                    String b = String.valueOf(i);
                    a10TextField.setText(b);
                    counter.setText(String.valueOf(balance));
                    textField1.setText("+"+multiply);

                }

            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer i = Integer.parseInt(depositText.getText());
                if (balance >= i){

                    accountBalance = Integer.parseInt(depositText.getText())+ accountBalance;
                    accountBalanceText.setText(String.valueOf(accountBalance));
                    balance = balance-i;
                    counter.setText(String.valueOf(balance));
                    depositText.setText("");
                }
            }
        });
        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                finalRate.setText(String.valueOf(rate()));

            }
        });
    }

    private double rate() {
        double d = accountBalance;
        Integer i = Integer.parseInt(interestRateText.getText());
        System.out.println(i);
        d = (int)d * ((i/100)+1);// ((Integer.parseInt(interestRateText.getText())/100)+1);
        d= d * 1.02;
        System.out.println(d);
        return d ;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Idle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(new IdleGame().panel1);
        frame.pack();
    }
}
