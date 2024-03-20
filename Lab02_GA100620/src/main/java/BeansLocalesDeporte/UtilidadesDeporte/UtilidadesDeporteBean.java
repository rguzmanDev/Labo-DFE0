
package BeansLocalesDeporte.UtilidadesDeporte;

import javax.ejb.Stateless;
@Stateless
public class UtilidadesDeporteBean implements IUtilidadesDeporteLocal {

    @Override
    public boolean esNombreEquipoValido(String nombreEquipo) {
        // Implementp la lógica para validar el nombre del equipo
        return nombreEquipo != null && !nombreEquipo.trim().isEmpty();
    }

}
