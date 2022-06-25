package com.rog.teach.aop.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.rog.teach.aop.advice.TrackExecutionTime;
import com.rog.teach.aop.model.Product;
import com.rog.teach.aop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired(required = false)
    private ProductRepository repository;

    @PostConstruct
    public void initDB() {
        List<Product> list=new ArrayList<>();
        for(int i=1;i<=100;i++) {
            list.add(new Product(i, "product"+i, new Random().nextInt(2000)));
        }
        repository.saveAll(list);
    }

    @TrackExecutionTime
    public List<Product> addProduct(List<Product> products) {
        return repository.saveAll(products);
    }

    @TrackExecutionTime
    public List<Product> findAllProducts() {
        return repository.findAll();
    }
}