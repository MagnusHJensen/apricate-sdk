package dk.magnusjensen.apricatesdk.entities.data.impl;

import dk.magnusjensen.apricatesdk.entities.data.Wares;

import java.util.Map;

public class WaresImpl implements Wares {

	private Map<String, Integer> tools;
	private Map<String, Integer> goods;
	private Map<String, Integer> produce;
	private Map<String, Integer> seeds;

	protected WaresImpl(Map<String, Integer> tools, Map<String, Integer> goods, Map<String, Integer> produce, Map<String, Integer> seeds) {
		this.tools = tools;
		this.goods = goods;
		this.produce = produce;
		this.seeds = seeds;
	}

	@Override
	public String toString() {
		return "WaresImpl{" +
			"tools=" + tools +
			", goods=" + goods +
			", produce=" + produce +
			", seeds=" + seeds +
			'}';
	}
}
