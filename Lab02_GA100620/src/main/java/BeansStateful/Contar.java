
package BeansStateful;
import BeansStateful.BeanLocal.ICalculo;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class Contar implements IContador{
    private int item;
    
    @Override
    public void agregarItem(){
        item++;
    }
    
    @Override
    public void borrarItem(){
        item--;
    }
    
    @Override
    public int contarItem(){
        
        return 0;
        
    }
    
    @Override
    public void borrarTodo(){
        item--;
    }
    
    @Override
    public String test(){
        
        return null;
    }
    
/*
    @EJB
    private ICalculo iCalculo;
    
    @Override
    public String test(){
        return "Hola desde EJB Remoto + " + iCalculo.mensaje();
    } */
    
}
