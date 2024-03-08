package uk.co.example.api.database.tables;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private float price, rtp;
    private String name, ref;

    @Column(length = 500)
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Variation> variations;

    public Product() {

    }

    public int getCode() {
        return code;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getRtp() {
        return rtp;
    }

    public float getPrice() {
        return price;
    }

    public String getRef() {
        return ref;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRtp(float rtp) {
        this.rtp = rtp;
    }

    public Set<Variation> getVariations() {
        return variations;
    }

    public void setVariations(Set<Variation> variations) {
        this.variations = variations;
    }
}
