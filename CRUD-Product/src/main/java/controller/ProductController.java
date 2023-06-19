package controller;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.entity.Product;
import com.example.crudproduct.repository.imp.ProductRepositoryImp;
import com.example.crudproduct.service.ProductService;
import com.example.crudproduct.service.imp.ProductServiceImpl;
import org.apache.taglibs.standard.lang.jstl.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

@WebServlet(name = "productServlet", value = "/products")
public class ProductController extends HttpServlet {
    //private static Logger logger = LogManager.getLogger(ProductController.class);

    ProductService productService = new ProductServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("jsp/product-list.jsp");

        List<ProductDto> products = productService.getListProduct();

        //ProductRepositoryImp productRepo = new ProductRepositoryImp();

        //List<Product> productList = productRepo.findall();
        request.setAttribute("products", products);

        view.forward(request, response);
    }
}