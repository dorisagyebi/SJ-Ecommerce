import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class login {
    public static WebDriver driver;
    static String logo_name = "Swag Labs";

    public static void visitPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    public static void loginPage() {
        String username = "standard_user";
        String password = "secret_sauce";
        String inventory_url = "inventory";

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("saucedemo"), "The URL does not contain 'saucedemo'");


        WebElement logo = driver.findElement(By.cssSelector(".login_logo"));
        Assert.assertTrue(logo.getText().contains(logo_name), "Logo is not correct");
        logo.isDisplayed();

        WebElement userNameTextField = driver.findElement(By.cssSelector("[data-test=\"username\"]"));
        userNameTextField.sendKeys(username);

        WebElement passWordTextField = driver.findElement(By.cssSelector("[data-test=\"password\"]"));
        passWordTextField.sendKeys(password);

        WebElement submitBtn = driver.findElement(By.cssSelector("[data-test=\"login-button\"]"));
        submitBtn.click();

        String inventory = driver.getCurrentUrl();
        Assert.assertTrue(Objects.requireNonNull(inventory).contains(inventory_url), "Title is not correct");

        System.out.println("Login successful");

    }

    public static void getNumberOfItemInTheInventoryPage() {
        WebElement logo = driver.findElement(By.cssSelector(".app_logo"));
        Assert.assertTrue(logo.getText().contains(logo_name), "Logo is not correct");
        logo.isDisplayed();

        //get the total number of inventory
        List <WebElement> totalNumberOfInventories = driver.findElements(By.cssSelector("[data-test=\"inventory-item\"]"));
        int total = totalNumberOfInventories.size();
        System.out.println(total);
        System.out.println("Test passed!");
    }

    public static void getNamesOfAllTheProduct() {
        List<WebElement> namesOfAllItems = driver.findElements(By.cssSelector("[data-test=\"inventory-item-name\"]"));
        for (WebElement item : namesOfAllItems) {
            if(!namesOfAllItems.isEmpty()) {
                System.out.println(item.getText());
            }else System.out.println("no Item Found!");
        }
        System.out.println("Test passed!");
    }

        public static void getNameOfFirstAndLastInventory() {
            String firstItem = "Sauce Labs Backpack";
            String lastItem = "Test.allTheThings() T-Shirt (Red)";

            List <WebElement> namesOfAllItems = driver.findElements(By.cssSelector("[data-test=\"inventory-item-name\"]"));
            if(!namesOfAllItems.isEmpty()) {
                String firstName = namesOfAllItems.getFirst().getText();
                String lastName = namesOfAllItems.getLast().getText();
                Assert.assertTrue(firstName.contains(firstItem), "First name is not correct");
                Assert.assertTrue(lastName.contains(lastItem), "Last name is not correct");
            }
            System.out.println("Test passed!");
        }

        public static void getTopThreeHighestProductPrice() {
            List <WebElement> priceElements = driver.findElements(By.cssSelector("[data-test=\"inventory-item-price\"]"));

            // Create an array to store the prices
            Double[] prices = new Double[priceElements.size()];

            // Extract the price text, convert to Double, and store it in the prices array
            for (int i = 0; i < priceElements.size(); i++) {
                String priceText = priceElements.get(i).getText().replace("$", "");  // Assuming prices have a "$" symbol, remove it

                try {
                    prices[i] = Double.parseDouble(priceText);  // Convert the price text to a Double
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format found at index " + i + ": " + priceText);
                    prices[i] = 0.0;  // Assign a default value in case of an invalid format
                }
            }

            // Filter out any null values or handle the case where prices[i] could be null
            prices = Arrays.stream(prices).filter(price -> price != null).toArray(Double[]::new);

            // Sort the prices in descending order
            Arrays.sort(prices, Collections.reverseOrder());

            // Get the top 3 prices
            Double[] topThree = Arrays.copyOfRange(prices, 0, Math.min(3, prices.length));

            // Print the top 3 prices
            System.out.println("Top 3 prices are: " + Arrays.toString(topThree));

            System.out.println("Test passed!");
        }

    public static void main(String[] args) {
        visitPage();
        loginPage();
        getNumberOfItemInTheInventoryPage();
        getNamesOfAllTheProduct();
        getNameOfFirstAndLastInventory();
        getTopThreeHighestProductPrice();
        driver.quit();
    }
}

