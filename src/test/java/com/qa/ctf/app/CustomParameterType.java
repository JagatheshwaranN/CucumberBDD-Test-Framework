package com.qa.ctf.app;

import com.qa.ctf.domain.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String productName) {
        return new Product(productName.replace("\"",""));
    }
}
