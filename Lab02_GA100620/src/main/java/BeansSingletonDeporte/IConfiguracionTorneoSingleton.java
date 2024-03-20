
package BeansSingletonDeporte;
import javax.ejb.Remote;


@Remote
public interface IConfiguracionTorneoSingleton {
    int getNumeroDeEquipos();
    void setNumeroDeEquipos(int numeroDeEquipos);
    
    //Del local
    public String obtenerInformacionDeporte(String fútbol);
}
