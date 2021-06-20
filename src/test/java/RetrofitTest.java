import Retrofit.ApiUtils;
import Retrofit.Covid19Api;
import Retrofit.model.GlobalData;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public class RetrofitTest {

    JSONObject jsonObject;
//
//    @Test
//    void callApiTest() {
//        Covid19Api soService = ApiUtils.getService().create(Covid19Api.class);
//        soService.getCases()
//                .observeOn(Schedulers.io())
//                .subscribe(covidApiResponse -> {
//                    GlobalData data = covidApiResponse.getGlobalData();
//                    System.out.println(data.getCovidData().getConfirmed());
//                });
//    }

    @Test
    void callHistoryApiTest() {
        Covid19Api soService = ApiUtils.getService().create(Covid19Api.class);
        try {
            ResponseBody responseBody = soService.getHistoryJson("deaths").blockingGet();
            String data = responseBody.string();
            JSONObject jsonObject = new JSONObject(data);
            System.out.println(jsonObject);
            JSONObject dateObject = jsonObject.getJSONObject("All").getJSONObject("dates");
            for (String keyStr: dateObject.keySet()) {
                System.out.println(keyStr);
                System.out.println(dateObject.get(keyStr));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
