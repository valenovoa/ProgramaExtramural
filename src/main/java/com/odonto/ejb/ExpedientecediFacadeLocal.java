/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odonto.ejb;


import com.odonto.model.ExpedienteCedi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valer
 */
@Local
public interface ExpedientecediFacadeLocal {

    void create(ExpedienteCedi expedientecedi);

    void edit(ExpedienteCedi expedientecedi);

    void remove(ExpedienteCedi expedientecedi);

    ExpedienteCedi find(Object id);

    List<ExpedienteCedi> findAll();

    List<ExpedienteCedi> findRange(int[] range);

    int count();
    
}
