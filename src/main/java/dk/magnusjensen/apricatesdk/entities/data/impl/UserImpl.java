package dk.magnusjensen.apricatesdk.entities.data.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dk.magnusjensen.apricatesdk.entities.data.Assistant;
import dk.magnusjensen.apricatesdk.entities.data.Ledger;
import dk.magnusjensen.apricatesdk.entities.data.User;

import java.util.List;

public class UserImpl implements User {
	private String token;
	private String username;
	private String title;
	@JsonDeserialize(as = LedgerImpl.class)
	private Ledger ledger;
	@JsonProperty("arcane_flux") private int arcaneFlux;
	@JsonProperty("distortion_tier") private int distortionTier;
	@JsonProperty("user-since") private int userSince;
	private List<String> achievements;
	private List<String> contracts;
	private List<Assistant> assistants;
	private List<String> caravans;
	private List<String> farms;
	private List<String> plots;
	private List<String> warehouses;
	@JsonProperty("lattice_interference_rejection_end") private int latticeInterferenceRejectionEnd;

	public String getToken() {
		return token;
	}

	@Override
	public List<Assistant> getAssistants() {
		return this.assistants;
	}


	@Override
	public String toString() {
		return "UserImpl{" +
			"token='" + token + '\'' +
			", username='" + username + '\'' +
			", title='" + title + '\'' +
			", ledger=" + ledger +
			", arcaneFlux=" + arcaneFlux +
			", distortionTier=" + distortionTier +
			", userSince=" + userSince +
			", achievements=" + achievements +
			", contracts=" + contracts +
			", assistants=" + assistants +
			", caravans=" + caravans +
			", farms=" + farms +
			", plots=" + plots +
			", warehouses=" + warehouses +
			", latticeInterferenceRejectionEnd=" + latticeInterferenceRejectionEnd +
			'}';
	}
}
