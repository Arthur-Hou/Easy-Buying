package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.service.ProductService;
import camt.se331.shoppingcart.service.ProductServiceImpl;
import camt.se331.shoppingcart.service.ShoppingCartService;
import camt.se331.shoppingcart.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
    /*@Autowired
    ProductService productService = new ProductServiceImpl();*/

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ShoppingCart getShoppingCart(@PathVariable("id") Long id){
        return shoppingCartService.findById(id);
    }

    /*@RequestMapping(value = "ShoppingCart",method = RequestMethod.GET)
    public  List<ShoppingCart> list(){
        return shoppingCartService.getShoppingCarts();
    }*/


    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ShoppingCart updateShoppingCart(@PathVariable("id")Long id,@RequestBody ShoppingCart cart, BindingResult bindingResult){
        return shoppingCartService.addShoppingCart(cart);
    }
}
