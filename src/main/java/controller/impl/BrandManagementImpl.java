package controller.impl;

import controller.AdminManagement;
import controller.BrandManagement;
import model.enums.ExceptionEnums;
import model.exception.ApplicationException;
import service.BrandService;
import service.impl.BrandServiceImpl;
import util.MenuUtil;

public class BrandManagementImpl implements BrandManagement {

    @Override
    public void manage() {
        BrandService brandService = new BrandServiceImpl();
        AdminManagement adminManagement = new AdminManagementImpl();
        while (true){
            try {
                byte option = MenuUtil.brandMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        brandService.saveBrand();
                        break;
                    case 2:
                        brandService.findAll();
                        break;
                    case 3:
                        brandService.findById();
                        break;
                    case 4:
                        brandService.findByName();
                        break;
                    case 5:
                        brandService.updateBrand();
                        break;
                    case 6:
                        brandService.deleteBrand();
                        break;
                    case 7:
                        adminManagement.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
