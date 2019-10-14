
package jsonClassEquivalent;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchInput {

    @SerializedName("opony")
    @Expose
    private List<String> opony = null;
    @SerializedName("telefony")
    @Expose
    private List<String> telefony = null;

    public List<String> getOpony() {
        return opony;
    }

    public void setOpony(List<String> opony) {
        this.opony = opony;
    }

    public List<String> getTelefony() {
        return telefony;
    }

    public void setTelefony(List<String> telefony) {
        this.telefony = telefony;
    }

}
