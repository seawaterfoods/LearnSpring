package com.joe.designpattern.adapterpattern.iterenum;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
    Enumeration anEnum;

    public EnumerationIterator(Enumeration anEnum) {
        this.anEnum = anEnum;
    }

    @Override
    public boolean hasNext() {
        return anEnum.hasMoreElements();
    }

    @Override
    public Object next() {
        return anEnum.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
