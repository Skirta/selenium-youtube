package automation.exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public WebDriver getDriverInstance(){
        return new ChromeDriver();
    }
}
