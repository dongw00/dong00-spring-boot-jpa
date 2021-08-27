package com.dongwoo.api.designPatterns;

import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IteratorTest {

    @DisplayName("Iterator pattern")
    @Test
    void main() {
        MyArrayList list = new MyArrayList(new Object[]{1, 3, 5, 67, 8});
        list.forEach(System.out::println);
    }

    class MyArrayList {

        Object[] elements = null;

        MyArrayList(Object[] elements) {
            this.elements = elements;
        }

        void forEach(Consumer<Object> action) {
            for (Object element : elements) {
                action.accept(element);
            }
        }
    }
}
