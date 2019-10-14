package framework;

import org.openqa.selenium.interactions.Actions;

public interface IDriver {

    void initializeDriver();
    void initializeWebDriverWait();
    void setDriverLocationProperty();
    void initializeLogger();
    void initializeAction();
    void initializeWaitFluent();
}
