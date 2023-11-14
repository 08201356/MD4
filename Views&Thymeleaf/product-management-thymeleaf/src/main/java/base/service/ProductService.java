package base.service;

import base.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;
    static{
        products = new HashMap<>();
        products.put(1, new Product(1, "Vandal", 2900, "One-tap-headshot Assault Rifle"));
        products.put(2, new Product(2, "Phantom", 2900, "No-bullet-trace Assault Rifle"));
        products.put(3, new Product(3, "Operator", 4700, "High Caliber Sniper Rifle"));
        products.put(4, new Product(4, "Bulldog", 2050, "Assault Rifle"));
        products.put(5, new Product(5, "Ghost", 500, "Silencer-equipped Pistol"));
        products.put(6, new Product(6, "Sheriff", 800, "Revolver"));
        products.put(7, new Product(7, "Spectre", 1600, "Short-range Sub-machine Gun"));
        products.put(8, new Product(8, "Odin", 3200, "High-penetration Machine Gun"));
        products.put(9, new Product(9, "Guardian", 2250, "No-spraying Assault Rifle"));
        products.put(10, new Product(10, "Classic", 0, "Handgun"));
        products.put(11, new Product(11, "Marshall", 900, "Fast-loading Sniper Rifle"));
        products.put(12, new Product(12, "Stinger", 950, "High-fire-rate Sub-machine Gun"));
        products.put(13, new Product(13, "Ares", 1600, "Machine Gun"));
        products.put(14, new Product(14, "Frenzy", 450, "Mini Sub-machine Gun"));
        products.put(15, new Product(15, "Bucky", 850, "Classic Shotgun"));
        products.put(16, new Product(16, "Shorty", 150, "Saw-off Shotgun"));
        products.put(17, new Product(17, "Judge", 1850, "Automatic Shotgun"));
    }
    @Override
    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }
    @Override
    public void save(Product product){
        products.put(product.getId(), product);
    }
    @Override
    public Product findById(int id) {
        return products.get(id);
    }
    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
