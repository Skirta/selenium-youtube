package automation.exercise.models;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.BasePage;
import lombok.*;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductInCart {
    private WebElement image;
    private WebElement name;
    private String nameAsText;
    private String category;
    private String price;
    private String quantity;
    private String totalPrice;
    private WebElement deleteButton;

    private final Waiter waiter = new Waiter(BasePage.getDriver());
}
