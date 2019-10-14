
package jasonClassEqviBrake;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyresultNoBrace {

    @SerializedName("searchList")
    @Expose
    private List<SearchList> searchList = null;

    public List<SearchList> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<SearchList> searchList) {
        this.searchList = searchList;
    }

}
