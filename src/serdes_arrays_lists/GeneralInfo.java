package serdes_arrays_lists;

import java.util.List;

public class GeneralInfo {
    String name;
    String website;

    List<Founder> info;

    public GeneralInfo(String name, String website, List<Founder> info){
        this.name = name;
        this.website = website;
        this.info = info;
    }
}
