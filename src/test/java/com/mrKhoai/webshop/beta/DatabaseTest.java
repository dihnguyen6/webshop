package com.mrKhoai.webshop.beta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.objects.Catalog;
import com.mrKhoai.webshop.objects.Color;
import com.mrKhoai.webshop.objects.Customer;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
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
        

        /*Product product1 = new Product();
        product1.setProductNameEN("Big Table");
        product1.setProductNameDE("Großer Stuhl");
        product1.setProductDescriptionEN("unknown");
        product1.setProductDescriptionDE("unbekannt");
        Product product2 = new Product();
        product2.setProductNameEN("Small Table");
        product2.setProductNameDE("Kleiner Stuhl");
        product2.setProductDescriptionEN("unknown");
        product2.setProductDescriptionDE("unbekannt");

        Account account = new Account();
        account.setUsername("tester");
        account.setPassword("testpassword");*/
    }

    @Test
    public void catalogTest() {
        ProductType [] productTypes = new ProductType[7];
        for (int i = 0; i < productTypes.length; ++i) {
            productTypes[i] = new ProductType();
        }
        productTypes[0].setProductTypeNameEN("2-Seater Sofas");
        productTypes[0].setProductTypeNameDE("2-Sitzer-Sofas");
        productTypes[1].setProductTypeNameEN("3-Seater Sofas");
        productTypes[1].setProductTypeNameDE("3-Sitzer-Sofas");
        productTypes[2].setProductTypeNameEN("Corner Couch");
        productTypes[2].setProductTypeNameDE("Ecksofas");
        productTypes[3].setProductTypeNameEN("Stool");
        productTypes[3].setProductTypeNameDE("Hocker");
        productTypes[4].setProductTypeNameEN("Bench");
        productTypes[4].setProductTypeNameDE("Bänke");
        productTypes[5].setProductTypeNameEN("Dining Tables");
        productTypes[5].setProductTypeNameDE("Esstische");
        productTypes[6].setProductTypeNameEN("Coffee Tables");
        productTypes[6].setProductTypeNameDE("Couchtische");
        for (int i = 0; i < productTypes.length; ++i) {
            productTypeRepository.save(productTypes[i]);
        }

        Catalog [] catalogs = new Catalog[7];
        for (int i = 0; i < catalogs.length; ++i) {
            catalogs[i] = new Catalog();
        }
        catalogs[0].setCatalogNameEN("Sofa");
        catalogs[0].setCatalogNameDE("Sofa");
        catalogs[1].setCatalogNameEN("Armchair");
        catalogs[1].setCatalogNameDE("Sessel");
        catalogs[2].setCatalogNameEN("Bed");
        catalogs[2].setCatalogNameDE("Betten");
        catalogs[3].setCatalogNameEN("Table");
        catalogs[3].setCatalogNameDE("Tische");
        catalogs[4].setCatalogNameEN("Chair");
        catalogs[4].setCatalogNameDE("Stühle");
        catalogs[5].setCatalogNameEN("Accessories");
        catalogs[5].setCatalogNameDE("Zubehör");
        catalogs[6].setCatalogNameEN("Sale");
        catalogs[6].setCatalogNameDE("Angebot");

        Set<ProductType> [] productTypeSet = new Set[3];
        productTypeSet[0] = catalogs[0].getProductTypes();
        productTypeSet[0].add(productTypes[0]);
        productTypeSet[0].add(productTypes[1]);
        productTypeSet[0].add(productTypes[2]);
        catalogs[0].setProductTypes(productTypeSet[0]);
        /*catalogRepository.save(catalogs[0]);*/
        productTypeSet[1] = catalogs[1].getProductTypes();
        productTypeSet[1].add(productTypes[3]);
        productTypeSet[1].add(productTypes[4]);
        catalogs[1].setProductTypes(productTypeSet[1]);
        /*catalogRepository.save(catalogs[1]);
        catalogRepository.save(catalogs[2]);*/
        productTypeSet[2] = catalogs[3].getProductTypes();
        productTypeSet[2].add(productTypes[5]);
        productTypeSet[2].add(productTypes[6]);
        catalogs[3].setProductTypes(productTypeSet[2]);
        /*catalogRepository.save(catalogs[3]);
        catalogRepository.save(catalogs[4]);
        catalogRepository.save(catalogs[5]);
        catalogRepository.save(catalogs[6]);*/
        for (int i = 0; i < catalogs.length; ++i) {
            catalogRepository.save(catalogs[i]);
        }
        
        Iterator<Catalog> catalogIterator = catalogRepository.findAll().iterator();
        Catalog [] newCatalogs = new Catalog[7];
        for ( int i = 0; i < newCatalogs.length; ++i) {
            newCatalogs[i] = new Catalog();
        }
        int j = 0;
        while (catalogIterator.hasNext()) {
            Catalog catalog = catalogIterator.next();
            newCatalogs[j] = catalog;
            j++;
        }
        assertThat(newCatalogs[0].getCatalogNameEN(), equalTo("Sofa"));
    }

    @Test
    public void ProductTest() {
        Color [] colors = new Color[7];
        for (int i = 0; i < colors.length; ++i) {
            colors[i] = new Color();
        }
        colors[0].setColorName("white");
        colors[1].setColorName("black");
        colors[2].setColorName("red");
        colors[3].setColorName("green");
        colors[4].setColorName("blue");
        colors[5].setColorName("wood");
        colors[6].setColorName("beton");
        for (int i = 0; i < colors.length; ++i) {
            colorRepository.save(colors[i]);
        }

        Random random = new Random();
        List<ProductType> productTypeList = new ArrayList<>();
        Iterator<ProductType> ptList = productTypeRepository.findAll().iterator();
        while (ptList.hasNext()) {
            ProductType productType = ptList.next();
            productTypeList.add(productType);
            System.out.println(productType.toString());
        }

        Product [] products = new Product[100];
        for (int i = 0; i < products.length; ++i) {
            products[i] = new Product();
            int tmp = random.nextInt(3);
            Set<ProductType> typeSet = new HashSet<>();
            Set<Color> colorSet = new HashSet<>();
            for (int j = 0; j < tmp + 1; ++j) {
                ProductType temp = productTypeList.get(random.nextInt(7));
                if (!typeSet.contains(temp)) {
                    typeSet.add(temp);
                }
                Color color = colors[random.nextInt(7)];
                if (!colorSet.contains(color)) {
                    colorSet.add(color);
                }
            }
            products[i].setProductTypes(typeSet);
            products[i].setColors(colorSet);
            products[i].setProductNameDE(TestFunction.randomString());
            products[i].setProductNameEN(TestFunction.randomString());
            products[i].setProductDescriptionDE(TestFunction.randomString());
            products[i].setProductDescriptionEN(TestFunction.randomString());
            System.out.println(products[i].toString());
        }

        /*productRepository.save(products[0]);
        productRepository.save(products[1]);*/

        for (int i = 0; i < products.length; ++i) {
            productRepository.save(products[i]);
        }

        Iterator<Product> productIterator = productRepository.findAll().iterator();
        List<Product> productList = new ArrayList<>();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            productList.add(product);
        }
        assertThat(productList.get(0).getProductNameEN(), equalTo(products[0].getProductNameEN()));
    }
}
