package base.service;

import base.model.Customer;

public interface ICustomerService extends IGenerateService<Customer>{
    void save(Customer customer);
}
