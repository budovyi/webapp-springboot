package com.budovyy.controller;

import com.budovyy.model.Category;
import com.budovyy.service.CategoryService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {


    private MockMvc mockMvc;



    private CategoryController categoryController = new CategoryController();

    @MockBean
    private CategoryService categoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void init () {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testThatGetByIdShouldReturnCategory() throws Exception {
        Long categoryId = 1L;
        Category category = new Category(1L, "Shoes", "Best ever shoes", Collections.emptyList());
        String categoryJson = objectMapper.writeValueAsString(category);

        mockMvc.perform(get("/category/{categoryId}",categoryId))
                .andExpect(status().isOk())
                .andExpect(content().json(categoryJson));

    }


}