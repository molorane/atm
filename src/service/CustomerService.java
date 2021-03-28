package service;

import customer.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomer(long id);
}
