package com.noderia.java;

import java.io.Serializable;
import java.util.Objects;

record Person(String fornavn, String etternavn, Integer alder) implements Serializable {
    Person {
        Objects.requireNonNull(fornavn);
        Objects.requireNonNull(etternavn);
        Objects.requireNonNull(alder);
        if (alder <= 0) {
            throw new IllegalArgumentException(String.valueOf(alder));
        }


    }
}
