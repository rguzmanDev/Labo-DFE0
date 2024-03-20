
package BeansSingleton;

import javax.ejb.Singleton;



@Singleton
public class Util implements IUtilRemote{
    
    @Override
    public String saludo(){
        return "Saludo desde BeanSingleton";
    }
    
}
