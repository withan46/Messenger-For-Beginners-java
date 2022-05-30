import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String email;
	private ArrayList<User> friendList;
	public ArrayList<User> suggestList;
	private ArrayList<User> aSuggestList;
	private ArrayList<String> groupNameList;

	// User Constructor
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		friendList = new ArrayList<>();
		suggestList = new ArrayList<>();
		aSuggestList = new ArrayList<>();
		groupNameList = new ArrayList<>();
	}

	// Suggested Friends
	public void suggestFriends() {
		if (suggestList.isEmpty()) {
			for (User u : friendList) {
				for (User k : u.friendList) {
					addSuggestFriend(k);
				}
			}
		}
	}

	// Find and print User Suggest List
	public String toStringSuggestFriend() {
		String arrayWithSuggestFriends = "";
		if(aSuggestList.isEmpty()) {
			for (int i = 0; i < suggestList.size(); i++) {
				boolean flag = true;
				for (int j = 0; j < friendList.size(); j++) {
					if (suggestList.get(i).toString() == friendList.get(j).toString() // check if name in suggest user is
																						// the same
							|| suggestList.get(i).toString().equals(this.getName())) { // with friend's user or the same
						flag = false;

					}
				}
				if (flag) {
					aAddSuggestFriend(suggestList.get(i));
				}
			}
			// find if users is more than one time in aSuggestionList(and remove them)
			for (int i = 0; i < aSuggestList.size(); i++) {
				for (int j = 0; j < aSuggestList.size(); j++) {
					if (i != j && aSuggestList.get(i).toString().equals(aSuggestList.get(j).toString()))
						aSuggestList.remove(i);
				}
			}
			
		}
		for (User u : aSuggestList)
			arrayWithSuggestFriends += u.toString() + "\n";
		
		return arrayWithSuggestFriends;
	}

	// Find if users are friends
	public boolean isFriendValid(User user) {
		for (User u : friendList) {// find if user want to add friend in list that is already in
			if (u.getName().equals(user.getName())) {
				System.out.println("You are already friends!");
				return false;
			}
		}
		return true;
	}
	
	

	// If the conditions for a friend apply it adds the friend
	public void addAndCheckFriend(User user) {
		if (isFriendValid(user)) {
			if (user.getName().equals(name))// finds if the user is not the same as himself
				System.out.println("You can not be friend with yourself!");
			else {// he is not the same so add him in the friendList
				friendList.add(user);
				System.out.println(this.name + " and " + user.getName() + " are now friends! ");
				user.addFriend(this);
			}
		}
	}

	/*
	 * infected friend. This method works retrospective. It call itself until friend
	 * list of friend lists don't have other users. But I want only friends, friend
	 * list, so I use count. That count how many friends friend lists I want to
	 * cross so It starts from 0 and stop to 1
	 */
	public void infectedFriend(ArrayList<User> visited, int count) {
		if (count < 2) {
			if (visited.size() == 0) {// add first member of visited
				addVisiter(this, visited);
			}
			for (User u : friendList) {
				boolean flag = true;
				for (User k : visited) {
					if (u.getName().equals(k.getName())) {// check if friends is same with visited so they don't have to
															// add
															// them in visited list
						flag = false;
					}
				}
				if (flag) {
					addVisiter(u, visited);
					u.infectedFriend(visited, count + 1);
				}

			}
		}

	}

	// Find and print User Friend List
	public String toStringInfectedFriendList(ArrayList<User> visited) {
		String arrayWithFriends = "";
		for (int i = 0; i < visited.size(); i++)
			arrayWithFriends += visited.get(i).toString() + "\n";

		return arrayWithFriends;
	}

	// Return string with common friends
	public String toStringCommonFriendList(User user) {
		String arrayWithCommonFriends = "";
		for (int i = 0; i < friendList.size(); i++) {
			for (int j = 0; j < user.friendList.size(); j++) {
				if (friendList.get(i).toString() == user.friendList.get(j).toString())// Find if friend's friends is
																						// common with user so add it to
																						// common friend String
					arrayWithCommonFriends += (i + 1) + " : " + friendList.get(i).toString() + "\n";
			}
		}
		return arrayWithCommonFriends;
	}

	// Find and print User Friend List
	public String toStringFriendList() {
		String arrayWithFriends = "";
		for (int i = 0; i < friendList.size(); i++) 
			arrayWithFriends += (i + 1) + " : " + friendList.get(i).toString() + "\n";
			
		return arrayWithFriends;
	}

	// Find and print User Group List
	public String toStringGroupList() {
		String arrayWithFriends = "";
		for (int i = 0; i < groupNameList.size(); i++)
			arrayWithFriends += (i + 1) + " : " + groupNameList.get(i).toString() + "\n";

		return arrayWithFriends;
	}

	// add GroupList name
	public void addUserGroups(String groupName) {
		groupNameList.add(groupName);

	}

	// add new user to list
	public void addFriend(User user) {
		friendList.add(user);
	}

	// add new user to list
	public void addVisiter(User user, ArrayList<User> visited) {
		visited.add(user);
	}

	// add new suggest Friend
	public void addSuggestFriend(User user) {
		suggestList.add(user);
	}

	// add all new suggest Friend
	public void removeSuggestFriend(User user) {
		suggestList.remove(user);
	}

	// add new suggested when it clarifies that they are not the same as themselves
	// or with existing species in new arrayList
	public void aAddSuggestFriend(User user) {
		aSuggestList.add(user);
	}

	// User Name Getter
	public String getName() {
		return this.name;
	}

	// User Email Getter
	public String getEmail() {
		return this.email;
	}

	// get List
	public List<User> getFriendList() {
		return friendList;
	}

	// get Name
	public String toString() {
		return name;
	}

}