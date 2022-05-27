package dk.magnusjensen.apricatesdk.entities.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.data.impl.WarehouseImpl;

@JsonDeserialize(as = WarehouseImpl.class, using = WarehouseImpl.WarehouseImplDeserializer.class)
public interface Warehouse {
}
