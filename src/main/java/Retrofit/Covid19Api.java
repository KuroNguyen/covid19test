package Retrofit;

import Retrofit.model.CovidApiResponse;
import Retrofit.model.GlobalData;
import io.reactivex.Single;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public interface Covid19Api {

    @GET("cases")
    Single<CovidApiResponse> getCases();

    @GET("history?country=Global")
    Single<GlobalData> getHistory(@Query("status") String status);

    @GET("history?country=Global")
    Single<ResponseBody> getHistoryJson(@Query("status") String status);
}
