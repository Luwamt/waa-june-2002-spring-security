package spring_security_lab6.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_security_lab6.dto.ProductDto;
import spring_security_lab6.entity.Product;
import spring_security_lab6.repository.ProductRepository;
import spring_security_lab6.service.ProductService;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> findAll() {
        var products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public ProductDto findById(Long id) {
        var product  = productRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("ProductDto with id %s does not exits",id)));
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(Double minPrice) {
        var products = productRepository.findAllByPriceGreaterThan(minPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public List<ProductDto> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice) {
        var products = productRepository.findByCategoryNameAndPriceLessThan(categoryName,maxPrice);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }

    @Override
    public List<ProductDto> findAllByNameContains(String keyword) {
        var products = productRepository.findAllByNameContains(keyword);
        Type listType = new TypeToken<List<ProductDto>>(){}.getType();
        return modelMapper.map(products,listType);
    }
}
