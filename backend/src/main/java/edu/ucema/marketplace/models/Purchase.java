package edu.ucema.marketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userAddress")
    private User user;

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "address", referencedColumnName = "address"),
        @JoinColumn(name = "tokenId", referencedColumnName = "tokenId")
    })
    private NFT nft;

    
    public Purchase(){}

    public Purchase(NFT nft, User user){
        this.nft = nft;
        this.user = user;
    }

    public NFT getNft(){
        return this.nft;
    }
}
