package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.objects.Account;
import com.mrKhoai.webshop.objects.Catalog;
import com.mrKhoai.webshop.objects.Product;
import com.mrKhoai.webshop.objects.ProductType;
import com.mrKhoai.webshop.repositories.AccountRepository;
import com.mrKhoai.webshop.repositories.BasketRepository;
import com.mrKhoai.webshop.repositories.BillRepository;
import com.mrKhoai.webshop.repositories.CatalogRepository;
import com.mrKhoai.webshop.repositories.ColorRepository;
import com.mrKhoai.webshop.repositories.CouponRepository;
import com.mrKhoai.webshop.repositories.CustomerRepository;
import com.mrKhoai.webshop.repositories.DeliveryRepository;
import com.mrKhoai.webshop.repositories.PaymentRepository;
import com.mrKhoai.webshop.repositories.ProductRepository;
import com.mrKhoai.webshop.repositories.ProductTypeRepository;
import com.mrKhoai.webshop.repositories.RoleRepository;
import com.mrKhoai.webshop.repositories.StaffRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EntityScan(basePackages = "com.mrKhoai.webshop.objects")
@EnableJpaRepositories(basePackages = "com.mrKhoai.webshop.repositories")
@TestPropertySource(locations="classpath:test.properties")
public class DatabaseTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BillRepository billRepository;

    @Autowired
    CatalogRepository catalogRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StaffRepository staffRepository;

    @Before
    public void init() {
        ProductType productType = new ProductType();
        productType.setProductTypeName("Tall Table");
        Catalog catalog1 = new Catalog();
        catalog1.setName("Garten");
        Catalog catalog2 = new Catalog();
        catalog2.setName("Kitchen");
        catalogRepository.save(catalog1);
        catalogRepository.save(catalog2);
        Set<ProductType> productTypeSet1 = catalog1.getProductTypes();
        productTypeSet1.add(productType);
        catalog1.setProductTypes(productTypeSet1);
        catalogRepository.save(catalog1);
        Set<ProductType> productTypeSet2 = catalog2.getProductTypes();
        productTypeSet2.add(productType);
        catalog2.setProductTypes(productTypeSet2);
        catalogRepository.save(catalog2);

        Product product1 = new Product();
        product1.setProductName("Big Table");
        Product product2 = new Product();
        product2.setProductName("Small Table");

        /*ProductType productType = new ProductType();
        productType.setProductTypeName("Table");
        Assert.assertThat(productType.getProductTypeName(), equalTo("Table"));
        ProductType newProductType = productTypeRepository.save(productType);
        Assert.assertThat(newProductType, equalTo(productType));
        productType = productTypeRepository.findById(newProductType.getProductTypeId()).get();
        Set<Catalog> catalogSet = productType.getCatalogs();
        catalogSet.add(catalog1);
        catalogSet.add(catalog2);
        Set<Product> productSet = productType.getProducts();
        productSet.add(product1);
        productSet.add(product2);
        productType.setCatalogs(catalogSet);
        productType.setProducts(productSet);
        productTypeRepository.save(productType);*/

        Account account = new Account();
        account.setUsername("tester");
        account.setPassword("testpassword");
    }

    @Test
    public void catalogTest() {
        Iterator<Catalog> listCatalog = catalogRepository.findAll().iterator();
        Catalog [] catalogs = new Catalog[2];
        int i = 0;
        while (listCatalog.hasNext()) {
            catalogs[i] = listCatalog.next();
            ++i;
        }
        Assert.assertThat(catalogs[0].getName(), equalTo("Garten"));
        //Assert.assertThat(catalogs[0].getProductTypes().size(), is(0));
        Assert.assertThat(catalogs[1].getName(), equalTo("Kitchen"));
        catalogRepository.deleteAll();
    }

    @Test
    public void productTypeTest() {
        Iterator<ProductType> listProductType = productTypeRepository.findAll().iterator();
        ProductType [] productTypes = new ProductType[1];
        //int i = 0;
        while (listProductType.hasNext()) {
            productTypes[0] = listProductType.next();
            //++i;
        }
        Assert.assertThat(productTypes[0].getProductTypeName(), equalTo("Tall Table"));
        //Assert.assertThat(catalogs[1].getName(), equalTo("Kitchen"));
        productTypeRepository.deleteAll();
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
