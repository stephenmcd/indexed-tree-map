package com.dictiography.collections;

import java.util.NavigableSet;

/**
 * User: Vitaly Sazanovich
 * Date: 08/02/13
 * Time: 09:56
 * Email: Vitaly.Sazanovich@gmail.com
 */
public interface IndexedNavigableSet<E> extends NavigableSet<E> {
    E exact(int index);
}
