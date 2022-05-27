package dk.magnusjensen.apricatesdk.entities.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.data.impl.PublicUserImpl;

import java.util.List;

@JsonDeserialize(as = PublicUserImpl.class)
public interface PublicUser {

}
