import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SecondWindow extends Frame {
	public static final int width = 600;
	public static final int height = 800;
	JTextField tUser, tEmail, friendText;
	JButton backToLoginScreen, post, addFriendButton, addGroupButton;
	JTextArea textPosts, sugFriends, tPost;
	JLabel friendPosts, sugFriendsLabel, makeNewFriend, addGroup;
	private ArrayList<String> postList;
	JCheckBox gr1, gr2;

	SecondWindow(User u, UserManager userManager, Group g1, ClosedGroup g2) {

		postList = new ArrayList<>();
		JFrame f = new JFrame("Σελίδα Χρήστη");

		// New Button
		// make button set position
		backToLoginScreen = new JButton("Back To Login Screen");
		backToLoginScreen.setBounds(360, 2, 160, 30);

		backToLoginScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new FirstWindow(userManager, g1, g2);
			}
		});

		// make text have user name
		tUser = new JTextField(u.getName());
		tUser.setBounds(20, 5, 150, 20);

		// make text have user email
		tEmail = new JTextField(u.getEmail());
		tEmail.setBounds(180, 5, 170, 20);

		// make blank text for posts
		tPost = new JTextArea("");
		tPost.setBounds(100, 160, 300, 200);

		// Post Label
		String host = "";
		textPosts = new JTextArea();
		textPosts.setBounds(244, 370, 300, 200);
		textPosts.append(userManager.toStringPost(host));

		// Post Button
		// set button position
		post = new JButton("Post");
		post.setBounds(415, 300, 100, 30); // right-down-weight-height

		/*
		 * Take Text String Find Time that String made Write that text at the top of
		 * text box with posts Call userManager and save that text so when Window close
		 * and reopen with other or same user text appears in text box(the text is
		 * written on (textPosts.append(userManager.toStringPost(host));) few lines up
		 */
		post.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String host = tPost.getText();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // find local time
					LocalDateTime now = LocalDateTime.now();
					textPosts.getDocument().insertString(0, u.getName() + ", " + dtf.format(now) + ", " + host + "\n",
							null);
					userManager.toStringPost(u.getName() + ", " + dtf.format(now) + ", " + host + "\n");
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// make Label
		friendPosts = new JLabel("Recent Post by Friends");
		friendPosts.setBounds(100, 400, 140, 30);

		// make Suggested Friends Label
		sugFriendsLabel = new JLabel("Suggested Friends");
		sugFriendsLabel.setBounds(240, 590, 140, 30);

		// make Group check boxes
		gr1 = new JCheckBox("WebGurus");
		gr1.setBounds(77, 485, 140, 30);
		gr2 = new JCheckBox("ExamSolutions");
		gr2.setBounds(77, 515, 140, 30);

		// make Suggested Friends Label
		addGroup = new JLabel("Add new group");
		addGroup.setBounds(77, 460, 140, 30);

		// make button set position
		addGroupButton = new JButton("Add Group");
		addGroupButton.setBounds(55, 553, 140, 20);

		addGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (gr1.isSelected()) {
						boolean flag = g1.isMemeberValidToJoin(u);

						if (flag)
							JOptionPane.showMessageDialog(null,
									u.getName() + " has been successfully enrolled in group WebGurus");
						else
							JOptionPane.showMessageDialog(null, "FAILED: " + u.getName()
									+ " cannot be enrolled in WebGurus : user is already in list");

					}
					if (gr2.isSelected()) {
						int flag = g2.isMemeberValidToJoin(u);
						System.out.println("flag : " + flag);
						if (flag == 2)
							JOptionPane.showMessageDialog(null,
									u.getName() + " has been successfully enrolled in group ExamSolutions");
						else if (flag == 1)
							JOptionPane.showMessageDialog(null,
									"FAILED: " + u.getName() + " cannot be enrolled in group ExamSolutions");
						else if (flag == 0)
							JOptionPane.showMessageDialog(null, "FAILED: " + u.getName()
									+ " cannot be enrolled in ExamSolutions : user is already in close group list");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// make Suggested Friends Label
		makeNewFriend = new JLabel("Make new friends");
		makeNewFriend.setBounds(70, 640, 140, 30);

		// make text (enter friend he want to add)
		friendText = new JTextField("");
		friendText.setBounds(55, 675, 140, 30);

		// make button set position
		addFriendButton = new JButton("Add friend");
		addFriendButton.setBounds(55, 713, 140, 20);

		addFriendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String host = friendText.getText();
					boolean flag = true;
					for (User u : userManager.getfriendList(u)) {
						if (u.getName().equals(host)) {
							flag = false;
						}

					}

					if (!flag)
						JOptionPane.showMessageDialog(null, " User " + host + " is already friend ");
					else if (u.getName().equals(host)) {
						JOptionPane.showMessageDialog(null, " You can not be friend with youself ");
						flag = false;
					}

					boolean isNotInList = false;
					for (User k : userManager.getUserList()) {
						if (k.getName().equals(host)) {
							if (flag) {
								u.addAndCheckFriend(k);
								JOptionPane.showMessageDialog(null, " User " + host + " is now friend ");
							}
						} else {
							isNotInList = true;
						}
					}

					if (isNotInList)
						JOptionPane.showMessageDialog(null, " User " + host + " is not in the list ");

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		// Suggest Friend List
		u.suggestFriends();
		sugFriends = new JTextArea(u.toStringSuggestFriend());
		sugFriends.setBounds(370, 580, 70, 50);

		// add buttons to window
		f.add(post);
		f.add(backToLoginScreen);
		f.add(tUser);
		f.add(tEmail);
		f.add(tPost);
		f.add(friendPosts);
		f.add(textPosts);
		f.add(sugFriendsLabel);
		f.add(sugFriends);
		f.add(makeNewFriend);
		f.add(friendText);
		f.add(addFriendButton);
		f.add(addGroup);
		f.add(addGroupButton);
		f.add(gr1);
		f.add(gr2);

		// close window when press X on the top of the window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set window size
		f.setSize(width, height);

		// make button style
		f.setLayout(null);

		// make window visible
		f.setVisible(true);

	}

}
