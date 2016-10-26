package com.shulga.algorithms.hashmap;

/**
 * Created by eugene on 6/12/16.
 */
public class TestHash {
    private Integer num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestHash testHash = (TestHash) o;

        return !(num != null ? !num.equals(testHash.num) : testHash.num != null);

    }

    @Override
    public int hashCode() {
        return num != null ? num.hashCode() : 0;
    }
}
