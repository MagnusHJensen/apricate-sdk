package dk.magnusjensen.apricatesdk.entities;

public enum ArcheType {
	IMP(0),
	FAMILIAR(1),
	GOLEM(2),
	ONI(3),
	SPRITE(4),
	DRAGON(5),


	/**
	 * Should never be returned if, returned an error happened.
	 */
	UNKNOWN(-1);
	private int id;
	ArcheType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public static ArcheType fromId(int id) {
		for (ArcheType type : values()) {
			if (type.getId() == id) {
				return type;
			}
		}

		return UNKNOWN;
	}
}
