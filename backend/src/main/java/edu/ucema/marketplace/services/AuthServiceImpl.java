package edu.ucema.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucema.marketplace.models.User;
import edu.ucema.marketplace.repositories.UserRepository;
import edu.ucema.marketplace.services.interfaces.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createAccount(String username, String wallet) {
        if(this.userRepo.existsById(wallet))
            throw new RuntimeException("User already exists");

        return this.userRepo.save(new User(wallet, username));
    }

    @Override
    public boolean authenticate(String username, String wallet) {
        return this.userRepo.existsById(wallet);
    }
    
}
