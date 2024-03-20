
package BeansStatefulDeporte;

import javax.ejb.Remote;

@Remote
public interface IGestorEquipos {
    void agregarEquipo(String nombreEquipo);
    void borrarEquipo(String nombreEquipo);
    int contarCantidadDeEquipos();
    void borrarTodosLosEquipos();
    
    //Del local
    public String obtenerInformacionDeporte(String fútbol);
}