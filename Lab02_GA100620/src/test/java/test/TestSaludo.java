
package test;

import BeansSingleton.IUtilRemote;
//import BeansStateful.BeanLocal.ICalculo;
import BeansStateful.IContador;
import com.mycompany.lab02_GA100620.Beans.ISaludoRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSaludo {    
    public static void main(String[] args){
        
        //Testeo
        //saludo();
        //contar();
        //saludoSingleton();
        //testBeanLocal02();
        
    }

    private static void saludo() {
        System.out.println("Llamando el EJB");
        try{
            Context jndi = new InitialContext();
            ISaludoRemote saludoEjb = (ISaludoRemote) jndi.lookup("java:global/appSaludo/Saludo!com.mycompany.lab02_tc100220.Beans.ISaludoRemote");
            String respuesta = saludoEjb.getSaludo("Michael Torres, el ser más guapo del Universo");
            System.out.println(respuesta);
        } catch (NamingException e){
            e.printStackTrace(System.out);
        }
    }

    private static void contar() {
        System.out.println("Llamando al EJB");
        try{
            Context jndi = new InitialContext();
            IContador agregar = (IContador) jndi.lookup("java:global/appSaludo/Contar!BeansStateful.IContador");
            System.out.println(agregar);
            //agregar.agregarItem();
            System.out.println(agregar.test());
            System.out.println("Se agrego un item");
            agregar.agregarItem();
            agregar.agregarItem();
            
            System.out.println("registros: " + agregar.contarItem());
        } catch (NamingException e){
            e.printStackTrace(System.out);
        }
    }

    private static void saludoSingleton() {
        System.out.println("Llamando al EJB de Singleton");
        try{
            Context jndi = new InitialContext();
            IUtilRemote util = (IUtilRemote) jndi.lookup("java:global/appSaludo/Util!BeansSingleton.IUtilRemote");
            
            System.out.println("Respuesta: " + util.saludo());
        } catch (NamingException e){
            e.printStackTrace(System.out);
        }
    }

    /*
    private static void testBeanLocal02() {
        System.out.println("Llamando al EJB LOCAL");
        try{
            Context jndi = new InitialContext();
            ICalculo agregar = (ICalculo) jndi.lookup("java:global/appSaludo/Calculo!BeansStateful.BeanLocal.ICalculo");
            
            System.out.println(agregar.mensaje());
        } catch (NamingException e){
            e.printStackTrace(System.out);
        }
    } */
    
}
