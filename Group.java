import java.util.ArrayList;

public class Group {
	private String groupName;
	private String description;
	private ArrayList<User> groupList;

	public Group(String groupName, String description) {
		this.groupName = groupName;
		this.description = description;
		groupList = new ArrayList<>();
	}

	public String getgroupName() {
		return this.groupName;
	}

	public String getdescription() {
		return this.description;
	}

	// find if User is in friendList and add him
	public boolean isMemeberValidToJoin(User user) {
		if (groupList.size() == 0) {
			user.addUserGroups(groupName);
			addGroupMember(user);
			return true;
		} else {
			if (ckeckGroupMember(user)) {
				addGroupMember(user);
				user.addUserGroups(groupName);
				return true;
			}
		}
		return false;
	}

	// check if member is in group
	public boolean ckeckGroupMember(User user) {
		for (User u : groupList) {
			if (u.getName().equals(user.getName()))
				return false;
		}
		return true;
	}

	public String toStringGroupList() {
		String arrayWithUserGroups = "";
		for (int i = 0; i < groupList.size(); i++)
			arrayWithUserGroups += (i + 1) + " : " + groupList.get(i).toString() + "\n";
		return arrayWithUserGroups;
	}

	public String toString(User user) {
		return user.getName();
	}

	// add new member in groupList
	public void addGroupMember(User u) {
		System.out.println(u.getName() + " has been successfully enrolled in group " + getgroupName());
		groupList.add(u);
	}
}
