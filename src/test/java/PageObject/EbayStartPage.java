package PageObject;

import framework.BaseDriver;
import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import javax.swing.*;
import java.beans.Visibility;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class EbayStartPage extends BasePage {


    public EbayStartPage(BaseDriver driver) {
        super(driver);
    }

    private List<WebElement> allLinksOnTheMainPage;
    private List<WebElement> link;
    private By elekronics = xpath("/html/body/div[4]/div[1]/ul/li[3]/a");
    private By fashion = cssSelector("li.hl-cat-nav__js-tab:nth-child(4) > a:nth-child(1)");
    private List<WebElement> hlElementsList;
    private By hlElementsCssSelector = cssSelector(".hl-image__background");
    private By tvAudioVideoLinkHover = xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/div[2]/ul/li[1]/a");
    private By inputSearchMain = xpath("//*[@id=\"gh-ac\"]");


    public void checkPageTitle() {

        assertEquals("Elektronika, Odzież, Samochody, Przedmioty kolekcjonerskie i jeszcze więcej | eBay", super.returnPageTitle());

    }

    public EbayStartPage openEbayStartPage(String urlToGo) {
        driver.maximazeWindow();
        driver.get(urlToGo);
        driver.waitUntil(ExpectedConditions.titleIs("Elektronika, Odzież, Samochody, Przedmioty kolekcjonerskie i jeszcze więcej | eBay"));
        driver.getOurLogger().info("ebay web site was opened");
        driver.getOurLogger().info("Title of Web Page i correct - checed");
        //driver.newPageUrl("https://www.onet.pl/");
        Reporter.log("test finish");
        return this;
    }

    public void webElementTemporaryTrainin() {
        hlElementsList = driver.findElements(hlElementsCssSelector);
        driver.clickWebelemntFromList(hlElementsList, 26);

    }

    public EbayStartPage mouseHoverActionTraining() throws InterruptedException {

        link = driver.findElements(By.cssSelector(".hl-cat-nav__js-tab"));
        driver.actionHover(link.get(0));
        driver.sleep(7000);
        driver.click(tvAudioVideoLinkHover);

        return this;
    }

    public EbayStartPage probe() {
//driver.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.linkText("Elektronika")));
        //driver.action.moveToElement(electronicsMoseHover).build().perform();
        //link = driver.findElements(By.cssSelector("div#mainContent>div.hl-cat-nav>ul.hl-cat-nav__container>li"));
        link = driver.findElements(By.cssSelector(".hl-cat-nav__js-tab"));
        //driver.click( fashion);
        driver.clickWebelemntFromList(link, 0);
        System.out.println("jak to " + " " + link.size());
        return this;
    }

    public EbayStartPage allLinksOnThePage() {

        allLinksOnTheMainPage = driver.findElements(By.tagName("a"));
        System.out.println("All links amount of list on the main page are" + " " + allLinksOnTheMainPage.size());
//       //Zwykła petla for each
//        for (WebElement links : allLinksOnTheMainPage) {
//            System.out.println( " link atribbute" + " " + links.getAttribute("href"));
//        }
        //za pomoca lamd i stream
        allLinksOnTheMainPage.stream()
                .map(e -> e.getAttribute("href"))
                //dzila wypisuje ale nie  ma dodatkowych "link attribute" +"
                //.forEach( System.out::println);
                .forEach(e -> System.out.println("link attribute" + " " + e));
        return this;
    }

    public SearchResultPageOpony searchTiresInMainSearchInput() throws InterruptedException {
        //driver.sendKeys(inputSearchMain, "opony");
        driver.sendKeysClickButtonOnKeybord(inputSearchMain, "opony", Keys.ENTER);
        driver.sleep(10000);
        return new SearchResultPageOpony(driver);
    }
}
