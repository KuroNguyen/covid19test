package Retrofit.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */

public class GlobalData {

    @SerializedName("All")
    private CovidData covidData;

    public CovidData getCovidData() {
        return covidData;
    }

    public void setCovidData(CovidData covidData) {
        this.covidData = covidData;
    }
}
