package ru.dmitrysoldatov.evaapple.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;
import ru.dmitrysoldatov.evaapple.dto.OrderDTO;
import ru.dmitrysoldatov.evaapple.dto.ProductDTO;
import ru.dmitrysoldatov.evaapple.models.Categories;
import ru.dmitrysoldatov.evaapple.models.Order;
import ru.dmitrysoldatov.evaapple.models.Product;

@Component
public class converterDTO {
    private ModelMapper modelMapper;

    @Autowired
    public converterDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoriesDTO convertToCategoriesDTO(Categories categories) {
        return modelMapper.map(categories, CategoriesDTO.class);
    }

    public Categories convertToCategories(CategoriesDTO categoriesDTO) {
        return modelMapper.map(categoriesDTO, Categories.class);
    }

    public OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
