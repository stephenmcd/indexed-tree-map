package com.dictiography.collections;

import junit.framework.TestCase;

import java.util.*;

/**
 * User: Vitaly Sazanovich
 * Date: 2/10/13
 * Time: 12:14 PM
 */
public class IndexedTreeSetTest  extends TestCase {
    public void testIndexedTreeSet() throws Exception {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            Set<Integer> set = new HashSet<Integer>();
            Random random = new Random(System.currentTimeMillis());
            IndexedNavigableSet<Integer> s = new IndexedTreeSet<Integer>();

            while (set.size() < 1000) {
                Integer next = random.nextInt();
                if (!set.contains(next)) {
                    set.add(next);
                    s.add(next);
                    ((IndexedTreeSet) s).debug();
                }
            }
            Integer[] ints = set.toArray(new Integer[set.size()]);
            Arrays.sort(ints);
            for (int k = 0; k < ints.length; k++) {
                int ev = s.exact(k).intValue();
                int ind = s.entryIndex(ints[k]);

                assertEquals(ints[k].intValue(), ev);
                assertEquals(k, ind);

            }
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                s.remove(next);
                ((IndexedTreeSet) s).debug();
            }
        }
        System.out.println("DONE IN:" + (System.currentTimeMillis() - t1));
    }
}
