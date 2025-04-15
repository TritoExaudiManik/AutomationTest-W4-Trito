package com.Trito.AutomationT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> products;

    @FindBy(css = ".btn_inventory")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public boolean isProductListDisplayed() {
        return products.size() > 0;
    }

    public void addFirstProductToCart() {
        // Delay 5 menit sebelum klik tombol add to cart
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addToCartButton.click();
    }

    public String getCartBadgeText() {
        return cartBadge.getText();
    }
}

