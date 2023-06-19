import dao.ProductDao;
import entity.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDao dao = new ProductDao();
        int choose = 0;
        while (true){
            System.out.println("\n\n\n1.List Product");
            System.out.println("2.Add Product");
            System.out.println("3.Update Product");
            System.out.println("4.Delete Product");
            System.out.println("5.Exit\n\n");
            System.out.println("Choose:");
            choose = Integer.parseInt(scanner.nextLine());
            if (choose == 5){
                System.out.println("Bye Bye");
                break;
            }
            switch (choose){
                case 1:
                    dao.findAll().forEach(product -> System.out.println(product));
                    break;
                case 2:
                    Product product = new Product();
                    System.out.println("ProductName:");
                    product.setProductName(scanner.nextLine());
                    System.out.println("Quantity:");
                    product.setQuantity(Integer.parseInt(scanner.nextLine()));
                    System.out.println("ProductId:");
                    product.setProductId(Integer.parseInt(scanner.nextLine()));


                    if (dao.add(product)){
                        System.out.println("Successfully");
                    }else {
                        System.out.println("Create Failed! try again");
                    }
                    break;
                case 3:
                    System.out.println("Enter Id to Update:");
                    Product p = dao.findById(Integer.parseInt(scanner.nextLine()));
                    if(p==null){
                        System.out.println("Not Found");
                        break;
                    }
                    while (true){
                        System.out.println(p);
                        System.out.println("1.Update Product Name");
                        System.out.println("2.Update quantity");
                        System.out.println("3. Save");
                        int choice = Integer.parseInt(scanner.nextLine());
                        if(choice==1){
                            System.out.println("ProductName:");
                            p.setProductName(scanner.nextLine());
                        }
                        if (choice==2){
                            System.out.println("Quantity:");
                            p.setQuantity(Integer.parseInt(scanner.nextLine()));
                        }
                        if (choice==3){
                            dao.update(p);
                            System.out.println("Saved");
                            break;
                        }
                    }

                    break;

                case 4:
                    System.out.println("Enter Id To Delete: ");
                    if(dao.delete(Integer.parseInt(scanner.nextLine()))){
                        System.out.println("Delete Successfully");
                    }else {
                        System.out.println("Delete Fail Because Cannot Find This ProductID");
                    }
                    break;
            }

        }
    }
}
