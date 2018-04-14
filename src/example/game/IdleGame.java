package example.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class IdleGame {
    private JButton Click;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel Update;
    private JPanel Game;
    private JTextField counter;
    private JButton buyButton;
    private JTextField clickUpdatePrize;
    private JTextField clickUpdate;
    private JTextField textField1;
    private JButton OKButton;
    private JTextField depositText;
    private JTextField accountBalanceText;
    private JTextField interestRateText;
    private JTextField finalRate;
    private JButton OKButton1;
    private JTextField idleUpdate;
    private JTextField idleUpdatePrize;
    private JButton Buy;
    private JTextField idleCount;
    private JButton allButton;
    private JButton STOPButton;
    private JRadioButton idleONRadioButton;
    private int balance = 0;
    private double accountBalance = 0;


    private int multiplyClick = 1;
    private int multiplyIdle = 0;
    private int rateCount = 0;
    boolean stop = false;


    public IdleGame() {

        Click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                balance += multiplyClick;
                counter.setText(String.valueOf(balance));
                textField1.setText("+" + multiplyClick);

            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = clickUpdatePrize.getText();
                Integer i = Integer.parseInt(a);
                String a1 = clickUpdate.getText();
                Integer i1 = Integer.parseInt(a1);
                if (balance >= i) {
                    {
                        i1 = i1 + 1;
                        String a11 = String.valueOf(i1);
                        clickUpdate.setText(a11);
                        balance = balance - i;
                    }

                    multiplyClick = multiplyClick + 1;

                    i = i * 2;
                    String b = String.valueOf(i);
                    clickUpdatePrize.setText(b);
                    counter.setText(String.valueOf(balance));
                    textField1.setText("+" + multiplyClick);

                }

            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer i = Integer.parseInt(depositText.getText());
                if (balance >= i) {

                    accountBalance = Integer.parseInt(depositText.getText()) + accountBalance;
                    accountBalanceText.setText(String.valueOf(accountBalance));
                    balance = balance - i;
                    counter.setText(String.valueOf(balance));
                    depositText.setText("");
                }
            }
        });
        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rateCount != 1 && Double.parseDouble(accountBalanceText.getText()) >= 0) {
                        rate();
                        int i =Integer.parseInt(accountBalanceText.getText());
                        i -= i;
                        accountBalanceText.setText(String.valueOf(i));
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, you added balance before...");
                    }
                } catch (Exception e1) {

                }
            }
        });
        Buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(idleUpdatePrize.getText());
                int idle = Integer.parseInt(idleUpdate.getText());
                if (balance >= i) {
                    idle = idle + 1;
                    String s = String.valueOf(idle);
                    idleUpdate.setText(s);

                    balance = balance - i;
                    counter.setText(String.valueOf(balance));
                    i = i * 2;
                    String s1 = String.valueOf(i);
                    idleUpdatePrize.setText(s1);

                    multiplyIdle = multiplyIdle + 1;
                    idleCount.setText(String.valueOf("+" + multiplyIdle + "/s"));

                }
            }
        });
        STOPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopNow();


            }
        });
        allButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double i = Double.parseDouble(accountBalanceText.getText());
                double fin = Double.parseDouble(finalRate.getText());

                finalRate.setText("");
                i = i + fin;

                accountBalanceText.setText(String.valueOf(i));
                rateCount = 0;
                stop = false;
            }
        });
    }

    {

        idleMachine();

    }

    public boolean stopNow() {
        return stop = true;
    }

    public void idleMachine() {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                balance += multiplyIdle;

                counter.setText(String.valueOf(balance));

            }
        }, 0, 1000);


    }

    private double rate() {
        rateCount++;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            double copyAcc = accountBalance;


            @Override
            public void run() {
                if (stop == false) {
                    double rate = Double.parseDouble(interestRateText.getText());
                    rate = (rate / 100.0) + 1;

                    double result = copyAcc * rate;
                    copyAcc = result;
                    finalRate.setText(String.valueOf(copyAcc));

                }
            }
        }, 0, 1000);

        return Double.parseDouble(finalRate.getText());

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Idle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(new IdleGame().panel1);
        frame.pack();

    }
}
