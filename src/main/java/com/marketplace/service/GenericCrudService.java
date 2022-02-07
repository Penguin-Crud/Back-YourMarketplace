package com.marketplace.service;

import java.io.Serializable;
import java.util.List;


public interface GenericCrudService<T, Pk extends Serializable> {
     T save(T t);

     T get(Pk id);

     List<T> getAll();

}
