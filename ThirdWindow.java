import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ThirdWindow extends Frame {

	public static final int width = 400;
	public static final int height = 400;
	JTextArea textPosts;
	JButton backToLoginScreen;

	private UserManager userManager;

	ThirdWindow(User u, UserManager userManager, Group g1, ClosedGroup g2) {

		ArrayList<User> visited = new ArrayList<User>();
		this.userManager = userManager;

		JFrame f = new JFrame("Πιθανή Μετάδοση Ιού");

		// Post Label
		int count = 0;
		u.infectedFriend(visited, count);
		visited.remove(0);
		textPosts = new JTextArea("************************************************************************\n" + u + " "
				+ "has been infected. The following users have to be tested\n************************************************************************\n"
				+ u.toStringInfectedFriendList(visited));
		textPosts.setBounds(10, 10, 360, 250);

		// set button position
		backToLoginScreen = new JButton("Back To Login Screen");
		backToLoginScreen.setBounds(110, 280, 160, 30);

		backToLoginScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new FirstWindow(userManager, g1 ,g2);
			}
		});

		f.add(backToLoginScreen);
		f.add(textPosts);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set window size
		f.setSize(width, height);

		// make button style
		f.setLayout(null);

		// make window visible
		f.setVisible(true);
	}

}
