package camt.se331.shoppingcart.config;

import camt.se331.shoppingcart.entity.*;
import camt.se331.shoppingcart.repository.ProductRepository;
import camt.se331.shoppingcart.repository.ShoppingCartRepository;
import camt.se331.shoppingcart.repository.UserRepository;
import camt.se331.shoppingcart.service.ImageUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */

@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Product[] initProduct = {
                new Product(1l, "Rice", "Natural , with fibrous texture and appetising flavour.", 100.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/rice1.png"), 200)),
                new Product(2l, "Stevia glass", "Sweet herb,natural,home-produced", 70.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/Steviaglass.png"), 200)),
                new Product(3l, "White chrysanthemum tea", "Serve the fresh flower fragrance from the source garden", 60.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/Whitechrysanthemumtea.png"), 200)),
                new Product(4l, "Banana chip", "Your delicious bites nurture the forest.", 50.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/bananaship1.png"), 200)),
                new Product(5l, "Hugpa coffee", " People preserves the forest and the forest preserves the earth.", 180.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/hugpacoffee.png"), 200)),
                new Product(6l, "Champoo", "Safe for your hands, cure your hair and nourish your skin.", 50.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/champoo1.png"), 200)),
                new Product(7l, "Soap", " a natural treatment for all skin types", 50.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/Soap1.png"), 200)),
                new Product(8l, "ยาเขียว", "สมุนไพรในการผลิตรับชื้อจากกลุ่มแม่บ้านและชาวบ้านในชุมชนอมลอง",60.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/bottle.png"), 200)),
                new Product(9l, "ข้าวกล้องดอย", "Brown rice", 50.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/rice2.png"), 200)),
                new Product(10l, "ข้าวขาว", "GABA rice", 40.00, ImageUtil.resizeImage(ImageUtil.getImage("pic/rice3.png"), 200))
        };
        productRepository.save(Arrays.asList(initProduct));
        productRepository.save(new Product(1l,"Rice","Natural , with fibrous texture and appetising flavour.", 100.00));


        ShoppingCart shoppingCart = new ShoppingCart();
        List<SelectedProduct> selectedProducts = new ArrayList<>();
        SelectedProduct[] initSelectedProduct = {
                new SelectedProduct(initProduct[2], 5),
                new SelectedProduct(initProduct[4], 2),
                new SelectedProduct(initProduct[1], 1),
        };
        selectedProducts.addAll(Arrays.asList(initSelectedProduct));
        Calendar calendar = new GregorianCalendar(2015, 4, 7);
        shoppingCart.setSelectedProducts(selectedProducts);
        shoppingCart.setPurchaseDate(calendar.getTime());
        shoppingCart.setId(1L);
        shoppingCartRepository.save(shoppingCart);

        // add user
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");
        Role ForeignUserRole = new Role("ForeignUser");
        Role CustomerRole = new Role("Customer");
        Role WholeSaleRole = new Role("WholeSale");
        Role RetailRole = new Role("Retail");


        User admin = new User();
        admin.setName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);
        userRepository.save(admin);

      /*  User user = new User();
        user.setName("user");
        user.setUsername("user");
        user.setEmail("user@yahoo.com");
        user.setPassword("123456");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);
        userRepository.save(admin);
        userRepository.save(user);
        admin.setRoles(roles);
        user.setRoles(roles2);*/

        /*User ForeignUser = new User();
        ForeignUser.setName("ForeignUser");
        ForeignUser.setUsername("ForeignUser");
        ForeignUser.setEmail("user@yahoo.com");
        ForeignUser.setPassword("123456");
        Set<Role> roles3 = new HashSet<>();
        roles3.add(ForeignUserRole);
        ForeignUser.setRoles(roles3);
        userRepository.save(ForeignUser);
        admin.setRoles(roles);
        ForeignUser.setRoles(roles3);*/

        User Customer = new User();
        Customer.setName("Customer");
        Customer.setUsername("Customer");
        Customer.setEmail("user@yahoo.com");
        Customer.setPassword("123456");
        Set<Role> roles4 = new HashSet<>();
        roles4.add(CustomerRole);
        Customer.setRoles(roles4);
        userRepository.save(Customer);
        admin.setRoles(roles);
        Customer.setRoles(roles4);

        User WholeSale = new User();
        WholeSale.setName("WholeSale");
        WholeSale.setUsername("WholeSale");
        WholeSale.setEmail("user@yahoo.com");
        WholeSale.setPassword("123456");
        Set<Role> roles5 = new HashSet<>();
        roles5.add(WholeSaleRole);
        WholeSale.setRoles(roles5);
        userRepository.save(WholeSale);
        admin.setRoles(roles);
        WholeSale.setRoles(roles5);

        User Retail = new User();
        Retail.setName("Retail");
        Retail.setUsername("Retail");
        Retail.setEmail("user@yahoo.com");
        Retail.setPassword("123456");
        Set<Role> roles6 = new HashSet<>();
        roles6.add(RetailRole);
        Retail.setRoles(roles6);
        userRepository.save(Retail);
        admin.setRoles(roles);
        Retail.setRoles(roles6);
    }
}
