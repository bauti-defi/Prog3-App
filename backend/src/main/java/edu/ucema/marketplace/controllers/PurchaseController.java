package edu.ucema.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.models.User;
import edu.ucema.marketplace.services.interfaces.IPurchaseService;

@RestController
@RequestMapping(value = "/api/purchase")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class PurchaseController {
    
    @Autowired
    private IPurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Boolean> savePurchases(@RequestBody  SubmittedPurchase purchase) {
        purchaseService.savePurchases(purchase.getNfts(), purchase.getUser());
        return ResponseEntity.ok(true);
    }

    public static class SubmittedPurchase {
        private NFT[] nfts;
        private User user;

        // getters and setters
        public NFT[] getNfts() {
            return nfts;
        }

        public User getUser() {
            return user;
        }

    }


}
