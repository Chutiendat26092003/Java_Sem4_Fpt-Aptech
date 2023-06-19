package org.aptech.t2109e.repo;

import org.aptech.t2109e.impl.JpaExecutorImpl;
import org.aptech.t2109e.test.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> gets();
}
