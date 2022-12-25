package io.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean isUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num: arr) {
            if (!set.add(num)) return true;
        }

        return false;
    }
}
