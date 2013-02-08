package com.dictiography.collections;

import java.util.Map;
import java.util.NavigableMap;

/**
 * User: Vitaly Sazanovich
 * Date: 07/02/13
 * Time: 19:28
 * Email: Vitaly.Sazanovich@gmail.com
 */
public interface IndexedNavigableMap<K, V> extends NavigableMap<K, V> {
    /**
     * Returns the key located at the index offset from the beginning
     * of the sorted map
     *
     * @param index index of the key
     * @return the key {@code key} located at the index (@code index) offset
     *         from the beginning of the sorted map
     * @throws ArrayIndexOutOfBoundsException if the specified index is less than 0 or greater than size-1
     */
    K exactKey(int index);

    /**
     * Returns a key-value mapping associated with the key located at the index offset from the beginning
     * of the sorted map
     *
     * @param index index of the key
     * @return an entry with the key {@code key} located at the index (@code index) offset
     *         from the
     * @throws ArrayIndexOutOfBoundsException if the specified index is less than 0 or greater than size-1
     */
    Map.Entry<K, V> exactEntry(int index);

}
