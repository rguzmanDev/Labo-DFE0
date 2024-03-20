
package com.mycompany.lab02_GA100620.Beans;

import javax.ejb.Remote;

@Remote
public interface ISaludoRemote {
    public String getSaludo(String suNombre);
}
