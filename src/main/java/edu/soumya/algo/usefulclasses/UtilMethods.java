package edu.soumya.algo.usefulclasses;

import java.util.HashMap;

public class UtilMethods {
	public static void incrMapKeyByValue(HashMap<Number, Number> map, Number key, Number increaseVal, Number initVal ) {
		if(!map.containsKey(key)) {
			map.put(key, initVal);
		}
		Number value = map.get(key);
		value = (increaseVal instanceof Long) ? (value.longValue() + increaseVal.longValue()) 
				: (increaseVal instanceof Integer) ? (value.intValue() + increaseVal.intValue())
				: (increaseVal instanceof Float) ? (value.floatValue() + increaseVal.floatValue())
				: (increaseVal instanceof Double) ? (value.doubleValue() + increaseVal.doubleValue())
				: value;
		map.put(key, value);
	}
}
