package git.pageObject;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class GitStepsPage {

    static WebDriver driver = new FirefoxDriver();
    private static Dotenv dataEnv;

    public static Dotenv getDataEnv() {
        return dataEnv;
    }

    public static void navigateToGitPage() {
        String baseUrl = "http://github.com/";
        driver.get(baseUrl);
    }

    public static void loginToGit() {
        String username = getDataEnv().get("USERNAME");
        String password = getDataEnv().get("PASSWORD");

        driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    public static void clickButton(String buttonName) {
        switch (buttonName) {
            case "akun":
                driver.findElement(By.xpath("//summary[contains(@aria-label,'View profile and more')]")).click();
                break;
            case "your gists":
                driver.findElement(By.xpath("//a[contains(@href,'https://gist.github.com/mine')]")).click();
                break;
            case "create a gist":
                driver.findElement(By.xpath("//a[contains(text(),'Create a gist')]")).click();
                break;
            case "create public gist":
                driver.findElement(By.name("gist[public]")).click();
                break;
            case "Edit":
                driver.findElement(By.xpath("//a[contains(@aria-label,'Edit this Gist')]")).click();
                break;
            case "Update public gist":
                driver.findElement(By.xpath("//button[contains(text(),'Update public gist')]")).click();
                break;
            case "Delete":
                driver.findElement(By.xpath("//button[contains(@aria-label,'Delete this Gist')]")).click();
                break;
            case "OK":
                Alert alert = driver.switchTo().alert();
                alert.accept();
                break;
            default:
                break;
        }
    }

    public static void typeGistDescription() {
        driver.findElement(By.name("gist[description]")).sendKeys("Testing");
    }

    public static void typeGistFileName() {
        driver.findElement(By.name("gist[contents][][name]")).sendKeys("testing.txt");
    }

    public static void typeContentGist() {
        WebElement contentInput = driver.findElement(By.className("CodeMirror"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].CodeMirror.setValue('Coba Test');", contentInput);
    }

    public static void isNewGistPublicExist() {
        WebElement elem = driver.findElement(By.xpath("//a[contains(text(),'testing.txt')]"));
        Assert.assertEquals("Failed to create Public Gist", true, (elem != null));
    }

    public static void clickOnListGists() {
        driver.findElement(By.xpath("//strong[contains(text(),'testing.txt')]")).click();
    }

    public static void editGistDesc() {
        driver.findElement(By.name("gist[description]")).sendKeys("Testing Update");
    }

    public static void isRedirectToUpdateGist() {
        WebElement elem = driver.findElement(By.xpath("//div[contains(text(),'TestingTesting Update')]"));
        Assert.assertEquals("Failed to create Public Gist", true, (elem != null));
    }

    public static void showListOfGists() {
        if (driver.findElement(By.xpath("//h3[contains(text(),'You don’t have any gists yet.')]")).isDisplayed()) {
            System.out.println("You don't have any existing Gist");
        } else {
            System.out.println("You have Gist");
        }
    }
}
