
package jasonClassEqviBrake;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchList {

    @SerializedName("users")
    @Expose
    private Users users;
    @SerializedName("searchInput")
    @Expose
    private SearchInput searchInput;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public SearchInput getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(SearchInput searchInput) {
        this.searchInput = searchInput;
    }

}
