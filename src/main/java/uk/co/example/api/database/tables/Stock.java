package uk.co.example.api.database.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "stocks")
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int size;
    private int amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "variation_id", referencedColumnName = "id")
    private Variation variation;

    public Stock() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Variation getVariation() {
        return variation;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }
}
