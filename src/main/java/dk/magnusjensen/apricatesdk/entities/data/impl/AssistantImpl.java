package dk.magnusjensen.apricatesdk.entities.data.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import dk.magnusjensen.apricatesdk.ApricateSDK;
import dk.magnusjensen.apricatesdk.entities.ArcheType;
import dk.magnusjensen.apricatesdk.entities.Assistants;
import dk.magnusjensen.apricatesdk.entities.data.Assistant;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public class AssistantImpl implements Assistant {
	private String uuid;
	private boolean partial;
	private int id;
	@JsonProperty("arche_type") private ArcheType archeType;
	private int speed;
	@JsonProperty("carrying_capacity") private int carryingCapacity;
	private Map<Object, Object> improvements; // TODO: This is undocumented as of right now.

	/**
	 * EITHER location symbol OR caravan uuid
	 */
	private String location;

	private AssistantImpl(String uuid) {
		this.uuid = uuid;
		this.partial = true;
	}

	private AssistantImpl(String uuid, int id, ArcheType archeType, int speed, int carryingCapacity, Map<Object, Object> improvements, String location) {
		this.uuid = uuid;
		this.partial = false;
		this.id = id;
		this.archeType = archeType;
		this.speed = speed;
		this.carryingCapacity = carryingCapacity;
		this.improvements = improvements;
		this.location = location;
	}

	@Override
	public boolean isPartial() {
		return this.partial;
	}

	@Override
	public ArcheType getArcheType() throws Exception {
		if (this.isPartial()) {
			this.fetchObject();
		}

		return this.archeType;
	}

	@Override
	public int getCarryingCapacity() throws Exception {
		if (this.isPartial()) {
			this.fetchObject();
		}

		return this.carryingCapacity;
	}

	@Override
	public String getLocation() throws Exception {
		if (this.isPartial()){
			this.fetchObject();
		}

		return this.location;
	}

	@Override
	public Map<Object, Object> getImprovements() throws Exception {
		if (this.isPartial()){
			this.fetchObject();
		}

		return this.improvements;
	}

	@Override
	public int getSpeed() throws Exception {
		if (this.isPartial()){
			this.fetchObject();
		}

		return this.speed;
	}

	@Override
	public void fetchObject() throws Exception {
		Assistant assistant = Assistants.fetchAssistant(ApricateSDK.TOKEN, this.getId());
		this.id = assistant.getId();
		this.archeType = assistant.getArcheType();
		this.speed = assistant.getSpeed();
		this.carryingCapacity = assistant.getCarryingCapacity();
		this.improvements = assistant.getImprovements();
		this.location = assistant.getLocation();
		this.partial = false;
	}

	public void setPartial(boolean partial) {
		this.partial = partial;
	}

	@Override
	public String getUsername() {
		return this.uuid.split(Pattern.quote("|"))[0];
	}

	@Override
	public String getType() {
		return this.uuid.split(Pattern.quote("|"))[1];
	}

	@Override
	public int getId() {
		return Integer.parseInt(this.uuid.split("-")[1]);
	}

	@Override
	public String getUUID() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "AssistantImpl{" +
			"uuid='" + uuid + '\'' +
			", partial=" + partial +
			", id=" + id +
			", archeType=" + archeType +
			", speed=" + speed +
			", carryingCapacity=" + carryingCapacity +
			", improvements=" + improvements +
			", location='" + location + '\'' +
			'}';
	}

	public static class AssistantImplDeserializer extends JsonDeserializer<AssistantImpl> {


		@Override
		public AssistantImpl deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
			JsonNode node = deserializationContext.readTree(jsonParser);
			if (node.isTextual()) {
				// Partial assistant
				return new AssistantImpl(node.asText());
			} else {
				return new AssistantImpl(
					node.get("uuid").asText(),
					node.get("id").asInt(),
					ArcheType.valueOf(node.get("archetype").asText().toUpperCase()),
					node.get("speed").asInt(),
					node.get("carrying_capacity").asInt(),
					ApricateSDK.getMapper().convertValue(node.get("improvements"), Map.class),
					node.get("location").asText()
				);
			}
		}
	}
}
