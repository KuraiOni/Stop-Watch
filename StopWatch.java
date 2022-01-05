import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopWatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton start = new JButton("START");
    // JButton stop = new JButton("STOP");
    JButton reset = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime += 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            String seconds_string = String.format("%02d", seconds);
            String minutes_string = String.format("%02d", minutes);
            String hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }
    });

    StopWatch() {

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        start.setBounds(100, 200, 100, 50);
        start.setFont(new Font("Ink Free", Font.PLAIN, 20));
        start.setFocusable(false);
        start.addActionListener(this);

        reset.setBounds(200, 200, 100, 50);
        reset.setFont(new Font("Ink Free", Font.PLAIN, 20));
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame.add(start);
        frame.add(reset);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start) {
            if (started == false) {
                started = true;
                start.setText("STOP");
                start();
            } else {
                started = false;
                start.setText("START");
                stop();
            }
        }
        if (e.getSource() == reset) {
            started = false;
            start.setText("START");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

}
