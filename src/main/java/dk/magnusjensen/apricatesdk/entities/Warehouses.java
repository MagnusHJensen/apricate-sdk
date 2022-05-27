package dk.magnusjensen.apricatesdk.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import dk.magnusjensen.apricatesdk.ApricateSDK;
import dk.magnusjensen.apricatesdk.api.ApiCaller;
import dk.magnusjensen.apricatesdk.entities.data.Assistant;
import dk.magnusjensen.apricatesdk.entities.data.Warehouse;

import java.util.List;

public class Warehouses {
	public static List<Warehouse> fetchAllWarehouses(String token) throws Exception {
		JsonNode node = ApiCaller.GET("my/warehouses", token);
		return ApricateSDK.getMapper().readValue(node.get("data").toString(), new TypeReference<>() {
		});
	}

	public static Warehouse fetchWarehouse(String token, String locationSymbol) throws Exception {
		JsonNode node = ApiCaller.GET("my/warehouses/{warehouse-location-symbol}/", token, List.of(locationSymbol));
		return ApricateSDK.getMapper().treeToValue(node.get("data"), Warehouse.class);
	}
}
