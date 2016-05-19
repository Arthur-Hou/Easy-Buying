package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
@CrossOrigin
public interface UserService {
    public List<User> findAll();
    public User findByUserName(String username);
    public User findUserByEmail(String username);
    public User login(String email, String password);
}
