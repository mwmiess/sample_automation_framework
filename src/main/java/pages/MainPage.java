package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement webstaurantTitle = driver.findElement(By.xpath("//div[@data-testid='banner']//a[@aria-label='Homepage, WebstaurantStore' and not(contains(@class, 'lt:hidden'))]"));
    public List<WebElement> searchBar = driver.findElements(By.xpath("//div[@id='banner-search-group']//form[@id='searchForm']"));
    public By searchButton = By.xpath("//button[@type='submit']");
    public List<WebElement> listBoxResultsKeywords = driver.findElements(By.xpath("//li[@data-recommendation-type='keywords']//span[@class='result']"));
    public List<WebElement> listBoxResultsCategories = driver.findElements(By.xpath("//li[@data-recommendation-type='categories']//span[@class='result']"));

    public boolean verifyPageLogo() {
        return webstaurantTitle.isDisplayed();
    }

    public WebElement getSearchBar() {
        return searchBar.get(0);
    }

    public void clickSearchBar() {
        getSearchBar().click();
    }

    public void clickSearchButton() {
        getSearchBar().findElement(searchButton).click();
    }

    public void enterSearchQuery(String search) {
        WebElement searchInput = getSearchBar().findElement(By.xpath("//input[@type='text']"));
        searchInput.sendKeys(search);
    }

    public boolean verifySearchList(String assertion) {
        for (WebElement keywords : listBoxResultsKeywords) {
            if (!keywords.findElement(By.xpath("//mark[.]")).getText().contains(assertion))
                return false;
        }
        for (WebElement categories : listBoxResultsCategories) {
            if (!categories.getText().contains(assertion))
                return false;
        }
        return true;
    }
}
