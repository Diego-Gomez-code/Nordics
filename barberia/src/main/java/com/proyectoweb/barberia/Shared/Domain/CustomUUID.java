package com.proyectoweb.barberia.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID implements Serializable {

    private String value;
    
    public CustomUUID(String value){
        this.value = value;
    }

    public CustomUUID() {

    }

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    public String value() {
        return value;
    }

    private void validateUUIDFormatRule(String value)
    {
        try {
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new UUIDNotValid("The UUID has not valid format");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }
}
