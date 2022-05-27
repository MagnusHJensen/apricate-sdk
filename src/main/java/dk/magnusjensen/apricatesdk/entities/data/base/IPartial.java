package dk.magnusjensen.apricatesdk.entities.data.base;

public interface IPartial {
	boolean isPartial();

	void fetchObject() throws Exception;
}
