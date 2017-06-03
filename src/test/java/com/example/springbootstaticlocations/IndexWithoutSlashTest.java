package com.example.springbootstaticlocations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.resources.static-locations=classpath:static2")
@AutoConfigureMockMvc
public class IndexWithoutSlashTest {

    protected static final String INDEX = "<html><head><title>test</title></head></html>";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCategories() throws Exception {

        mockMvc.perform(get("/index.html")).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().bytes(INDEX.getBytes()));

    }

}
