package automation.exercise.models;

import automation.exercise.components.ProductAddedToCardModal;
import automation.exercise.helpers.Waiter;
import automation.exercise.pages.BasePage;
import automation.exercise.pages.ProductDetailsPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCard {
    private WebElement image;
    private String price;
    private String name;
    private WebElement addToCartButton;
    private WebElement addToCartOverlayButton;
    private WebElement viewProductButton;
    private final Waiter waiter = new Waiter(BasePage.getDriver());

    public ProductDetailsPage cliclViewProductButton(){
        this.viewProductButton.click();
        return new ProductDetailsPage();
    }

    public ProductAddedToCardModal cliclAddToCardButton() {
        Actions actions = new Actions(BasePage.getDriver());
        actions.moveToElement(this.addToCartButton).pause(500).perform();
        waiter.waitUntilElementClicable(this.addToCartOverlayButton).click();
        return new ProductAddedToCardModal();
    }
}
