
package com.odonto.controller;

import com.odonto.ejb.ExpedientecediFacadeLocal;
import com.odonto.model.ExpedienteCedi;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class CediController implements Serializable{
    
    @EJB
    private ExpedientecediFacadeLocal cediEJB;
    
    @Inject
    private ExpedienteCedi cedi;
    
    private ExpedienteCedi cediS;
    
    private List<ExpedienteCedi> cedis;
    
    private String accion;
    
    @PostConstruct
    public void init(){
      cedis = cediEJB.findAll();
    }

    public ExpedienteCedi getCedi() {
        return cedi;
    }

    public void setCedi(ExpedienteCedi cedi) {
        this.cedi = cedi;
    }

    public List<ExpedienteCedi> getCedis() {
        return cedis;
    }

    public void setCedis(List<ExpedienteCedi> cedis) {
        this.cedis = cedis;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public ExpedienteCedi getCediS() {
        return cediS;
    }

    public void setCediS(ExpedienteCedi cediS) {
        this.cediS = cediS;
    }
    
    
    
     public void registrar() {
         cediEJB.create(cedi);
         
         cedis = cediEJB.findAll();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
    }
     
     public void asignar(ExpedienteCedi cediS){
         this.cediS = cediS;
     }
    /*  
    public void mostrarDialogo(){
        //logica
        
        this.setAccion("R");
        
         RequestContext req = RequestContext.getCurrentInstance();
         req.execute("PF('wdialogo').show();");
    } 
    
     public void leer(ExpedienteCedi cedifSeleccion) {
        cedi = cedifSeleccion;
        this.setAccion("M");
    }
     
    public void modificar(ExpedienteCedi cedi){
        cediEJB.edit(cedi);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
    } */
    
    
}
