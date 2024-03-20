package BeansStateful.BeanLocal;
import javax.ejb.Stateful;


@Stateful
public class Calculo implements ICalculo{
    
    @Override
    public String mensaje(){
        return "Mensaje desde EJB local";
    }
}
