import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

    static JFrame frame3 = new JFrame();
    static Color c;
    static JComboBox cb;
    static int xx;
    static int i;

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        String[] options = {"Settings", "Close"};

        int x = JOptionPane.showOptionDialog(null, "Choose option",
                "Option dialog",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (x) {
            case 0:
                createWindow2();
                break;
            case 1:
                System.exit(0);
                break;
            default:
                break;
        }

    }


    private static void createWindow2() {
        JFrame frame = new JFrame();
        frame.setTitle("");
        frame.setResizable(false);
        frame.setSize(900, 300);


        // field ora exacta
        JTextField t1, t2;
        t1 = new JTextField("12:00:00");
        t1.setBounds(150, 50, 200, 30);
        // setare secunde
        t2 = new JTextField("4");
        t2.setBounds(150, 100, 200, 30);
        frame.add(t1);
        frame.add(t2);


        // radio butoane
        JRadioButton r1 = new JRadioButton("on time");
        JRadioButton r2 = new JRadioButton("countdown sec");
        r1.setBounds(0, 50, 120, 30);
        r2.setBounds(0, 100, 120, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.setSelected(r1.getModel(), true);
        frame.add(r1);
        frame.add(r2);

        // text simplu
        JLabel l1;
        l1 = new JLabel("12:00:00");
        l1.setBounds(190, 170, 100, 30);
        frame.add(l1);
        // schimba culoare cu buton la text de sus
        JButton b = new JButton("Choose color");
        b.setBounds(50, 170, 125, 30);
        frame.add(b);

        // culoare random la text care va fi afisata si in forma 2
        final Random r = new Random();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
                l1.setForeground(c);


                // frame3.getContentPane().setBackground(c);
            }
        });


        // seteaza viteza
        JLabel l2;
        l2 = new JLabel("speed");
        l2.setBounds(50, 230, 100, 30);
        frame.add(l2);

        //viteze
        String country[] = {"2", "4", "6", "8"};
        cb = new JComboBox(country);
        cb.setBounds(120, 235, 90, 20);
        frame.add(cb);

        //buton start
        JButton b2 = new JButton("start");
        b2.setBounds(120, 280, 95, 30);
        frame.add(b2);

        //listener pe start
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// check radio button selection
                //disable buttons


                b2.setEnabled(false);
                cb.setEnabled(false);
                l1.setEnabled(false);
                b.setEnabled(false);
                b.setEnabled(false);
                t1.setEnabled(false);
                r1.setEnabled(false);
                r2.setEnabled(false);
                t2.setEnabled(false);

                // afisare label 2 la ora exacta
                if (r1.isSelected()) {
                    // l2.setText("Hello");
                    for (i = 0; i < 300; i++) {
                        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                        int delay2 = 1000;
                        Timer timer2 = new Timer(delay2, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Date date = new Date();
                                String time = timeFormat.format(date);
                                String getFixedTime = t1.getText().toString();
                                if (getFixedTime.contains(time)) {
                                    createWindow3();
                                    i = 300;

                                }
                            }
                        });
                        timer2.setRepeats(true);
                        timer2.start();
                    }

                }// radio button2 by seconds

                else if (r2.isSelected()) {
                    // l2.setText("Welcome");
                    System.out.println(bg.getSelection());
                    int delay = Integer.valueOf(t2.getText().toString()) * 1000;
                    Timer timer = new Timer(delay, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createWindow3();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                }
            }


        });

        //buton de stop
        JButton b3 = new JButton("stop");
        b3.setBounds(220, 280, 95, 30);
        frame.add(b3);
        b3.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
                b2.setEnabled(true);
                cb.setEnabled(true);
                l1.setEnabled(true);
                b.setEnabled(true);
                b.setEnabled(true);
                t1.setEnabled(true);
                r1.setEnabled(true);
                r2.setEnabled(true);
                t2.setEnabled(true);
                // change color
                // frame3.getContentPane().setBackground(c);
            }
        });

        // afisare centru ecran
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.setSize(x, y);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);

    }

    private static void createWindow3() {
        //ecran3
        frame3.setTitle("");
        frame3.setResizable(false);
        frame3.setSize(1000, 300);

        // afisare centru ecran
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        final int[] x = {(screenSize.width - frame3.getWidth()) / 2};
        int y = (screenSize.height - frame3.getHeight()) / 2;
        frame3.setLocation(x[0] + 555, y);
        frame3.setSize(x[0], y);
        frame3.setLayout(null);
        frame3.getContentPane().setBackground(c);
        frame3.setVisible(true);

        xx = 0;
        for (int i = 0; i < 300; i++) {

            int delay3 = 500 * cb.getItemCount();
            Timer timer3 = new Timer(delay3, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (xx == 0) {
                        frame3.getContentPane().setBackground(Color.white);


                        xx = 1;
                    } else {

                        frame3.getContentPane().setBackground(c);
                        xx = 0;
                    }


                }
            });
            timer3.setRepeats(true);
            timer3.start();
        }

    }
}