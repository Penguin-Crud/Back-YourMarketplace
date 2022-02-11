package com.marketplace.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketplace.model.Product;
import com.marketplace.service.ProductCrudServiceImp;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductControllerTest.class)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ProductCrudServiceImp productCrudServiceImp;

    Product RECORD_1 = new Product(
            1,
            "Jaumne",
            "http://imagen.png",
            255,
            "Esto es una producto mockeado, si esta refriado",
            "switch"
    );
    Product RECORD_2 = new Product(
            2,
            "Jepeto",
            "http://imagen.png",
            255,
            "Esto es una producto2 mockeado, si esta refriado",
            "playFive"
    );

    @Test
    public void getAll() throws Exception {
        List<Product> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        Mockito.when( productCrudServiceImp.getAll() )
                .thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
                //.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                //.andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Jepeto"))
        );
    }
}