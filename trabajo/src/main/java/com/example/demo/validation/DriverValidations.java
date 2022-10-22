package com.example.demo.validation;
import java.util.Objects;
import java.util.regex.Pattern;


public class DriverValidations {
    public static void ValidateDriver(
            String unSafeName,
            String unSafeEmail,
            String unSafeNumber,
            String unSafeId,
            String unSafeAddress
    ){
        ValidateName(unSafeName);
        ValidateEmail(unSafeEmail);
        ValidateNumber(unSafeNumber);
        ValidateAddress(unSafeAddress);
        ValidateId(unSafeId);
    }
    public static void ValidateName(String unSafeValue){
        Objects.requireNonNull(unSafeValue, "El nombre no debe ser nulo");
        //Pattern pattern = Pattern.compile("[A-Z][a-zA-Z]*");
        unSafeValue.trim();

        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(unSafeValue.length() > 100){
            throw new IllegalArgumentException("El nombre no puede ser superior a 100 caracteres");
        }
        //boolean valid = pattern.matcher(unSafeValue).matches();
        if(!unSafeValue.matches("[a-zA-Z]{1,}")){
            throw new IllegalArgumentException("El nombre no puede tener caracteres especiales");
        }
    }

    public static void ValidateAddress(String unSafeValue){
        Objects.requireNonNull(unSafeValue, "La direccion no debe ser nula");
        //Pattern pattern = Pattern.compile("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
        unSafeValue.trim();

        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("La direccion no puede estar vacia");
        }
        if(unSafeValue.length() > 100){
            throw new IllegalArgumentException("La direccion no puede ser superior a 100 caracteres");
        }
        //boolean valid = pattern.matcher(unSafeValue).matches();
        //if(!unSafeValue.matches("^(Autopista|Avenida|Avenida Calle|Avenida Carrera|Avenida|Carrera|Calle|Carrera|Circunvalar|Diagonal|Kilometro|Transversal|AUTOP|AV|AC|AK|CL|KR|CCV|DG|KM|TV)(\\s)?([a-zA-Z]{0,15}|[0-9]{1,3})(\\s)?[a-zA-Z]?(\\s)?(bis)?(\\s)?(Este|Norte|Occidente|Oeste|Sur)?(\\s)?(#(\\s)?[0-9]{1,2}(\\s)?[a-zA-Z]?(\\s)?(bis)?(\\s)?(Este|Norte|Occidente|Oeste|Sur)?(\\s)?(-)?(\\s)?[0-9]{1,3}(\\s)?(Este|Norte|Occidente|Oeste|Sur)?)?((\\s)?(Agrupación|Altillo|Apartamento|Apartamento Sótano|Barrio|Bloque|Bodega|Cabecera Municipal|Callejón|Camino|Carretera|Casa|Caserio|Célula|Centro|Centro Comercial|Centro Urbano|Circular|Condominio|Conjunto|Consultorio|Corregimiento|Deposito|Deposito |Sótano|Edificio|Entrada|Esquina|Etapa|Finca|Garaje|Garaje Sótano|Grada|Inferior|Inspección de Policia|Interior|Kilometro|Local|Local Mezzanine|Local Sótano|Lote|Manzana|Manzanita|Mejora|Mezzanine|Módulo|Municipio|Núcleo|Oficina|Oficina Sótano|Parcela|Parcelación|Pasaje|Penthouse|Piso|Porteria|Predio|Principal|Puente|Quebrada|Salon|Sector|Semisótano|Suite|Supermanzana|Terraza|Torre|Troncal|Unidad|Urbanización|Vereda|Via|Zona|AGN|AL|APTO|AS|BR|BL|BG|CM|CLJ|CN|CT|CA|CAS|CEL|CE|CECO|CEUR|CIR|CDM|CONJ|CS|CO|DP|DS|ED|EN|ESQ|ET|FCA|GJ|GS|GR|INF|IP|IN|KM|LC|LM|LS|LT|MZ|MZTA|MJ|MN|MD|MUN|NCO|OF|OS|PA|PCN|PSJ|PH|PI|PT|PD|PPAL|PN|QDA|SA|SEC|SS|SU|SMZ|TZ|TO|TRL|UN|URB|VDA|VIA|ZN)?(\\s)?[1-9][0-9]{0,3})*$" )){
          //  throw new IllegalArgumentException("La direccion no contiene caracteres validos");
        //}
    }

    public static void ValidateNumber(String unSafeValue){
        float unSaveInt = 0;
        //System.out.println(unSafeValue);

        try{

            unSaveInt = Float.parseFloat(unSafeValue);

        }
        catch (Exception e){
            //e.printStackTrace();
            throw new IllegalArgumentException("El valor ingresado no es un numero");
        }

        Objects.requireNonNull(unSafeValue, "El numero no puede ser nulo");
        if(unSaveInt < 0){
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }

        if(unSafeValue.length() > 15 || unSafeValue.length() < 7){
            throw new IllegalArgumentException("El numero debe ser valido (estar entre 7 y 15 digitos)");
        }

    }

    public static void ValidateId(String unSafeValue){
        float unSaveId;
        try{

            unSaveId = Float.parseFloat(unSafeValue);
        }
        catch (Exception e){
            throw new IllegalArgumentException("El Id ingresado no es un numero");
        }

        Objects.requireNonNull(unSafeValue, "El Id no puede ser nulo");
        if(unSaveId < 0){
            throw new IllegalArgumentException("El Id no puede ser negativo");
        }

        if(unSafeValue.length() > 15 || unSafeValue.length() < 5){
            throw new IllegalArgumentException("El Id debe ser valido (estar entre 5 y 15 digitos)");
        }

    }

    public static void ValidateEmail(String unSafeValue) {
        Objects.requireNonNull(unSafeValue, "El correo no debe ser nulo");
        //Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s:]{10,64}$");
    Pattern pattern = Pattern.compile( "^(?=.{1,81}$)[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$");
        unSafeValue.trim();
        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
        boolean valid = pattern.matcher(unSafeValue).matches();
        if(!valid){
            throw new IllegalArgumentException("El correo no es valido");
        }


    }


}
