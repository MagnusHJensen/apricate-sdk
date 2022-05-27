package dk.magnusjensen.apricatesdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.module.SimpleModule;
import dk.magnusjensen.apricatesdk.entities.Users;
import dk.magnusjensen.apricatesdk.entities.data.User;
import dk.magnusjensen.apricatesdk.entities.data.base.IIdentifiable;

public class ApricateSDK {
	private static ObjectMapper MAPPER;
	private User user;
	public static String TOKEN;

	private ApricateSDK(User user) {
		this.user = user;
		TOKEN = user.getToken();
	}

	public static User login(String token) throws Exception {
		User user = Users.fetchUser(token);
		new ApricateSDK(user);
		return user;
	}

	public static User createAccount(String username) throws Exception {
		return Users.claimUser(username);
	}

	public static boolean isDebugMode() {
		return false;
	}

	public static ObjectMapper getMapper() {
		if (MAPPER == null) {
			MAPPER = new ObjectMapper();
			MAPPER.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		}
		return MAPPER;
	}
}
