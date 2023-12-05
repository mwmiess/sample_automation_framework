package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement cartHeaderTitle = driver.findElement(By.xpath("//h1[contains(text(),'Cart')]"));
    public By cartItems = By.xpath("//div[contains(@class,'cartItem') and @data-itemnumber]");
    public By deleteCartItemBtn = By.xpath("//div[@class='itemDelete']/button");
    public By emptyCart = By.xpath("//div[@class='cartEmpty']");

    public boolean verifyItemsInCart() {
        waitForElement(cartHeaderTitle);
        try {
            return !driver.findElement(emptyCart).isDisplayed();
        } catch (NoSuchElementException ignore) {
            waitForElement(cartItems);
        } return true;
    }

    public void deleteCartItem() {
        driver.findElement(deleteCartItemBtn).click();
        waitForElement(emptyCart);
    }
}
