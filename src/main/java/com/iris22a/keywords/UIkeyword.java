package com.iris22a.keywords;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;

public class UIkeyword {

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public void openBrowser(String browserName) {
        System.out.println(browserName + " Method call to open browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications", "start-maximized");

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(option));
            System.out.println(browserName + " browser is launched successfully.");
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
    }

    public void launchUrl(String url) {
        driver.get().get(url);
    }

    public void closeBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public void switchToWindow(String byTitle) {
        String parentWindow = driver.get().getWindowHandle();
        Set<String> windows = driver.get().getWindowHandles();
        for (String window : windows) {
            if (driver.get().switchTo().window(window).getTitle().equals(byTitle)) {
                break;
            }
        }
    }

    public void enterText(String LocatorType, String LocatorValue, String text) {
        getWebElement(LocatorType, LocatorValue).sendKeys(text);
    }

    public void hitbutton(int keyCode) {
        Robot robo = null;
        try {
            robo = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robo.keyPress(keyCode);
        robo.keyRelease(keyCode);
    }

    public List<String> getTexts(String LocatorType, String LocatorValue) {
        List<WebElement> elements = getWebElements(LocatorType, LocatorValue);
        List<String> texts = new ArrayList<>();
        for (WebElement elmnt : elements) {
            texts.add(elmnt.getText());
        }
        return texts;
    }

    public void clickButton(String locatorType, String locatorValue) {
        getWebElement(locatorType, locatorValue).click();
    }

    public void getCalendarDate(String string) {
        driver.get().findElement(By.xpath("//input[@id='onward_cal']")).click();
    }

    public void maxWindow() {
        driver.get().manage().window().maximize();
    }

    public void mouseMove(String locatorType, String locatorValue) {
        Actions act = new Actions(driver.get());
        act.moveToElement(getWebElement(locatorType, locatorValue)).perform();
    }

    public WebElement getWebElement(String locatorType, String locatorValue) {
        WebElement element = null;
        if (locatorType.equalsIgnoreCase("xpath")) {
            element = driver.get().findElement(By.xpath(locatorValue));
        } else if (locatorType.equalsIgnoreCase("id")) {
            element = driver.get().findElement(By.id(locatorValue));
        } else if (locatorType.equalsIgnoreCase("name")) {
            element = driver.get().findElement(By.name(locatorValue));
        } else if (locatorType.equalsIgnoreCase("tagname")) {
            element = driver.get().findElement(By.tagName(locatorValue));
        } else if (locatorType.equalsIgnoreCase("class")) {
            element = driver.get().findElement(By.className(locatorValue));
        } else if (locatorType.equalsIgnoreCase("linktext")) {
            element = driver.get().findElement(By.linkText(locatorValue));
        } else if (locatorType.equalsIgnoreCase("partiallinktext")) {
            element = driver.get().findElement(By.partialLinkText(locatorValue));
        } else if (locatorType.equalsIgnoreCase("css")) {
            element = driver.get().findElement(By.cssSelector(locatorValue));
        }

        return element;
    }

    public List<WebElement> getWebElements(String locatorType, String locatorValue) {
        List<WebElement> elements = null;
        if (locatorType.equalsIgnoreCase("xpath")) {
            elements = driver.get().findElements(By.xpath(locatorValue));
        } else if (locatorType.equalsIgnoreCase("id")) {
            elements = driver.get().findElements(By.id(locatorValue));
        } else if (locatorType.equalsIgnoreCase("name")) {
            elements = driver.get().findElements(By.name(locatorValue));
        } else if (locatorType.equalsIgnoreCase("tagname")) {
            elements = driver.get().findElements(By.tagName(locatorValue));
        } else if (locatorType.equalsIgnoreCase("class")) {
            elements = driver.get().findElements(By.className(locatorValue));
        } else if (locatorType.equalsIgnoreCase("linktext")) {
            elements = driver.get().findElements(By.linkText(locatorValue));
        } else if (locatorType.equalsIgnoreCase("partiallinktext")) {
            elements = driver.get().findElements(By.partialLinkText(locatorValue));
        } else if (locatorType.equalsIgnoreCase("css")) {
            elements = driver.get().findElements(By.cssSelector(locatorValue));
        }

        return elements;
    }

    public By returnLocator(String locatorType, String locatorValue) {
        By by = null;
        if (locatorType.equalsIgnoreCase("xpath")) {
            by = By.xpath(locatorValue);
        } else if (locatorType.equalsIgnoreCase("id")) {
            by = By.id(locatorValue);
        } else if (locatorType.equalsIgnoreCase("name")) {
            by = By.name(locatorValue);
        } else if (locatorType.equalsIgnoreCase("tagname")) {
            by = By.tagName(locatorValue);
        } else if (locatorType.equalsIgnoreCase("class")) {
            by = By.className(locatorValue);
        } else if (locatorType.equalsIgnoreCase("linktext")) {
            by = By.linkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("partiallinktext")) {
            by = By.partialLinkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("css")) {
            by = By.cssSelector(locatorValue);
        }
        return by;
    }

    public void mouseMove(WebElement menMenu) {
        Actions act = new Actions(driver.get());
        act.moveToElement(menMenu).perform();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void enterText(WebElement searchComponent, String productName) {
        searchComponent.sendKeys(productName);
    }
}