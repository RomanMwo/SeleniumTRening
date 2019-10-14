package framework;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class BaseDriver implements IDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait fluentWait;
    protected Logger OurLogger;
    protected Actions action;
    public Logger getOurLogger() {
        return OurLogger;
    }

    public BaseDriver() {
        setDriverLocationProperty();
        initializeDriver();
        initializeWebDriverWait();
        initializeLogger();
        initializeAction();
        initializeWaitFluent();
    }

// method thath get title of web page
    public String getTitle() {
        return driver.getTitle();
    }
// metod define URL which will be open
    public void get(String urlToGo) {
        driver.get(urlToGo);
    }
// maximize windows of web browser
    public void maximazeWindow() {
        driver.manage().window().maximize();
    }
// close driver
    public void closeDriver() {
        driver.close();
    }
// method wait with parameter which is element on page
    public void waitUntil(ExpectedCondition webElementExpectedCondition) {
        wait.until(webElementExpectedCondition);
    }
// on open browser switch to another page
    public void newPageUrl(String urlToGo) {
        driver.navigate().to(urlToGo);
    }
// method witch find element by locator the same like standard webdriver method
    public WebElement findElement(By locator) {

        return driver.findElement(locator);
    }
// method witch finds elements with the same name of locator and compile list of them. the same like standard method
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
// methot click on element like standard
    public void click(By locator) {
        driver.findElement(locator).click();
    }
// method click on specific element from list of elements
    public void clickWebelemntFromList(List<WebElement> li, int index) {
        li.get(index).click();
    }

// method to move cursour on hover by webelement from list

    public void actionHover(WebElement el) {
        action.moveToElement(el).build().perform();
    }
// sleep waiting bymilliseconds
    public void sleep(int milisecond) throws InterruptedException {
        Thread.sleep(milisecond);
    }
// method send value to input
    public void sendKeys(By locator, String myKeys){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(myKeys);

    }

    // send value and clik on any keyboard button. Variable example  //Keys enter = Keys.ENTER;

    public void sendKeysClickButtonOnKeybord(By locator, String myKeys, Keys button){
        WebElement elementOnClick = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        elementOnClick.sendKeys(myKeys);
        elementOnClick.sendKeys( button);
    }

    // method connecting to json data file by path and return jsonList
    public JSONArray jsonReader(String pathToFile){
        JSONArray result = new JSONArray();
        JSONParser jsonParser = new JSONParser();

        try {

            FileReader reader = new FileReader(pathToFile);
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray jsonList = (JSONArray) obj;
            result = jsonList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}

