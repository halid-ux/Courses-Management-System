package mk.ukim.finki.wp.lab.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private WebElement username;
    private WebElement password;
    @FindBy(css = "button")
    private WebElement submit;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static LoginPage login(WebDriver driver)
    {
        get(driver,"/login");
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver,LoginPage.class);
    }
    public static CoursesPage doLogin(WebDriver driver,LoginPage loginPage,String username,String password)
    {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver,CoursesPage.class);
    }
//    public void assertUsername(WebDriver driver,String username)
//    {
//        Assert.assertEquals("username is not in header",username,driver.);
//    }
}
