
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ModelClient;

@ManagedBean
@SessionScoped
public class ClientController {

    private ModelClient client = null;
    
    public ClientController() {
    }

    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }
    
    
    
}
