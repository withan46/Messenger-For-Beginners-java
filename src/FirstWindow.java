import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FirstWindow extends Frame {

	public static final int width = 400;
	public static final int height = 400;
	JTextField tx, tn, te;
	JButton userPage, infections, newUser, saveButton;
	private ArrayList<String> postList;

	private UserManager userManager;
	private Group group;
	private ClosedGroup closedGroup;

	FirstWindow(UserManager userManager, Group g1, ClosedGroup g2) {

		postList = new ArrayList<>();
		this.userManager = userManager;
		this.group = g1;
		this.closedGroup = g2;

		JFrame f = new JFrame("Είσοδος Χρήστη");
		// New Button
		// make button set position
		userPage = new JButton("Enter User Page");
		userPage.setBounds(40, 70, 130, 30);

		// make button set position
		newUser = new JButton("New User");
		newUser.setBounds(80, 35, 90, 30);

		// make button set position
		saveButton = new JButton("Save PamakBook");
		saveButton.setBounds(110, 110, 160, 30);

		// make text enter user
		tn = new JTextField("user name");
		tn.setBounds(185, 40, 70, 20);

		tn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tn.setText("");
			}
		});

		// make text enter email
		te = new JTextField("user email");
		te.setBounds(265, 40, 70, 20);

		te.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				te.setText("");
			}
		});

		userPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String host = tn.getText();
					boolean flag = true;
					for (User u : userManager.getUserList()) {
						if (u.getName().equals(host)) {
							flag = false;
							f.dispose();
							new SecondWindow(u, userManager, g1, g2);
						}
					}
					if (flag) {
						JOptionPane.showMessageDialog(null, " User " + host + " Not Found ");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tn.getText();
					String email = te.getText();
					boolean flag = false;
					for (User u : userManager.getUserList()) {
						if (u.getName().equals(name)) {
							flag = true;
						}
					}
					if (flag) {
						JOptionPane.showMessageDialog(null, " User " + name + " already exist ");
					} else {
						User u1 = new User(name, email);
						userMaker(u1);
//						User u = new user(host,email );
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// Infection Button
		// set button position
		infections = new JButton("Show Potential Infections");
		infections.setBounds(185, 70, 180, 30); // right-down-weight-height

		infections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String host = tn.getText();
					boolean flag = true;
					for (User u : userManager.getUserList()) {
						if (u.getName().equals(host)) {
							flag = false;
							f.dispose();
							new ThirdWindow(u, userManager, g1, g2);
						}
					}
					if (flag) {
						JOptionPane.showMessageDialog(null, " User " + host + " Not Found ");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// add buttons to window
		f.add(infections);
		f.add(userPage);
		f.add(tn);
		f.add(te);
		f.add(newUser);
		f.add(saveButton);

		// close window from x button (top right of window)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set window size
		f.setSize(width, height);

		// make button style
		f.setLayout(null);

		// make window visible
		f.setVisible(true);
	}

	public void userMaker(User u) {
		boolean flag = userManager.addUserList(u);
		if (flag) {
			JOptionPane.showMessageDialog(null,
					"User " + u.getName() + " has not been created. Email format is not acceptable. ");
		}else {
			JOptionPane.showMessageDialog(null,
					"User " + u.getName() + " successfully created ");
		}
	}
}
