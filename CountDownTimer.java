package drawer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CountDownTimer extends JPanel implements ActionListener {

	private JLabel clockLabel;
	private int timeLeft;
	private Timer timer;

	public CountDownTimer() {
		clockLabel = new JLabel("60");
		clockLabel.setPreferredSize(new Dimension(100, 40));
		clockLabel.setBorder(BorderFactory.createTitledBorder("Time Left"));
		timeLeft = 60;
		timer = new Timer(1000, this);
		timer.start();
		add(clockLabel);

	}

	public void countDown() {
		timeLeft--;
		clockLabel.setText("" + timeLeft);

		if (timeLeft < 1)
			timerStop();

	}

	public void timerStop() {
		timer.stop();
		Toolkit.getDefaultToolkit().beep();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		countDown();
		repaint();
	}
}
