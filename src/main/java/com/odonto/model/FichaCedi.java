
package com.odonto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fichacedi")
public class FichaCedi implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "fecha" , insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "razon")
    private String razon;
    
    @ManyToOne
    @JoinColumn(name="codigoPersona", nullable = false)
    private Persona persona;
    
     @ManyToOne
     @JoinColumn(name="codigoExpediente", nullable = false)
     private ExpedienteCedi expedientecedi;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ExpedienteCedi getExpedientecedi() {
        return expedientecedi;
    }

    public void setExpedientecedi(ExpedienteCedi expedientecedi) {
        this.expedientecedi = expedientecedi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaCedi other = (FichaCedi) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FichaCedi{" + "codigo=" + codigo + '}';
    }
    
     
    
}
