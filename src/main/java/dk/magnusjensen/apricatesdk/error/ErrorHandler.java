package dk.magnusjensen.apricatesdk.error;

import com.fasterxml.jackson.databind.JsonNode;

public class ErrorHandler {
	public static void handleError(JsonNode node) throws Exception {
		throw new Exception(node.get("message").asText());
	}
}
