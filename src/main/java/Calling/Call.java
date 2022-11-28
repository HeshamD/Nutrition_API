package Calling;

import Validation.ValidateInput;
import lombok.Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class Call {
    public static String getFoodByName(String productName) {
        var query = ValidateInput.normalization(productName);
       try {
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/search?query="+query+"&offset=0&number=1"))
                   .header("X-RapidAPI-Key", "28ca9e41f4msh0a7cc03115bcc91p135a40jsne709641fb97c")
                   .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                   .method("GET", HttpRequest.BodyPublishers.noBody())
                   .build();
           HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

           //declarative programming style
           var result = response.body();
//           var res = result.split(",");
           return result;
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }
    public static void getFoodByName(){

    }
}
