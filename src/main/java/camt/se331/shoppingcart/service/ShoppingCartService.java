package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.ShoppingCart;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
@CrossOrigin
public interface ShoppingCartService {
    ShoppingCart findById(Long id);
    List<ShoppingCart> getShoppingCarts();
    List<ShoppingCart> getShoppingCartBetween(Date stateDate, Date stopDate);
    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart deleteShoppingCart(ShoppingCart shoppingCart);
}
