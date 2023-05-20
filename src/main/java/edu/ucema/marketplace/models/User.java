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
@Table(name = "user")
public class User {

    @Id
    private String walletAddress;

    @Column(name = "name", nullable = true)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Purchase> purchases; 

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Listing> listings;

    public User(){}

    public User(String walletAddress){
        this.walletAddress = walletAddress;
    }

    public User(String walletAddress, String name){
        this.walletAddress = walletAddress;
        this.name = name;
    }

    public String getWalletAddress(){
        return this.walletAddress;
    }

    public String getName(){
        return this.name;
    }
    
}
