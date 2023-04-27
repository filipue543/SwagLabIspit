package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.CheckoutPage;
import pageObject.InventoryPage;
import pageObject.LoginPage;

public class InventoryTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void BeforeMethod() {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void SortingAndBuying() {
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.SortItemByText("Price (low to high)");
        inventoryPage.Onesie();
        inventoryPage.Bikelight();
        inventoryPage.TshirtRed();
        Assert.assertEquals(inventoryPage.Cart(), "3");
    }

    @Test
    public void ItemTotal() {
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.Onesie();
        inventoryPage.TshirtRed();
        inventoryPage.Bikelight();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickCheckout();
        checkoutPage.EnterFirstName("Filip");
        checkoutPage.EnterLastName("Radivojcevic");
        checkoutPage.EnterPostalCode("31000");
        checkoutPage.ClickContinue();
        checkoutPage.ItemTotal();
        Assert.assertEquals(checkoutPage.ItemTotal(), "Item total: $33.97");
    }

    @Test
    public void FinishingOrder() {
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.Onesie();
        inventoryPage.TshirtRed();
        inventoryPage.Bikelight();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickCheckout();
        checkoutPage.EnterFirstName("Filip");
        checkoutPage.EnterLastName("Radivojcevic");
        checkoutPage.EnterPostalCode("31000");
        checkoutPage.ClickContinue();
        checkoutPage.ClickFinish();
        checkoutPage.OrderCompleted();
        Assert.assertEquals(checkoutPage.OrderCompleted(), "Thank you for your order!");
    }
    @AfterMethod
    public void AfterMethod ()
    {
        driver.quit();
    }
}
