package service.impl;

import helper.ServiceHelper;
import model.constant.Constant;
import model.entity.Brand;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import repository.BrandRepository;
import repository.impl.BrandRepositoryImpl;
import service.BrandService;
import util.InputUtil;

import java.util.Optional;

public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository = new BrandRepositoryImpl();

    @Override
    public void findAll() {
        System.out.println(brandRepository.findAll());
    }

    @Override
    public Brand findById() {
        long id = InputUtil.getInstance().inputLong("Enter the brand id: ");
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.orElseThrow(() -> new ApplicationException(ExceptionEnums.BRAND_NOT_FOUND));
    }

    @Override
    public void saveBrand() {
        Brand brand = ServiceHelper.fillBrand();

        brandRepository.saveBrand(brand);
        System.out.println(Constant.SAVED_SUCCESSFULLY);

    }

    @Override
    public void findByName() {
        String name = InputUtil.getInstance().inputString("Enter the brand name: ");
        Brand brand = brandRepository.findByName(name).orElseThrow(() -> new ApplicationException(ExceptionEnums.BRAND_NOT_FOUND));
        System.out.println(brand);
    }

    @Override
    public void updateBrand() {
        findAll();

        long id = InputUtil.getInstance().inputLong("Enter the id for update brand: ");
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.BRAND_NOT_FOUND));

        String name = InputUtil.getInstance().inputString("Enter the new description: ");
        brand.setDescription(name);

        brandRepository.updateBrand(brand);


    }

    @Override
    public void deleteBrand() {
        findAll();

        long id = InputUtil.getInstance().inputLong("Enter the delete category id: ");

        Brand brand = brandRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.BRAND_NOT_FOUND));
        brand.setStatus(false);
        brandRepository.updateBrand(brand);
    }
}
