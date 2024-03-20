
package BeansLocalesDeporte.BibliotecaDeporte;

import javax.ejb.Stateless;

@Stateless
public class BibliotecaDeporteBean implements IBibliotecaDeporteLocal {

    @Override
    public String obtenerDescripcionDeporte(String deporte) {
        //Aqui deberia de poner info real del deporte pero solo es para testeo
        return "Descripción detallada del " + deporte + ": Esta informacion se manda a llamar al Local"; //💃💃💃
    }

    @Override
    public int obtenerCantidadMaximaJugadores(String deporte) {
        
        //Para imprimir info segun lo que se introduzca en el Test
        if ("Fútbol".equalsIgnoreCase(deporte)) {
            return 11;
        } else if ("Baloncesto".equalsIgnoreCase(deporte)) {
            return 5;
        } else {
            return 0; // Por defecto si el deporte se ingresa mal u otro que no este acá
        }
    }
}