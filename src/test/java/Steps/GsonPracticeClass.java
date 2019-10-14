package Steps;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import framework.BaseTest;
import jasonClassEqviBrake.MyresultNoBrace;
import jasonClassEqviBrake.SearchList;
import jsonClassEquivalent.Myresult;
import jsonClassEquivalent.Result;
import jsonClassEquivalent.SearchInput;
import jsonClassEquivalent.Todo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonPracticeClass extends BaseTest {

    public static void main(String[] args) {
//        Gson gson = new Gson();
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader("D:\\SELENIUM\\newTraining\\src\\test\\java\\data\\jsonPracticeGson"));
//            Result result = gson.fromJson(br, Result.class);
//            if (result != null) {
//                for (Todo t : result.getTodos()) {
//                    System.out.println(t.getId() + " - " + t.getTitle() + " - " + t.getCompleted());
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }


        // System.out.println ("to jest tescik");

//        Gson gson = new Gson();
//       BufferedReader br = null;
//
//       try {
//            br = new BufferedReader(new FileReader("D:\\SELENIUM\\newTraining\\src\\test\\java\\data\\jsonPractice"));
//
//          // List <SearchInput> result = gson.fromJson(br, new TypeToken<SearchInput>(){}.getType());
//
//
//           Myresult[] arr = gson.fromJson(br, Myresult[].class);
//           if (arr != null) {
//           //    SearchInput ser = result.getSearchInput();
//
//               //for (int i = 0; i < arr.length; i++) {
//                  System.out.println(arr[3].getSearchInput().getOpony().get(0));
//             // }
//          }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//               try {
//                    br.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//       }
//


        Gson gson = new Gson();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("D:\\SELENIUM\\newTraining\\src\\test\\java\\data\\noJasonBracetsDataPractice\\jsonPracticebrake"));

            // List <SearchInput> result = gson.fromJson(br, new TypeToken<SearchInput>(){}.getType());


            MyresultNoBrace result = gson.fromJson(br, MyresultNoBrace.class);

            if (result != null) {
               // for (SearchList t : result.getSearchList()) {
                List <SearchList> t = result.getSearchList();
                    String dataInput = (t.get(3).getSearchInput().getTelefony().get(1));
                    System.out.println(dataInput);
               // }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }

}
