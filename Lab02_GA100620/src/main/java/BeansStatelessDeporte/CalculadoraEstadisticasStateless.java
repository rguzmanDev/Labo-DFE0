
package BeansStatelessDeporte;

import BeansLocalesDeporte.BibliotecaDeporte.IBibliotecaDeporteLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Stateless
public class CalculadoraEstadisticasStateless implements ICalculadoraEstadisticasStateless{
    
    @EJB
    private IBibliotecaDeporteLocal bibliotecaDeporte; // Inyección del EJB local

    @Override
    public double calcularPromedioGoles(int totalGoles, int totalPartidos) {
        // Utilizo métodos de bibliotecaDeporte aquí si es necesario
        if (totalPartidos == 0) return 0; // para evitar dividir enter 0
        BigDecimal goles = new BigDecimal(totalGoles);
        BigDecimal partidos = new BigDecimal(totalPartidos);
        return goles.divide(partidos, 2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double calcularPorcentajeVictorias(int totalVictorias, int totalPartidos) {
        // Utilizo métodos de bibliotecaDeporte aquí si es necesario al igual que arribita
        if (totalPartidos == 0) return 0; // Para evitar dividir entre 0
        BigDecimal victorias = new BigDecimal(totalVictorias);
        BigDecimal partidos = new BigDecimal(totalPartidos);
        return victorias.divide(partidos, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).doubleValue();
    }
    
    // Ejemplo de un nuevo método que utiliza el EJB local
    public String obtenerInformacionDeporte(String deporte) {
        String descripcion = bibliotecaDeporte.obtenerDescripcionDeporte(deporte);
        int maxJugadores = bibliotecaDeporte.obtenerCantidadMaximaJugadores(deporte);
        return "Deporte: " + deporte + ", " + descripcion + ", Máx. Jugadores: " + maxJugadores;
    }
}
