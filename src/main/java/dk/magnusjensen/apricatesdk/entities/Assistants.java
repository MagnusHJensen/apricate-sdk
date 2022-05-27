package dk.magnusjensen.apricatesdk.entities;

import com.fasterxml.jackson.databind.JsonNode;
import dk.magnusjensen.apricatesdk.ApricateSDK;
import dk.magnusjensen.apricatesdk.api.ApiCaller;
import dk.magnusjensen.apricatesdk.entities.data.Assistant;
import dk.magnusjensen.apricatesdk.entities.data.impl.AssistantImpl;

import java.util.List;

public class Assistants {

	public static Assistant fetchAllAssistants(String token) throws Exception {
		JsonNode node = ApiCaller.GET("my/assistants", token);
		return ApricateSDK.getMapper().treeToValue(node.get("data"), Assistant.class);
	}

	public static Assistant fetchAssistant(String token, int id) throws Exception {
		JsonNode node = ApiCaller.GET("my/assistants/{assistant-id}/", token, List.of(String.valueOf(id)));
		return ApricateSDK.getMapper().treeToValue(node.get("data"), Assistant.class);
	}
}
