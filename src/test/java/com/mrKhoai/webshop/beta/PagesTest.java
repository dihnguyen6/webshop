package com.mrKhoai.webshop.beta;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {WebConfig.class})
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureMockMvc
public class PagesTest {

    @Autowired
    private MockMvc mockMvc;

    private MockHttpSession mhs;

    @Before
    public void init() {
        mhs = new MockHttpSession();
    }

    @Test
    public void testLandingPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));
    }

    @Test
    public void testProductPage() throws Exception {
        mockMvc.perform(get("/product").session(mhs))
                .andExpect(status().isOk());
    }
}
