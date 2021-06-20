package Retrofit.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public class CovidData {

    private long population;
    private long confirmed;
    private long recovered;
    private long deaths;

    @SerializedName("dates")
    private DateData dates;

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public DateData getDates() {
        return dates;
    }

    public void setDates(DateData dates) {
        this.dates = dates;
    }
}
