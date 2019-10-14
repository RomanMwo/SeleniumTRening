package Steps;

import PageObject.EbayStartPage;
import framework.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Ebay extends BaseTest {

    private EbayStartPage ebayStartPage;

    @BeforeTest
    public void setUp() {
        super.setUp();
        ebayStartPage = new EbayStartPage(driver);
    }

    @Test
    public void getMainPage() throws InterruptedException {

        // ebayStartPage.openEbayStartPage("http://www.ebay.pl").webElementTemporaryTrainin();
        //ebayStartPage.openEbayStartPage("http://www.ebay.pl").mouseHoverActionTraining();
        //ebayStartPage.openEbayStartPage("http://www.ebay.pl").allLinksOnThePage().mouseHoverActionTraining();
        //ebayStartPage.allLinksOnThePage();
        ebayStartPage.openEbayStartPage("http://www.ebay.pl").searchTiresInMainSearchInput();
        //ebayStartPage.probe();

    }

    @Test
    public void jsonTest() {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("D:\\SELENIUM\\newTraining\\src\\test\\java\\data\\jsonPractice");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray usersList = (JSONArray) obj;
            System.out.println("Users List-> " + usersList); //This prints the entire json file
           //for (int i = 0; i < usersList.size(); i++) {
               // JSONObject users = (JSONObject) usersList.get(i);
                //System.out.println("Users -> " + users);//This prints every block - one json object
//                JSONObject user = (JSONObject) users.get("users");
//                System.out.println("User -> " + user); //This prints each data in the block
//               String username = (String) user.get("username");
//               String password = (String) user.get("password");
//               System.out.println("The username in JSON is: "+username);
//               System.out.println("The password in JSON is: "+password);
           JSONObject dataSearch = (JSONObject) usersList.get(3);
            System.out.println( dataSearch);
            JSONObject searchInput = (JSONObject) dataSearch.get("searchInput");
            System.out.println( searchInput);
            JSONArray search = (JSONArray) searchInput.get("opony");
            System.out.println(search);
            String finalSearch = (String) search.get(0);
            System.out.println(finalSearch);
            //}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
