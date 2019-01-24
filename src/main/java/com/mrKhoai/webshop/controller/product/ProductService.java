package com.mrKhoai.webshop.controller.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrKhoai.webshop.controller.ObjectService;
import com.mrKhoai.webshop.objects.*;
import com.mrKhoai.webshop.repositories.ProductRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements ObjectService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public boolean contains(int id) {
        return false;
    }

    /**
     *
     * @return all product as JSONArray
     * @throws JsonProcessingException
     * get all Product from Database
     * write native value into JSONObject
     * write all other value as JSONArray (only id)
     * put other value into JSONObject
     * put JSONObject to return JSONArray
     */
    @Override
    public String getAll() throws JsonProcessingException {
        List<Product> productList = productRepository.getAll();
        return getJSON(productList);
    }

    public String getByCatalog(String catalogId) {
        List<Product> productList = productRepository.getByCatalog(catalogId);
        return getJSON(productList);
    }

    public String getByProductType(String ptId) {
        List<Product> productList = productRepository.getByProductType(ptId);
        return getJSON(productList);
    }

    private String getJSON(List<Product> products) {
        JSONArray jsonArray = new JSONArray();
        for (Product product : products) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                JSONObject jsonObject = new JSONObject(mapper.writeValueAsString(product));

                //write list of product type
                JSONArray itemArray = new JSONArray();
                Set<ProductType> ptList = product.getProductTypes();
                for (ProductType pt : ptList) {
                    itemArray.put(pt.getProductTypeId());
                }
                jsonObject.put("product_type_list", itemArray.toString());

                //write list of color
                itemArray = new JSONArray();
                Set<Color> colorList = product.getColors();
                for (Color c : colorList) {
                    itemArray.put(c.getColorName());
                }
                jsonObject.put("color_list", itemArray.toString());

                //write list of basket
                itemArray = new JSONArray();
                Set<Basket> basketList = product.getBaskets();
                for (Basket b : basketList) {
                    itemArray.put(b.getBasketId());
                }
                jsonObject.put("basket_list", itemArray.toString());

                //write list of fotos
                itemArray = new JSONArray();
                Set<Foto> fotoList = product.getFotos();
                for (Foto f : fotoList) {
                    itemArray.put(Base64.getEncoder().encodeToString(f.getFotos()));
                }
                jsonObject.put("foto_list", itemArray.toString());

                jsonArray.put(jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return jsonArray.toString();
    }

    class NameComparator implements Comparator<Product> {
        public int compare(Product p1, Product p2) {
            return p1.getProductNameEN().compareTo(p2.getProductNameEN());
        }
    }

    class SellComparator implements Comparator<Product> {
        public int compare(Product p1, Product p2) {
            int s1 = productRepository.countSell(p1.getProductId());
            int s2 = productRepository.countSell(p2.getProductId());
            if (s1 == s2)
                return 0;
            else if (s1 > s2)
                return 1;
            else
                return -1;
        }
    }
}
