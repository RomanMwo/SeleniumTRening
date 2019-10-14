package framework;


import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BasePage {
    protected BaseDriver driver;

    public BasePage(BaseDriver driver) {
        this.driver = driver;
    }

    public String returnPageTitle() {
        String title = driver.getTitle();
        return title;
    }

}
