/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odonto.ejb;


import com.odonto.model.ExpedienteCedi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valer
 */
@Stateless
public class ExpedientecediFacade extends AbstractFacade<ExpedienteCedi> implements ExpedientecediFacadeLocal {

    @PersistenceContext(unitName = "odontoPool")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpedientecediFacade() {
        super(ExpedienteCedi.class);
    }
    
}
