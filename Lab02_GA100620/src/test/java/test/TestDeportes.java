package test;

import BeansSingletonDeporte.IConfiguracionTorneoSingleton;
import BeansStatefulDeporte.IGestorEquipos;
import BeansStatelessDeporte.ICalculadoraEstadisticasStateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestDeportes {

    public static void main(String[] args) {
        
        //Probando los TEST
        deporteSingleton();
        deporteStateful();
        deporteStateless();
        
    }
    
    //Aqui pruebo SINGLETON
    private static void deporteSingleton(){
            System.out.println("\nLlamando el EJB de Singleton");
            try {
            Context jndi = new InitialContext();
            IConfiguracionTorneoSingleton configuracion = (IConfiguracionTorneoSingleton) jndi.lookup("java:global/appSaludo/ConfiguracionTorneoSingleton!BeansSingletonDeporte.IConfiguracionTorneoSingleton");

            // Imprimir el número de equipos actual
            System.out.println("Número de equipos actual: " + configuracion.getNumeroDeEquipos());

            // Cambiar el número de equipos
            configuracion.setNumeroDeEquipos(100);

            // Verificar el cambio
            System.out.println("Nuevo número de equipos: " + configuracion.getNumeroDeEquipos());

            // Prueba del método LOCAL obtenerInformacionDeporte
            String infoFutbol = configuracion.obtenerInformacionDeporte("Fútbol");
            System.out.println(infoFutbol);
            
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
        }

    //AQUI PRUEBO STATEFUL
    private static void deporteStateful() {
        System.out.println("\nLlamando al EJB de Stateful");
        
        try {
            Context ctx = new InitialContext();
            IGestorEquipos gestor = (IGestorEquipos) ctx.lookup("java:global/appSaludo/GestorEquipos!BeansStatefulDeporte.IGestorEquipos");

            //Agregar nuevos equipos a la lista
            gestor.agregarEquipo("Futbol Club Barcelona");
            gestor.agregarEquipo("Manchester City");
            gestor.agregarEquipo("Inter de Milan");
            gestor.agregarEquipo("Virgina Futbol Club");
            gestor.agregarEquipo("Quinto equipo");
            
            //Mostrar en consola la cantidad de equipos que hay en la lista
            System.out.println("Cantidad de equipos: " + gestor.contarCantidadDeEquipos());

            //Borrar un equipo en especifico
            gestor.borrarEquipo("Virgina Futbol Club");
            System.out.println("Cantidad de equipos después de borrar uno: " + gestor.contarCantidadDeEquipos());

            //Borrar todos los equipos
            gestor.borrarTodosLosEquipos();
            System.out.println("Cantidad de equipos después de borrar todos: " + gestor.contarCantidadDeEquipos());
            
            // Prueba del método LOCAL obtenerInformacionDeporte
            String infoFutbol = gestor.obtenerInformacionDeporte("Fútbol");
            System.out.println(infoFutbol);
            
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }

    //AQUI PRUEBO STATLESS
    private static void deporteStateless() {
        System.out.println("\nLlamando el EJB de Stateless");
        
        try {
            Context jndi = new InitialContext();
            ICalculadoraEstadisticasStateless calculadora = (ICalculadoraEstadisticasStateless) jndi.lookup("java:global/appSaludo/CalculadoraEstadisticasStateless!BeansStatelessDeporte.ICalculadoraEstadisticasStateless");

            // Prueba del método calcularPromedioGoles
            int totalGoles = 79;
            int totalPartidos = 32;
            double promedioGoles = calculadora.calcularPromedioGoles(totalGoles, totalPartidos);
            System.out.println("\n---ESTADISTICAS DEL FUTBOL CLUB BARCELONA - MÉS QUE UN ÇLUB---\n");
            System.out.println("El promedio de goles por partido es: " + promedioGoles + " goles");

            // Prueba del método calcularPorcentajeVictorias
            int totalVictorias = 24;
            double porcentajeVictorias = calculadora.calcularPorcentajeVictorias(totalVictorias, totalPartidos);
            System.out.println("El porcentaje de victorias es: " + porcentajeVictorias + "%");
            
            // Prueba del método LOCAL obtenerInformacionDeporte
            String infoFutbol = calculadora.obtenerInformacionDeporte("Baloncesto");
            System.out.println(infoFutbol);


        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
    
}
