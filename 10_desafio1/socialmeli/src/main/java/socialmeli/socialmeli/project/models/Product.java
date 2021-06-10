package socialmeli.socialmeli.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Comparable<Product>{
  private Integer productId;
  private String productName;
  private String type;
  private String brand;
  private String color;
  private String notes;


  @Override
  public int compareTo(Product o) {
    return getProductName().compareTo(o.getProductName());
  }

}


