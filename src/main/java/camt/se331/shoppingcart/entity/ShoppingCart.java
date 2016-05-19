package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    Double totalPrice;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public ShoppingCart(String name, String description, Double totalPrice, Set<Image> images, List<SelectedProduct> selectedProducts, Date purchaseDate) {
        this.name = name;
        this.description = description;
        this.totalPrice = totalPrice;
        this.images = images;
        this.selectedProducts = selectedProducts;
        this.purchaseDate = purchaseDate;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    List<SelectedProduct> selectedProducts;
    @Temporal(TemporalType.TIMESTAMP)
    Date purchaseDate;
    public double getTotalProductPrice(){
        return 0.0;
    };

    public List<SelectedProduct> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<SelectedProduct> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ShoppingCart(List<SelectedProduct> selectedProducts) {

        this.selectedProducts = selectedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (selectedProducts != null ? !selectedProducts.equals(that.selectedProducts) : that.selectedProducts != null)
            return false;
        return !(purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (selectedProducts != null ? selectedProducts.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart() {


    }
}
