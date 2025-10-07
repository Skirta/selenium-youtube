package automation.exercise.models;

import automation.exercise.pages.ProductDetailsPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCard {
    private WebElement image;
    private String price;
    private String name;
    private WebElement addToCardButton;
    private WebElement viewProductButton;

    public ProductDetailsPage cliclViewProductButton(){
        this.viewProductButton.click();
        return new ProductDetailsPage();
    }

}
