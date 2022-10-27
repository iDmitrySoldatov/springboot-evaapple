package ru.dmitrysoldatov.evaapple.convert;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitrysoldatov.evaapple.dto.CategoriesDTO;
import ru.dmitrysoldatov.evaapple.dto.OrderDTO;
import ru.dmitrysoldatov.evaapple.dto.ProductDTO;
import ru.dmitrysoldatov.evaapple.models.Categories;
import ru.dmitrysoldatov.evaapple.models.Order;
import ru.dmitrysoldatov.evaapple.models.Product;

import java.util.List;

@Component
public class ConverterDTO {
    private ModelMapper modelMapper;

    @Autowired
    public ConverterDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoriesDTO convertToCategoriesDTO(Categories categories) {
        return modelMapper.map(categories, CategoriesDTO.class);
    }

    public Categories convertToCategories(CategoriesDTO categoriesDTO) {
        return modelMapper.map(categoriesDTO, Categories.class);
    }

    public List<CategoriesDTO> convertListToCategoriesDTO(List<Categories> categoriestList) {
        return modelMapper.map(categoriestList, new TypeToken<List<CategoriesDTO>>() {
        }.getType());
    }

    public List<Categories> convertListToCategories(List<CategoriesDTO> categoriesDTOList) {
        return modelMapper.map(categoriesDTOList, new TypeToken<List<Categories>>() {
        }.getType());
    }

    public OrderDTO convertToOrderDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public List<OrderDTO> convertListToOrderDTO(List<Order> orderList) {
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    public List<Order> convertListToOrder(List<OrderDTO> orderDTOList) {
        return modelMapper.map(orderDTOList, new TypeToken<List<Order>>() {
        }.getType());
    }

    public ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product convertToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public List<ProductDTO> convertListToProductDTO(List<Product> productList) {
        return modelMapper.map(productList, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }

    public List<Product> convertListToProduct(List<ProductDTO> productDTOList) {
        return modelMapper.map(productDTOList, new TypeToken<List<Product>>() {
        }.getType());
    }
}
