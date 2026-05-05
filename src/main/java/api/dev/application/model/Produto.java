package api.dev.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "informe um nome para o produto")
    private String nameProduct;

    @NotEmpty(message = "informe uma descrição para o produto")
    private String description;

    private Integer quantityInStock;
    private double purchasePrice;
    private double sellingPrice;

    @NotEmpty(message = "informe um fornecedor para o produto")
    private String supplier;

    @NotEmpty(message = "informe uma categoria para o produto")
    private String category;

    @NotEmpty(message = "informe uma subcategoria para o produto")
    private String subcategory;

    public Produto() {
    }

    public Produto(String nameProduct, String description, Integer quantityInStock, double purchasePrice, double sellingPrice, String supplier, String category, String subcategory) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.supplier = supplier;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
