package com.medicine.managemnt.medicinemanagement.Configurations;

import com.medicine.managemnt.medicinemanagement.Constants.LoggedInDetails;
import com.medicine.managemnt.medicinemanagement.IServices.*;
import com.medicine.managemnt.medicinemanagement.Services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplictionConfiguration {

    @Bean
    public ICustomerService getCustomerServicebean(){
        return new CustomerService();
    }

    @Bean
    public ILoginService getLoginService(){
        return new LoginService();
    }

    @Bean
    public LoggedInDetails getLoggedInCustomerDetails(){
        return new LoggedInDetails();
    }

    @Bean
    public IProductService getProductService(){
        return new ProductService();
    }

    @Bean
    public ICartService getCartService(){
        return new CartService();
    }

    @Bean
    public IOrderService getOrderService(){
        return new OrderService();
    }

}
