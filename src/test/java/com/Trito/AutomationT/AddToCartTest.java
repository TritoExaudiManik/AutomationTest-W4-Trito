package com.Trito.AutomationT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.Trito.AutomationT.LoginPage;
import com.Trito.AutomationT.InventoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class AddToCartTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testAddProductToCart(){
        Assert.assertTrue(inventoryPage.isProductListDisplayed(), "Product list should be visible");
        inventoryPage.addFirstProductToCart();
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1", "Cart should show 1 item");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
