package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.util.HashMap;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.DuplicatedKeyException;

public class SingleKeyHashMap<K, V> extends HashMap<K, V> {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 100L;

	@Override
     public V put(K key, V value) {
         if (containsKey(key)) {
             throw new DuplicatedKeyException("duplicated key " + key);
         }
         return super.put(key, value);
     }
}
