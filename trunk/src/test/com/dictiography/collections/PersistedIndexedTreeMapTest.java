package com.dictiography.collections;

import junit.framework.TestCase;

import java.util.*;

/**
 * User: Vitaly Sazanovich
 * Date: 07/02/13
 * Time: 15:01
 * Email: Vitaly.Sazanovich@gmail.com
 */
public class PersistedIndexedTreeMapTest extends TestCase {

    public void testMap() throws Exception {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            Set<Integer> set = new HashSet<Integer>();
            Random random = new Random(System.currentTimeMillis());
            IndexedNavigableMap<Integer, Integer> m = new IndexedTreeMap<Integer, Integer>();

            while (set.size() < 1000) {
                Integer next = random.nextInt();
                if (!set.contains(next)) {
                    set.add(next);
                    m.put(next, next);
//                    ((IndexedTreeMap) m).debug();
                }
            }

            Integer[] ints = set.toArray(new Integer[set.size()]);
            Arrays.sort(ints);
            for (int k = 0; k < ints.length; k++) {
                assertEquals(ints[k].intValue(), m.exactKey(k).intValue());

            }

            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                m.remove(next);
//                ((IndexedTreeMap) m).debug();
            }
        }
        System.out.println("DONE IN:" + (System.currentTimeMillis() - t1));
    }


}
