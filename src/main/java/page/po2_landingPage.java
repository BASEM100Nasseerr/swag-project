package page;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class po2_landingPage {
    private static List<WebElement> allProducts;
    private static List<WebElement> selectedProducts;
    private final By addToCardForAllProduct = By.xpath("//button[class]");
    private final By numberOfProductsOnCartIcon = By.className("shopping_cart_badge");
    private final By numberOfSelected = By.xpath("//button[.='remove']");

    private final WebDriver driver;

    public po2_landingPage(WebDriver driver) {
        this.driver = driver;
    }

    public po2_landingPage addAllProduct() {
        driver.findElement(addToCardForAllProduct);
        for (int i = 1; i <= allProducts.size(); i++) {
            By addToCardForAllProduct = By.xpath("(//button[class])[" + i + "]");
            Utility.clickingOnElement(driver, addToCardForAllProduct);
        }
        return this;
    }

    public String getNumberOfProductOnIcon() {
        try {
            return Utility.getText(driver, numberOfProductsOnCartIcon);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }

    }

    public String getNumberOfSelectedProducts() {
        try {
            selectedProducts = driver.findElements(numberOfSelected);
            return String.valueOf(selectedProducts.size());
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }

    }

    public boolean comparingNumberOfSelectedProductsWithCart() {
        return getNumberOfProductOnIcon().equals(getNumberOfSelectedProducts());
    }
}