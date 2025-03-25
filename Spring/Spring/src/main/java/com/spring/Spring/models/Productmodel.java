package com.spring.Spring.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="TBPRODUTO")
public class Productmodel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nmproduto;
    private BigDecimal vlproduto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmproduto() {
        return nmproduto;
    }

    public void setNmproduto(String nmproduto) {
        this.nmproduto = nmproduto;
    }

    public BigDecimal getVlproduto() {
        return vlproduto;
    }

    public void setVlproduto(BigDecimal vlproduto) {
        this.vlproduto = vlproduto;
    }
}
