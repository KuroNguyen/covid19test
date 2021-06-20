package Retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public class CovidApiResponse {

    @SerializedName("Global")
    private GlobalData globalData;

    public GlobalData getGlobalData() {
        return globalData;
    }

    public void setGlobalData(GlobalData globalData) {
        this.globalData = globalData;
    }
}
