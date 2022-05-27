package dk.magnusjensen.apricatesdk.entities.data.impl;

import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dk.magnusjensen.apricatesdk.ApricateSDK;
import dk.magnusjensen.apricatesdk.entities.ArcheType;
import dk.magnusjensen.apricatesdk.entities.data.Warehouse;
import dk.magnusjensen.apricatesdk.entities.data.Wares;
import dk.magnusjensen.apricatesdk.entities.data.base.IIdentifiable;
import dk.magnusjensen.apricatesdk.entities.data.base.IPartial;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public class WarehouseImpl implements Warehouse, IIdentifiable, IPartial {
	private String uuid;
	@JsonProperty("location_symbol") private String locationSymbol;
	private Wares wares;

	public WarehouseImpl(String uuid) {
		this.uuid = uuid;
	}

	private WarehouseImpl(String uuid, String locationSymbol, Wares wares) {
		this.uuid = uuid;
		this.locationSymbol = locationSymbol;
		this.wares = wares;
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
		return 0;
	}

	@Override
	public String getUUID() {
		return null;
	}

	@Override
	public boolean isPartial() {
		return false;
	}

	@Override
	public void fetchObject() throws Exception {

	}

	@Override
	public String toString() {
		return "WarehouseImpl{" +
			"uuid='" + uuid + '\'' +
			", locationSymbol='" + locationSymbol + '\'' +
			", wares=" + wares +
			'}';
	}

	public static class WarehouseImplDeserializer extends JsonDeserializer<WarehouseImpl> {


		@Override
		public WarehouseImpl deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
			JsonNode node = deserializationContext.readTree(jsonParser);
			if (node.isTextual()) {
				// Partial assistant
				return new WarehouseImpl(node.asText());
			} else {
				return new WarehouseImpl(
					node.get("uuid").asText(),
					node.get("location_symbol").asText(),
					new WaresImpl(
						ApricateSDK.getMapper().convertValue(node.get("tools"), Map.class),
						ApricateSDK.getMapper().convertValue(node.get("goods"), Map.class),
						ApricateSDK.getMapper().convertValue(node.get("produce"), Map.class),
						ApricateSDK.getMapper().convertValue(node.get("seeds"), Map.class)
						)
				);
			}
		}
	}
}
