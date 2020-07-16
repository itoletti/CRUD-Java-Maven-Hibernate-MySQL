package com.itoletti.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="dni")
    private int dni;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;  
    @Column(name="id_dir")
    private int id_dir;    

    public Persona() {
    }

    public Persona(int dni, String nombre, String apellido, int id_dir) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_dir = id_dir;
    }

    public int getDni() {
        return dni;
    }

    public void setId(int dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dni;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", id_dir=" + id_dir + '}';
    }


}
