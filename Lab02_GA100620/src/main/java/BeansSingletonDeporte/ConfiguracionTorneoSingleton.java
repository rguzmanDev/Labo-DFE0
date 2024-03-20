
package BeansSingletonDeporte;

import BeansLocalesDeporte.BibliotecaDeporte.IBibliotecaDeporteLocal;
import javax.ejb.EJB;
import javax.ejb.Singleton;



@Singleton
public class ConfiguracionTorneoSingleton implements IConfiguracionTorneoSingleton {
    
    @EJB
    private IBibliotecaDeporteLocal bibliotecaDeporte; // Inyección del EJB local
    
    private int numeroDeEquipos = 10; // Ejemplo: un torneo con 10 equipos por defecto

    @Override
    public int getNumeroDeEquipos() {
        return numeroDeEquipos;
    }

    @Override
    public void setNumeroDeEquipos(int numeroDeEquipos) {
        this.numeroDeEquipos = numeroDeEquipos;
    }

    // Ejemplo de un nuevo método que utiliza el EJB local
    public String obtenerInformacionDeporte(String deporte) {
        String descripcion = bibliotecaDeporte.obtenerDescripcionDeporte(deporte);
        int maxJugadores = bibliotecaDeporte.obtenerCantidadMaximaJugadores(deporte);
        return "Deporte: " + deporte + ", " + descripcion + ", Máx. Jugadores: " + maxJugadores;
    }
}