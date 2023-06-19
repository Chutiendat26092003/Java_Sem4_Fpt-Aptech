package dao;

import entity.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private  static  String URL = "jdbc:mysql://localhost:3306/egift_shop";
    private  static  String USER = "root";
    private  static  String PASSWORD = "";
    private  static Connection CONNECTION =getCONNECTION();

    private  static  Connection getCONNECTION(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ProductDao() {
    }

    /**
     * Select List Student From DB
     * @return
     */
    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        try {
            ResultSet resultSet = CONNECTION.createStatement().executeQuery("select * from product" );
            while (resultSet.next()){
                Product product = new Product();
                product.setProductId(resultSet.getInt("productId"));
                product.setProductName(resultSet.getString("productName"));
                product.setQuantity(resultSet.getInt("quantity"));
                list.add(product);
            }
            resultSet.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    /**
     * get product by id
     * @param productId
     * @return result
     */
    public Product findById(int productId){
        for (Product product:findAll()){
            if (product.getProductId() == productId){
                return product;
            }
        }
        return  null;
    }

    /**
     * Add Product
     * @param product
     * @return status
     */
    public boolean add(Product product){
        try{
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("insert into product (productId,productName,quantity) values(?,?, ?);");
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.execute();
            preparedStatement.close();
            return  true;
        }catch (Exception e){
            System.out.println(product);
        }

        return false;
    }

    /**
     * Update Product
     * @param product
     * @return status
     */
    public boolean update(Product product){
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE product set productName=? , quantity=? WHERE productId=?");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setInt( 3, product.getProductId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Delete product by id
     * @param productId
     * @return status
     */
    public boolean delete(int productId){
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("DELETE FROM product WHERE productId=?");
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        //select all
//        for(Product product : dao.findAll()){
//            System.out.println(product);
//        }

        //add
//        Product product = new Product();
//        product.setProductName("Luong Hoang");
//        product.setProductId(5);
//        product.setQuantity(24);
//
//        if(dao.add(product)){
//            System.out.println("ADD Product Success");
//        }else {
//            System.out.println("ADD Fail");
//        }

        //find by id
//        System.out.println(dao.findById(1));

        //update
//        Product iphone6=dao.findById(4);
//        if( iphone6 != null){
//            iphone6.setQuantity(50);
//        }
//        if (dao.update(iphone6)){
//            System.out.println("Update Success");
//        }else {
//            System.out.println("Update Fail");
//        }

        //delete
//        if(dao.delete(5)){
//            System.out.println("Delete success");
//        }else {
//            System.out.println("Delete fail");
//        }
    }
}
