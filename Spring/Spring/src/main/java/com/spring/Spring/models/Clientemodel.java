package com.spring.Spring.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name="TBCLIENTE")
public class Clientemodel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cdempresa;
    private String nmcliente;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCdempresa() { return cdempresa; }

    public void setCdempresa(String cdempresa) { this.cdempresa = cdempresa; }

    public String getNmcliente() { return nmcliente; }

    public void setNmcliente(String nmcliente) { this.nmcliente = nmcliente; }
}
