
package com.odonto.controller;

import com.odonto.ejb.ExpedientecediFacadeLocal;
import com.odonto.ejb.FichacediFacadeLocal;
import com.odonto.model.ExpedienteCedi;
import com.odonto.model.FichaCedi;
import com.odonto.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ListaFichasController implements Serializable{
    @EJB
    private ExpedientecediFacadeLocal cediEJB;
    
    @EJB
    private FichacediFacadeLocal fichaEJB;
    
    @Inject
    private CediController cediController;
    
    @Inject
    private FichaCedi ficha;
    
    
    
    private ExpedienteCedi cedi;
    
    
     @PostConstruct
    public void init(){
        this.cedi = cediController.getCediS();
    }

    public ExpedienteCedi getCedi() {
        return cedi;
    }

    public void setCedi(ExpedienteCedi cedi) {
        this.cedi = cedi;
    }

    public FichaCedi getFicha() {
        return ficha;
    }

    public void setFicha(FichaCedi ficha) {
        this.ficha = ficha;
    }
    
    public void registrar(){
        
         try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            
            ficha.setExpedientecedi(cedi);
            ficha.setPersona(us.getCodigo());
            fichaEJB.create(ficha);
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!!!"));
        }
        
    }
    
}
