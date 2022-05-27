package dk.magnusjensen.apricatesdk.entities.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.ArcheType;
import dk.magnusjensen.apricatesdk.entities.data.base.IPartial;
import dk.magnusjensen.apricatesdk.entities.data.base.IIdentifiable;
import dk.magnusjensen.apricatesdk.entities.data.impl.AssistantImpl;

import java.util.Map;

@JsonDeserialize(as = AssistantImpl.class, using = AssistantImpl.AssistantImplDeserializer.class)
public interface Assistant extends IPartial, IIdentifiable {

	ArcheType getArcheType() throws Exception;

	int getCarryingCapacity() throws Exception;

	String getLocation() throws Exception;

	Map<Object, Object> getImprovements() throws Exception;

	int getSpeed() throws Exception;
}
