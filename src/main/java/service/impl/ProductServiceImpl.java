package service.impl;

import helper.ServiceHelper;
import model.entity.Product;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;
import util.InputUtil;

import java.util.List;

import static helper.ServiceHelper.fillProduct;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public void showAllProduct() {
        productRepository.findAllProducts()
                .forEach(System.out::println);
    }

    @Override
    public Product findById(String title, boolean isProductService) {
        long id = InputUtil.getInstance().inputLong("Choose product id for " + title + ": ");
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));
        if (isProductService) {
            System.out.println(product);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product, String comment, int star) {

        product.addComment(comment);

        if (star > 5) {
            product.setStar((byte) 5);
        } else {
            product.setStar((byte) star);
        }

        productRepository.updateProduct(product);

    }

    @Override
    public void saveProduct() {
        Product product = fillProduct();

        productRepository.saveProduct(product);
    }

    @Override
    public void updateProductForAdmin() {
        showAllProduct();

        long id = InputUtil.getInstance().inputLong("Enter the product id for update: ");
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));

        Product updateProduct = ServiceHelper.updateProduct(product);

        productRepository.updateProduct(updateProduct);


    }

    @Override
    public void deleteProduct() {
        showAllProduct();

        long id = InputUtil.getInstance().inputLong("Enter the product id for delete: ");

        Product product = productRepository.findById(id).orElseThrow(() -> new  ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));
        product.setStatus(false);

        productRepository.updateProduct(product);

    }

    @Override
    public void findByName() {
        String name = InputUtil.getInstance().inputString("Enter the product name: ");
        List<Product> products = productRepository.findByName(name);
        products
                .forEach(System.out::println);

    }

    @Override
    public void decreaseRemainCount(List<Product> products) {

        products.stream()
                .peek(Product::decreaseRemainCount)
                .forEach(productRepository::updateProduct);


    }
}
