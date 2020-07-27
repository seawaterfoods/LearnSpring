package com.joe.designpattern.compositepattern;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

//    將我們要遍歷頂層組合的Iterator傳入，我們將其拋入stack結構中。
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

//    想要知道是否有下一個元素，需要先檢查stock是否被清空，若已被清空，就表示沒有下一個元素了。
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }else {
//           否則，我們將從stock的頂層中取出Iterator，看看是否還有下一個元素。
//            如果沒有元素，我們就將它彈出stock，然後遞迴調用hasNext()。
            Iterator iterator =(Iterator)stack.peek();
            if (!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }
    }

//    當user想取得下一個元素時，這裡將調用hasNext() 來確認是否有下一個。
    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
//            如果還有下一個元素，就從stack中取出目前的Iterator，然後取出下一個元素。
            if (component instanceof Menu) {
                stack.push(((Menu) component).createIterator());
            }
//            如果元素是一個Menu，我們有了另一個被包含進遍歷中的組合，所以我們將其丟進stock，不管是否為Menu，我們都返回此組件。
            return component;
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
