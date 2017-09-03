
package com.odonto.ejb;

import com.odonto.model.FichaCedi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valer
 */
@Local
public interface FichacediFacadeLocal {

    void create(FichaCedi fichacedi);

    void edit(FichaCedi fichacedi);

    void remove(FichaCedi fichacedi);

    FichaCedi find(Object id);

    List<FichaCedi> findAll();

    List<FichaCedi> findRange(int[] range);

    int count();
    
}
