package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.objects.Account;
import com.mrKhoai.webshop.repositories.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestMySQLConfig.class)
@ActiveProfiles("test")
public class DatabaseTest {

    private MockMvc mvc;

    @Autowired
    AccountRepository accountRepository;

    @Before
    public void init() {
        Account account = new Account();
        account.setUsername("tester");
        account.setPassword("testpassword");
    }

    @Test
    public void accountTest() {
        Iterator<Account> listAccount = accountRepository.findAll().iterator();
        while (listAccount.hasNext()) {
            Account account = listAccount.next();
            Assert.assertThat(account.getUsername(), equalTo("tester"));
            Assert.assertThat(account.getPassword(), equalTo("testpassword"));
        }
        accountRepository.deleteAll();
    }
}
