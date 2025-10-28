package automation.exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public WebDriver getDriverInstance() {
        ChromeOptions options = new ChromeOptions();

        // 🔹 Основні аргументи браузера
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");

        // 🔹 Повне вимкнення автозаповнення, паролів і збереження адрес
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("autofill.address_enabled", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 🔹 У CI (CircleCI) зазвичай використовують headless режим
        if (System.getenv("CI") != null) {  // автоматично визначає запуск у CI
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }
}
