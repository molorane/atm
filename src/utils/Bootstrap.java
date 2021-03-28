package utils;

import repository.CustomerRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Bootstrap {

    public static void createFiles(){
        createCustomerHeading();
    }

    private static void addHeadings(Path path, String heading){
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            writer.append(heading);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void createCustomerHeading(){
        Path newFilePath = AtmUtils.getRepoDirectory(CustomerRepository.CUSTOMER_FILE);
        String customerHeading = "cid, id, firstName, lastName, dateOfBirth, gender, email, address ";
        addHeadings(newFilePath, customerHeading);
    }
}
