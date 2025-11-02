package automation.exercise.models;

import automation.exercise.components.ProductAddedToCardModal;
import automation.exercise.helpers.Waiter;
import automation.exercise.pages.BasePage;
import automation.exercise.pages.ProductDetailsPage;
import lombok.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductCard {
    private WebElement image;
    private String price;
    private String name;
    private String category;
    private String quantity;
    private String totalPrice;
    private WebElement addToCartButton;
    private WebElement addToCartOverlayButton;
    private WebElement viewProductButton;
    private final Waiter waiter = new Waiter(BasePage.getDriver());

    public ProductDetailsPage clickViewProductButton(){
        this.viewProductButton.click();
        return new ProductDetailsPage();
    }

    public ProductAddedToCardModal clickAddToCardButton() {
        Actions actions = new Actions(BasePage.getDriver());
        actions.moveToElement(this.addToCartButton).pause(500).perform();
        waiter.waitUntilElementClicable(this.addToCartOverlayButton).click();
        return new ProductAddedToCardModal();
    }
}
