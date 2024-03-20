
package BeansStatelessDeporte;

import javax.ejb.Remote;

@Remote
public interface ICalculadoraEstadisticasStateless {
    double calcularPromedioGoles(int totalGoles, int totalPartidos);
    double calcularPorcentajeVictorias(int totalVictorias, int totalPartidos);

    //Del local
    public String obtenerInformacionDeporte(String fútbol);
}