package edu.ucema.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ucema.marketplace.services.interfaces.IAuthService;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AuthController {
    
    @Autowired
    private IAuthService authService;

    @PostMapping
    public ResponseEntity<Boolean> authenticate(@RequestBody User user) {
        boolean isAuthenticated = authService.authenticate(user.getUsername(), user.getWallet());
        return ResponseEntity.ok(isAuthenticated);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> createAccount(@RequestBody User user) {
        authService.createAccount(user.getUsername(), user.getWallet());
        return ResponseEntity.ok(true);
    }

    public static class User {
        private String username;
        private String wallet;

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getWallet() {
            return wallet;
        }

        public void setWallet(String wallet) {
            this.wallet = wallet;
        }
    }


}
