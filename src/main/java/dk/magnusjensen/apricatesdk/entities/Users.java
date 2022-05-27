package dk.magnusjensen.apricatesdk.entities;

import com.fasterxml.jackson.databind.JsonNode;
import dk.magnusjensen.apricatesdk.ApricateSDK;
import dk.magnusjensen.apricatesdk.api.ApiCaller;
import dk.magnusjensen.apricatesdk.entities.data.PublicUser;
import dk.magnusjensen.apricatesdk.entities.data.User;
import dk.magnusjensen.apricatesdk.entities.data.impl.PublicUserImpl;
import dk.magnusjensen.apricatesdk.entities.data.impl.UserImpl;

import java.util.List;

public class Users {
	public static User claimUser(String username) throws Exception {
		JsonNode node = ApiCaller.POST("users/{username}/claim", null, List.of(username), null);
		System.out.println(node);
		return ApricateSDK.getMapper().treeToValue(node.get("data"), User.class);
	}

	public static User fetchUser(String token) throws Exception {
		JsonNode node = ApiCaller.GET("my/user", token);
		return ApricateSDK.getMapper().treeToValue(node.get("data"), User.class);
	}

	public static PublicUser fetchPublicUser(String username) throws Exception {
		JsonNode node = ApiCaller.GET("users/{username}/", null, List.of(username));
		return ApricateSDK.getMapper().treeToValue(node.get("data"), PublicUser.class);
	}
}
