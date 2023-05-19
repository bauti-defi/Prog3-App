package edu.ucema.marketplace.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @Column(name = "collection_id")
    private String address;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String description;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<NFT> nfts;

    public Collection(){}

    public Collection(String address, String name, String description) {
        this.address = address;
        this.name = name;
        this.description = description;
    }

    // Getters and setters

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<NFT> getNfts() {
        return nfts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection collection = (Collection) o;
        return Objects.equals(address, collection.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
    
}
