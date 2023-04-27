package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
     WebElement Onesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement TshirtRed;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
     WebElement Bikelight;
    @FindBy(css = "#shopping_cart_container span")
    WebElement cart;
    @FindBy(id = "checkout")
    WebElement checkout;

    public InventoryPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String Cart() {
        return cart.getText();
    }

    public void Onesie() {
        Onesie.click();
    }

    public void Bikelight() {
        Bikelight.click();
    }

    public void TshirtRed() {
        TshirtRed.click();
    }

    public void ClickOnCart() {
        cart.click();
    }

    public void ClickCheckout() {
        checkout.click();
    }

    public void SortItemByText(String text) {
        Select drop = new Select(sortDropDown);
        drop.selectByVisibleText(text);

    }
}
