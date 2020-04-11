package com.joker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private Integer next;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.next();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.
//        Integer[] integers = {1,2,3,4,5};
//        PeekingIterator iterator = new PeekingIterator(integers);
    }

    public Integer peek() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
