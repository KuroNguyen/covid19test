import Retrofit.Covid19Api;
import Retrofit.model.DateData;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public class CommandHandler {

    // Api service
    Covid19Api service;

    public CommandHandler(Covid19Api covid19Api) {
        service = covid19Api;
    }

    public void handleCmd(String cmd) {
        System.out.println(cmd);
        String command =cmd.toUpperCase();
        if (command.startsWith("HISTORY")) {
            List<String> latestDayList = getDateList();
            System.out.println("Please chose the date:");
            for (int i = 0; i<7; i++) {
                System.out.printf("%d: %s", i+1, latestDayList.get(i));
            }
        }
    }

    private List<String> getDateList() {
        try {
            ResponseBody responseBody = service.getHistoryJson("deaths").blockingGet();
            String dataJson = responseBody.string();
            JSONObject jsonObject = new JSONObject(dataJson);
            JSONObject dateObject = jsonObject.getJSONObject("All").getJSONObject("dates");
            List<String> latest7Days = new ArrayList<>();
            for (String key: dateObject.keySet()) {
                if (latest7Days.size() >= 7)
                    return latest7Days;
                latest7Days.add(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
