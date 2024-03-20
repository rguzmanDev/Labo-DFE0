
package BeansLocalesDeporte.BibliotecaDeporte;

import javax.ejb.Local;


@Local
public interface IBibliotecaDeporteLocal {
    String obtenerDescripcionDeporte(String deporte);
    int obtenerCantidadMaximaJugadores(String deporte);
}