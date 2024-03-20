
package BeansSingleton;

import javax.ejb.Remote;


@Remote
public interface IUtilRemote {
    public String saludo();
}
