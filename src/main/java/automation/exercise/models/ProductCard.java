package automation.exercise.models;

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

}
