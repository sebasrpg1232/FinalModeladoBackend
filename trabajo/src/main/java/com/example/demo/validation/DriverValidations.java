package com.example.demo.validation;

import com.example.demo.domain.driver.route;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class DriverValidations {
    public static void ValidateDriver(
            String unSafeName,
            LocalDateTime unSafeBirthdate,
            int unSafeAge,
            String unSafeEmail,
            int unSafeNumber,
            route unSafeDriversRoute
    ){
        Objects.requireNonNull(unSafeAge, "La edad no debe ser null");
        Objects.requireNonNull(unSafeName, "La edad no debe ser null");
        Objects.requireNonNull(unSafeBirthdate, "La edad no debe ser null");
        Objects.requireNonNull(unSafeEmail, "La edad no debe ser null");
        Objects.requireNonNull(unSafeNumber, "La edad no debe ser null");
        Objects.requireNonNull(unSafeDriversRoute, "La edad no debe ser null");
    }
    public static void ValidateName(String unSafeValue){
        Objects.requireNonNull(unSafeValue, "El nombre no debe ser nulo");
        Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s:]{10,64}$");
        unSafeValue.trim();

        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(unSafeValue.length() > 100){
            throw new IllegalArgumentException("El nombre no puede ser superior a 100 caracteres");
        }
        boolean valid = pattern.matcher(unSafeValue).matches();
        if(!valid){
            throw new IllegalArgumentException("El nombre no puede tener caracteres especiales");
        }
    }

    public static void ValidateBirthdate(LocalDateTime unSafeValue){
        Objects.requireNonNull("La fecha de nacimiento no debe ser nula");

    }


}
