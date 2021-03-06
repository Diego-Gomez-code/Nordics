package com.proyectoweb.barberia.Shared.Domain;

import java.util.Objects;

public class DoubleValueObject {

    protected Double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleValueObject that = (DoubleValueObject) o;
        return Objects.equals(value, that.value);
    }

    public Double value() {
        return value;
    }
}
