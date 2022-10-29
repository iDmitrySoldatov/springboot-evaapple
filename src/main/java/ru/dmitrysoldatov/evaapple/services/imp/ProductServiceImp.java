package ru.dmitrysoldatov.evaapple.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitrysoldatov.evaapple.convert.ConverterDTO;
import ru.dmitrysoldatov.evaapple.dto.ProductDTO;
import ru.dmitrysoldatov.evaapple.models.Product;
import ru.dmitrysoldatov.evaapple.repositories.ProductRepository;
import ru.dmitrysoldatov.evaapple.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductServiceImp implements ProductService {

    private ProductRepository repository;
    private ConverterDTO converterDTO;

    @Autowired
    public ProductServiceImp(ProductRepository repository, ConverterDTO converterDTO) {
        this.repository = repository;
        this.converterDTO = converterDTO;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        Product product = repository.save(converterDTO.convertToProduct(productDTO));
        return converterDTO.convertToProductDTO(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = repository.findAll();
        return converterDTO.convertListToProductDTO(productList);
    }

    @Override
    public ProductDTO findById(Integer id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (!optionalProduct.isEmpty()) {
            Product product = optionalProduct.get();
            return converterDTO.convertToProductDTO(product);
        } else {
            return null;
        }
    }
}
