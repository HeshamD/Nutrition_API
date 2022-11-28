package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
//    private String query;
//    private int totalResults;
//    private String imageURL;
//    private String linkURL;
//    private String content;

    private String id;
    private String title;
    private String image;
    private String imageType;
}
