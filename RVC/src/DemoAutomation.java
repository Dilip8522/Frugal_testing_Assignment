import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

public class DemoAutomation {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        
        // Generate a unique timestamp for filenames
        Date currentDate = new Date();
        String screenshotfilename = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(currentDate);
        System.out.println("Timestamp for screenshot: " + screenshotfilename);

        // Take screenshot after page load
        takeScreenshot(driver, screenshotfilename + "_page_load.png");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
        usernameField.sendKeys("Admin");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
        passwordField.sendKeys("admin123");

        // Take screenshot after entering login credentials
        takeScreenshot(driver, screenshotfilename + "_login_credentials.png");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        loginButton.click();

        WebElement pimTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")));
        pimTab.click();

        WebElement addEmployeeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button/i")));
        addEmployeeButton.click();

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")));
        firstNameField.sendKeys("raju");

        WebElement middleNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")));
        middleNameField.sendKeys("charan");

        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")));
        lastNameField.sendKeys("dagu");

        WebElement createLoginDetailsCheckbox = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
        if (!createLoginDetailsCheckbox.isSelected()) {
            createLoginDetailsCheckbox.click();
        }

        WebElement usernameEmpField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        usernameEmpField.sendKeys("rajucharan123");

        WebElement passwordEmpField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
        passwordEmpField.sendKeys("rajucharan123");

        WebElement confirmPasswordEmpField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
        confirmPasswordEmpField.sendKeys("rajucharan123");

        // Take screenshot after entering employee details
        takeScreenshot(driver, screenshotfilename + "_employee_details.png");

        WebElement saveEmployeeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")));
        saveEmployeeButton.click();

        WebElement adminTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
        adminTab.click();

        WebElement userManagementTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")));
        userManagementTab.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
        addButton.click();

        WebElement userRoleField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")));
        userRoleField.click();
        WebElement adminUserRoleField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")));
        adminUserRoleField.sendKeys("admin");

        WebElement employeeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")));
        employeeNameField.sendKeys("raju charan dagu");

        WebElement statusField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")));
        statusField.click();
        WebElement enabledStatusField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
        enabledStatusField.sendKeys("Enabled");

        WebElement uniqueUsernameField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        uniqueUsernameField.sendKeys("rajucharanid");

        WebElement userPasswordField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        userPasswordField.sendKeys("rajucharan123");

        WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        confirmPasswordField.sendKeys("rajucharan123");

        // Take screenshot after entering user details
        takeScreenshot(driver, screenshotfilename + "_user_details.png");

        WebElement saveUserButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveUserButton.click();

        WebElement profileMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/img")));
        profileMenu.click();

        // Take screenshot after profile menu click
        takeScreenshot(driver, screenshotfilename + "_profile_menu.png");

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")));
        logoutButton.click();


        WebElement usernameLoginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
        usernameLoginField.sendKeys("rajucharanid");

        WebElement passwordLoginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
        passwordLoginField.sendKeys("rajucharan123");

        // Take screenshot after re-entering login credentials
        takeScreenshot(driver, screenshotfilename + "_relogin_credentials.png");

        WebElement loginButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        loginButton2.click();

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String filename) throws Exception {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots//" + filename));
    }
}
