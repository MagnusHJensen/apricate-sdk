package dk.magnusjensen.apricatesdk.entities.data.base;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface IIdentifiable {
	String getUsername();
	String getType();
	int getId();
	String getUUID();
}
