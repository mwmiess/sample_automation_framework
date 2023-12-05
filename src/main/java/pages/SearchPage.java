package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement searchTitle = driver.findElement(By.xpath("//h1[@class='page-header search--title']"));

    public List<WebElement> productContainers = driver.findElements(By.xpath("//div[@id='ProductBoxContainer']"));
    public By productContainerTitle = By.xpath(".//a[@data-testid='itemLink']");
    public By productItemAddToCartBtn = By.xpath(".//input[@data-testid='itemAddCart']");

    // Cart Popup //
    public By cartPopup = By.xpath("//div[@data-role='notification']");
    public By cartPopupViewCartBtn = By.xpath("//div[@class='notification__action']/a[contains(@class,'btn-primary')]");

    public int getNumberOfResults() {
        return productContainers.size();
    }

    public void addFinalProductToCart() {
        WebElement finalElement = productContainers.get(getNumberOfResults()-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(finalElement).perform();

        finalElement.findElement(productItemAddToCartBtn).click();
        finalElement.findElement(productItemAddToCartBtn).click();
    }

    public void viewCartFromPopup() {
        waitForElement(cartPopup);
        driver.findElement(cartPopupViewCartBtn).click();
    }
}
