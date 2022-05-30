import java.util.ArrayList;
import java.util.List;

public class ClosedGroup {
	private ArrayList<User> closeGroupList;
	private String groupName;
	private String description;

	public ClosedGroup(String groupName, String description) {
		this.groupName = groupName;
		this.description = description;
		closeGroupList = new ArrayList<>();
	}

	public String getgroupName() {
		return this.groupName;
	}

	public String getdescription() {
		return this.description;
	}

	// find if User is in friendList and add him
	public int isMemeberValidToJoin(User user) {
		if (closeGroupList.size() == 0) {
			addCloseGroupMember(user);
			user.addUserGroups(groupName);
			return 2;
		} else {
			if (ckeckCloseFriendMember(user) == 2) {
				addCloseGroupMember(user);
				user.addUserGroups(groupName);
				return 2;
			} else if (ckeckCloseFriendMember(user) == 1){
				System.out.println("FAILED: " + user.getName() + " cannot be enrolled in group " + getgroupName());
				return 1;
			} else  {
				System.out.println("FAILED: " + user.getName() + " cannot be enrolled in group " + getgroupName()+ " user is already in close group list");
				return 0;
			}
		}
	}

	// check if member is in close group
	public int ckeckCloseFriendMember(User user) {
		List<User> friendList = user.getFriendList();

		//if user is already in close group list
		for (User u : closeGroupList) {
			if (u.getName().equals(user.getName())) {
				return 0;
			}
		}
		
		//if user has friend in group list so he can join in
		for (User u : closeGroupList) {
			for (User us : friendList) {
				if (us.getName().equals(u.getName())) {
					return 2;
				}
			}
		}
		
		return 1;//user cannot be enrolled in group
	}

	public String toStringCloseGroupList() {
		String arrayWithGroups = "";
		for (int i = 0; i < closeGroupList.size(); i++)
			arrayWithGroups += (i + 1) + " : " + closeGroupList.get(i).toString() + "\n";
		return arrayWithGroups;
	}

	public String toString(User user) {
		return user.getName();
	}

	// add new member in groupList
	public void addCloseGroupMember(User u) {
		System.out.println(u.getName() + " has been successfully enrolled in group " + getgroupName());
		closeGroupList.add(u);
	}
}
