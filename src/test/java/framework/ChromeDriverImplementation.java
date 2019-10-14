package framework;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeDriverImplementation extends BaseDriver{

    public void initializeDriver() {
        this.driver = new ChromeDriver();
    }

    public void initializeWebDriverWait() {
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public void setDriverLocationProperty() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
    }
    public void initializeAction() {this.action = new Actions(driver);}

    public void initializeWaitFluent(){ this.fluentWait = new FluentWait(driver);
    }

    public void initializeLogger(){
        //Implementacja logow w konsoli
        BasicConfigurator.configure();
        OurLogger = LogManager.getLogger("OurLogger");

        //create a ConsoleAppender object
        //You will also have to set a layout also, here
        //We have chosen a SimpleLayout
        ConsoleAppender ConsoleAppender = new ConsoleAppender();
        ConsoleAppender.setLayout(new SimpleLayout());

        //Add the appender to our Logger Object.
        //from now onwards all the logs will be directed
        //to file mentioned by FileAppender
        OurLogger.addAppender(ConsoleAppender);
        ConsoleAppender.activateOptions();
    };
}
