import customer.Customer;
import customer.Gender;
import repository.CustomerRepository;
import service.impl.CustomerServiceImpl;
import utils.AtmUtils;
import utils.Bootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.createFiles();
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        Customer customer = new Customer("20209029402492","Shoki", "Makhanatha", LocalDate.of(2000,5,5), Gender.FEMALE);
        customer.setAddress("Durban PMB");
        customer.setEmail("nomfundo@gmail.com");
        customerService.addCustomer(customer);
        Path path = AtmUtils.getRepoDirectory("customer.txt");
        try {
            Files.readAllLines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
