package com.proyectoweb.barberia.Users.User.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.LengthNotValid;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.NotSymbolsFound;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.UpperLowerError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserPassword extends StringValueObject {
    public UserPassword(String value) {
        this.validate(value);
        this.value = value;
    }

    public UserPassword(){}

    private void validate(String value) {
        this.UpperLowerRule(value);
        this.LenghtRule(value);
        this.SymbolsRule(value);
    }

    private void UpperLowerRule(String value) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])");
        boolean match = pattern.matcher(value).find();
        if (!match)
        {
            throw new UpperLowerError("The password doesn't have one upper letter and one lower letter at least");
        }
    }

    private void LenghtRule(String value) {
        if (value.length() < 8) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }

    private void SymbolsRule(String value) {
        List<String> symbols = new ArrayList<>(){{ add("*"); add("&"); add("="); add("$");}};
        Optional<String> result = symbols.stream().filter(w -> value.contains(w)).findFirst();
        if (!result.isPresent()) {
            throw new NotSymbolsFound("The password doesn't contains any symbol of these: *&=$");
        }
    }
}
