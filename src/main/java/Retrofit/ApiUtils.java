package Retrofit;

import retrofit2.Retrofit;

/**
 * Author: Nguyễn Chánh Trực
 * Created: 6/20/2021
 * Updated: 6/20/2021
 */
public class ApiUtils {

    public Covid19Api getSOService() {
        return RetrofitClient.getClient().create(Covid19Api.class);
    }

    public static Retrofit getService() {
        return RetrofitClient.getClient();
    }
}
