import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {

		ArrayList<User> visited = new ArrayList<User>();
		UserManager userManager = new UserManager();

//		// make users
//		User u1 = new User("Makis", "iis1998@uom.edu.gr");
//		User u2 = new User("Petros", "ics1924@uom.edu.gr");
//		User u3 = new User("Maria", "iis2012@uom.edu.gr");
//		User u4 = new User("Gianna", "iis19133@uom.edu.gr");
//		User u5 = new User("Nikos", "dai1758@uom.edu.gr");
//		User u6 = new User("Babis", "ics19104@uom.edu.gr");
//		User u7 = new User("Stella", "dai1827@uom.edu.gr");
//		User u8 = new User("Eleni", "ics2086@gmail.com");
//
////		 test users
//		userManager.addUserList(u1);
//		userManager.addUserList(u2);
//		userManager.addUserList(u3);
//		userManager.addUserList(u4);
//		userManager.addUserList(u5);
//		userManager.addUserList(u6);
//		userManager.addUserList(u7);
//		userManager.addUserList(u8);
//
//		u1.addAndCheckFriend(u2);
//		u1.addAndCheckFriend(u5);
//		u5.addAndCheckFriend(u6);
//		u3.addAndCheckFriend(u4);
//		u3.addAndCheckFriend(u2);
//		u4.addAndCheckFriend(u6);
//		u5.addAndCheckFriend(u3);
//		u1.addAndCheckFriend(u6);
//		u5.addAndCheckFriend(u2);
//		u7.addAndCheckFriend(u1);
//
//		// common friends
//		System.out.println("**************************************");
//		System.out.println("Common friends of " + u5 + " and " + u4);
//		System.out.println("**************************************");
//		System.out.println(u5.toStringCommonFriendList(u4));
//		System.out.println("--------------------------------------");
//
//		System.out.println("**************************************");
//		System.out.println("Common friends of " + u1 + " and " + u5);
//		System.out.println("**************************************");
//		System.out.println(u1.toStringCommonFriendList(u5));
//		System.out.println("--------------------------------------");
//
//		// Friend List
//		System.out.println("**************************************");
//		System.out.println("Friends of " + u1);
//		System.out.println("**************************************");
//		System.out.println(u1.toStringFriendList());
//		System.out.println("--------------------------------------");
//		System.out.println("**************************************");
//		System.out.println("Friends of " + u3);
//		System.out.println("**************************************");
//		System.out.println(u3.toStringFriendList());
//		System.out.println("--------------------------------------");

		/*
		 * Make Groups Open Group
		 */
		Group g1 = new Group("WebGurus", "A group for web passionates");
		ClosedGroup g2 = new ClosedGroup("ExamSolutions", "Solutions to common exam questions");

//		g1.isMemeberValidToJoin(u4);
//		g1.isMemeberValidToJoin(u3);
//		g1.isMemeberValidToJoin(u2);
//
//		g2.isMemeberValidToJoin(u4);
//		g2.isMemeberValidToJoin(u4);
//		g2.isMemeberValidToJoin(u4);
//		g2.isMemeberValidToJoin(u4);
//		g2.isMemeberValidToJoin(u5);
//		g2.isMemeberValidToJoin(u6);
//		g2.isMemeberValidToJoin(u5);
//
//		System.out.println("**************************************");
//		System.out.println("Groups that " + u4 + " has been enrolled in");
//		System.out.println("**************************************");
//		System.out.println(u4.toStringGroupList());
//		System.out.println("--------------------------------------");
//
//		System.out.println("**************************************");
//		System.out.println("Members of group " + g1.getgroupName());
//		System.out.println("**************************************");
//		System.out.println(g1.toStringGroupList());
//		System.out.println("--------------------------------------");
//
//		// Close Group
//
//		System.out.println("**************************************");
//		System.out.println("Members of group " + g2.getgroupName());
//		System.out.println("**************************************");
//		System.out.println(g2.toStringCloseGroupList());
//		System.out.println("--------------------------------------");
//
//		// infection
//		int count = 0;
//		u4.infectedFriend(visited, count);
//		visited.remove(0);
//		System.out.println("**************************************");
//		System.out.println(u4 + " has been infected. The following users have to be tested");
//		System.out.println("**************************************");
//		System.out.println(u4.toStringInfectedFriendList(visited));
//		System.out.println("--------------------------------------");

//		u5.suggestFriends();
//		System.out.println(u5+" Suggest Friends: "+u5.toStringSuggestFriend());

		// make window
		new FirstWindow(userManager, g1, g2);

	}

}
