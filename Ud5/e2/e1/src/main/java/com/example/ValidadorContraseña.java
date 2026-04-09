package com.example;


public class ValidadorContraseña {

   public boolean esValida(String contraseña){

    boolean tieneMayus = contraseña.matches(".*[A-Z].*"); 
    boolean tieneMinus = contraseña.matches(".*[a-z].*"); 
    boolean tieneNums = contraseña.matches(".*[0-9].*"); 
    boolean tieneEsp = contraseña.matches(".*[!@#$%^&*].*"); 




    if(contraseña.length() < 8) {
        return false;
    }else if(!tieneEsp) {
        return false;

    }else if (!tieneMayus){
        return false;
    }else if(!tieneMinus){
        return false;
    }else if(!tieneNums){
        return false;
    }else {
        return true;
    }

   }
 
}
