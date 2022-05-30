import java.util.ArrayList;

public class UserManager {

	// make array list for users
	private ArrayList<User> userList;
	private ArrayList<String> postList;
	String arrayWithFriends = "";

	public UserManager() {
		this.userList = new ArrayList<>();
		this.postList = new ArrayList<>();
	}

	// Find and print User Friend List
	public String toStringPost(String post) {
//		System.out.println(post);
		arrayWithFriends += post;

		return arrayWithFriends;
	}

	// find if user use the same name
	public boolean isUserNameValid(String name) {
		if (userList.size() == 0)
			return true;
		for (User u : userList) {
			if (u.getName().equals(name)) {
				System.out.println("You can not be friend with yourself!");
				return false;
			}
		}
		return true;
	}

	// check email be from pamak Universe
	public boolean universeEmailIsValid(String email) {
		return email.endsWith("@uom.edu.gr");

	}

	// add new user
	public boolean addUserList(User user) {
		if (isUserNameValid(user.getName())) {
			if (universeEmailIsValid(user.getEmail())) {
				userList.add(user);
			} else {
				System.out
						.println("User " + user.getName() + " has not been created. Email format is not acceptable. ");
				return true;
			}

		}
		return false;
	}

	public ArrayList<User> getfriendList(User user) {
		return (ArrayList<User>) user.getFriendList();
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public ArrayList<String> postList() {
		return postList;
	}

}
