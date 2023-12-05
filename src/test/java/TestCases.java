import graphql.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchPage;

public class TestCases extends BaseTest {

    @Test
    public void webstaurantStoreTest() {
        String searchQuery = "stainless work table",
            searchAssertion = "table";

        // Navigate to page
        getDriver().get(baseURL);

        MainPage mainPage = new MainPage(getDriver());
        Assert.assertTrue(mainPage.verifyPageLogo());

        // Input search query
        mainPage.clickSearchBar();
        mainPage.enterSearchQuery(searchQuery);

        // Check results all contain the word "Table" in the title
        Assert.assertTrue(mainPage.verifySearchList(searchAssertion));
        mainPage.clickSearchButton();

        // Add last item to cart
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.addFinalProductToCart();
        searchPage.viewCartFromPopup();

        // Empty Cart
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.verifyItemsInCart()); // Check to see if items are in cart

        cartPage.deleteCartItem();
        Assert.assertFalse(cartPage.verifyItemsInCart()); // Check to see if items were removed
    }



}
