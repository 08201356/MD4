package base.service;

import base.model.Product;
import base.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll(){
        return iProductRepository.findAll();
    }
    @Override
    public Optional<Product>  findById(int id){
        return iProductRepository.findById(id);
    }
    @Override
    public Product save(Product product){
        return iProductRepository.save(product);
    }
    @Override
    public void delete(int id){
        iProductRepository.deleteById(id);
    }
}
