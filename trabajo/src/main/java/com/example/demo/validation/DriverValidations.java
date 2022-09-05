package com.example.demo.validation;

import com.example.demo.domain.driver.Route;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

public class DriverValidations {
    public static void ValidateDriver(
            String unSafeName,
            String unSafeBirthdate,
            String unSafeAge,
            String unSafeEmail,
            String unSafeNumber,
            Route unSafeDriversRoute
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
    //.before(anotherDate); .after(AntoherDate); para comparar dos fechas
    //Posibilidades usar el age para generar la fecha, opcion 1
    //Sacar la fecha y calcularla con el age, opcion 2 ademas de ver la fecha actual y calcularla en base a eso
    public static void ValidateBirthdate(String unSafeValue){
        LocalDateTime unSafeDate;
        try{

        unSafeDate = LocalDateTime.parse(unSafeValue);
        }
        catch (Exception e){
            throw new IllegalArgumentException("La fecha ingresada no es valida");
        }
        Objects.requireNonNull("La fecha de nacimiento no debe ser nula");

    }

    public static void ValidateAge(String unSafeValue){
        int unSaveAge;
        try{

            unSaveAge = Integer.parseInt(unSafeValue);
        }
        catch (Exception e){
            throw new IllegalArgumentException("El valor ingresado no es un entero");
        }

        Objects.requireNonNull(unSafeValue, "La edad no puede ser nula");
        if(unSaveAge < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        if(unSaveAge > 90){
            throw new IllegalArgumentException("El usuario no debe ser mayor a 90 años");
        }

    }

    public static void ValidateNumber(String unSafeValue){
        int unSaveAge;
        try{

            unSaveAge = Integer.parseInt(unSafeValue);
        }
        catch (Exception e){
            throw new IllegalArgumentException("El valor ingresado no es un numero");
        }

        Objects.requireNonNull(unSafeValue, "El numero no puede ser nulo");
        if(unSaveAge < 0){
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }

        if(unSafeValue.length() > 15 || unSafeValue.length() < 7){
            throw new IllegalArgumentException("El numero debe ser valido (estar entre 7 y 15 digitos)");
        }

    }

    public static void ValidateEmail(String unSafeValue) {
        Objects.requireNonNull(unSafeValue, "El correo no debe ser nulo");
        //Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s:]{10,64}$");
    Pattern pattern = Pattern.compile( "^(.+)@(\\S+)$");
        unSafeValue.trim();
        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
        boolean valid = pattern.matcher(unSafeValue).matches();
        if(!valid){
            throw new IllegalArgumentException("El correo no es valido");
        }


    }

    public static void ValidateRoute(Route unSafeValue){
       // int hours, UUID busSerial;
    }


}
