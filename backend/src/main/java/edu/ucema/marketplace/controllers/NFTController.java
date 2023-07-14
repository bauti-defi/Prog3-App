package edu.ucema.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.services.interfaces.INFTService;

@RestController
@RequestMapping(value = "/api/nft")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class NFTController {
    
    @Autowired
    private INFTService nftService;

    @GetMapping(path = "/{address}/{tokenId}")
    public NFT getNFT(@PathVariable String address, @PathVariable String tokenId) {
        return this.nftService.getNft(address, tokenId);
    } 

}
