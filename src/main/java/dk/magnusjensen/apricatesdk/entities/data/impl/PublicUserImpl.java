package dk.magnusjensen.apricatesdk.entities.data.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.data.Ledger;
import dk.magnusjensen.apricatesdk.entities.data.PublicUser;

import java.util.List;

public class PublicUserImpl implements PublicUser {
	private String username;
	private String title;
	@JsonDeserialize(as = LedgerImpl.class)
	private Ledger ledger;
	@JsonProperty("arcane_flux") private int arcaneFlux;
	@JsonProperty("distortion_tier") private int distortionTier;
	@JsonProperty("user-since") private int userSince;
	private List<String> achievements;

	public String getUsername() {
		return username;
	}

	public String getTitle() {
		return title;
	}

	public int getArcaneFlux() {
		return arcaneFlux;
	}

	public int getDistortionTier() {
		return distortionTier;
	}

	public Ledger getLedger() {
		return ledger;
	}

	public int getUserSince() {
		return userSince;
	}

	public List<String> getAchievements() {
		return achievements;
	}

	@Override
	public String toString() {
		return "PublicUserImpl{" +
			"username='" + username + '\'' +
			", title='" + title + '\'' +
			", ledger=" + ledger +
			", arcaneFlux=" + arcaneFlux +
			", distortionTier=" + distortionTier +
			", userSince=" + userSince +
			", achievements=" + achievements +
			'}';
	}
}
