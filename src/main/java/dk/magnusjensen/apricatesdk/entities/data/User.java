package dk.magnusjensen.apricatesdk.entities.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.data.impl.UserImpl;

import java.util.List;

@JsonDeserialize(as = UserImpl.class)
public interface User {

	String getToken();

	List<Assistant> getAssistants();
}
