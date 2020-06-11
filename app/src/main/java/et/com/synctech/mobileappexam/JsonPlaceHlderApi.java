package et.com.synctech.mobileappexam;

import java.util.List;

import et.com.synctech.mobileappexam.entity.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Queen on 6/8/2020.
 */

public interface JsonPlaceHlderApi {

    @GET("api/v1/employees")
    Call<Object> getEmployees();
}
