package dk.magnusjensen.apricatesdk.entities.data.impl;

import dk.magnusjensen.apricatesdk.entities.data.Ledger;

import java.util.Map;

public class LedgerImpl implements Ledger {
	private Map<String, Integer> currencies;
	private Map<String, Integer> favor;
	private Map<String, Integer> escrow;


	/**
	 *
	 * @return A copy of the original map.
	 */
	public Map<String, Integer> getCurrencies() {
		return Map.copyOf(currencies);
	}

	/**
	 *
	 * @return A copy of the original map.
	 */
	public Map<String, Integer> getFavor() {
		return favor;
	}

	/**
	 *
	 * @return A copy of the original map.
	 */
	public Map<String, Integer> getEscrow() {
		return escrow;
	}


	@Override
	public String toString() {
		return "LedgerImpl{" +
			"currencies=" + currencies +
			", favor=" + favor +
			", escrow=" + escrow +
			'}';
	}
}
