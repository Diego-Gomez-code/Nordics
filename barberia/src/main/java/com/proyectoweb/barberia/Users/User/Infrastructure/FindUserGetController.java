package com.proyectoweb.barberia.Users.User.Infrastructure;

import com.proyectoweb.barberia.Shared.Domain.UUIDNotValid;
import com.proyectoweb.barberia.Users.User.Application.Find.UserFinder;
import com.proyectoweb.barberia.Users.User.Application.Find.UserFinderResponse;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class FindUserGetController {

    @Autowired
    private UserFinder finder;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id){
        UserFinderResponse response = new UserFinderResponse(finder.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<HashMap> handleUserNotExist(UserNotExist exception)
    {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UUIDNotValid.class)
    public ResponseEntity<HashMap> handleUUIDNotValid(UUIDNotValid exception)
    {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
