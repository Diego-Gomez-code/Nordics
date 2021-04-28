package com.proyectoweb.barberia.Users.User.Domain;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;

public class UserFirstName extends StringValueObject {

    public UserFirstName(String value){
        this.validate(value);
        this.value = value;
    }

    private void validate(String value){
        this.lengthRule(value);
    }

    private void lengthRule(String value){
        if(value.length() < 3){
            throw new LengthNotValid("Number of characters invalid.");
        }
    }
}
