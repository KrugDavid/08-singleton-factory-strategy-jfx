package ohm.softa.a08.filtering;

import java.util.HashMap;
import java.util.Map;

public abstract class MealsFilterFactory {
	private static Map<String, MealsFilter> filters = new HashMap<>();


	static {
		filters.put("All",new NoFilter());
		filters.put("Vegetarian", new CategoryFilter(true,"vegetarisch","vegan"));
	}

	public static MealsFilter getFilter(String strat)
	{
		return filters.getOrDefault(strat,new NoFilter());
	}
}
