package edu.ucema.marketplace.services.interfaces;

import edu.ucema.marketplace.models.User;

public interface IAuthService {
    
    User createAccount(String username, String wallet);

    boolean authenticate(String username, String wallet);

}
