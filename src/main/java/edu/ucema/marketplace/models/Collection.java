package edu.ucema.marketplace.models;

import java.util.List;

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
    private String address;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String description;

    @OneToMany(mappedBy = "collection", orphanRemoval = true, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<NFT> nfts;

    public Collection(){}

    public Collection(String address, String name, String description) {
        this.address = address;
        this.name = name;
        this.description = description;
    }
    
}
