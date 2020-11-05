package com.opstty.comparator;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class HeightComparator extends WritableComparator {

    public HeightComparator() {
        super(HeightKey.class, true);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2) {

        HeightKey key1 = (HeightKey) wc1;
        HeightKey key2 = (HeightKey) wc2;

        int heightCmp = Float.compare(key1.height, key2.height);
        if (heightCmp != 0) {
            return heightCmp;
        } else {
            return key1.geo.toLowerCase().compareTo(key2.geo.toLowerCase());
        }
    }
}

