import Retrofit.ApiUtils;
import Retrofit.Covid19Api;
import Retrofit.model.CovidApiResponse;
import Retrofit.model.CovidData;
import retrofit2.Call;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/19/2021
 * Updated: 6/19/2021
 */
public class main {

    // Scanner
    private static Scanner sc;
    // Covid19Api Service
    private static Covid19Api apiService;
    // Command handler
    private static CommandHandler commandHandler;

    public static void main(String[] args) {

        // Initial Scanner
        sc = new Scanner(System.in);

        // Initialize api service
        apiService = ApiUtils.getService().create(Covid19Api.class);

        // Command handler
        commandHandler = new CommandHandler(apiService);

        System.out.println("=========COVID-19 INFORMATION=========");
        displayCovidData(getGlobalData());

        askForRequest();

        return;
    }

    private static void displayCovidData(CovidData covidData) {
        String lefAlignFormat = "| %-15s | %-10d | %n";
        System.out.format("+-----------------+------------+%n");
        System.out.format(lefAlignFormat, "population", covidData.getPopulation());
        System.out.format(lefAlignFormat, "confirmed", covidData.getConfirmed());
        System.out.format(lefAlignFormat, "recovered", covidData.getRecovered());
        System.out.format(lefAlignFormat, "deaths", covidData.getDeaths());
        System.out.format("+-----------------+------------+%n");
    }

    private static CovidData getGlobalData() {
        try {
            CovidApiResponse covidApiResponse = apiService.getCases().blockingGet();
            return covidApiResponse.getGlobalData().getCovidData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void askForRequest() {
        System.out.println("Please type your request:");
        String cmd = sc.nextLine();
        commandHandler.handleCmd(cmd);
    }

}
