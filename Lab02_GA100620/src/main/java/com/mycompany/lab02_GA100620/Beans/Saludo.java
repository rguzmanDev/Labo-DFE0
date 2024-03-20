package com.mycompany.lab02_GA100620.Beans;
import javax.ejb.Stateless;

@Stateless
public class Saludo implements ISaludoRemote{
    
    @Override
    public String getSaludo(String suNombre){
        System.out.println("Ejecutando Saludo");
        return "Buenas Noches: " + suNombre;
    }
}
