package et.com.synctech.mobileappexam;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.orm.SugarContext;
import com.orm.SugarDb;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import et.com.synctech.mobileappexam.adapters.EmployeeAdapter;
import et.com.synctech.mobileappexam.entity.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private Employee employee;
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SugarDb sugarDb=new SugarDb(this);
        sugarDb.onCreate(sugarDb.getDB());
        getEmployeeFromRetrofit();
        listView=findViewById(R.id.employee_list_view);

        displayRecord();
    }

    public void displayRecord(){
        List<Employee> list=Employee.listAll(Employee.class);
        employeeArrayList=new ArrayList<>();
        employee=new Employee();
        for(int i=0;i<list.size();i++){
            employee=list.get(i);
            employeeArrayList.add(employee);

        }
        employeeAdapter=new EmployeeAdapter(MainActivity.this,employeeArrayList);
        listView.setAdapter(employeeAdapter);
    }

    public void getEmployeeFromRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHlderApi jsonPlaceHlderApi=retrofit.create(JsonPlaceHlderApi.class);

        Call call = jsonPlaceHlderApi.getEmployees();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                JsonElement jsonElement=new Gson().toJsonTree(response.body());
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonArray jsonArray=jsonObject.getAsJsonArray("data");
                ArrayList<Employee> employeeList=new ArrayList<>();
                Gson gson=new Gson();
                for (int i=0;i<jsonArray.size();i++){
                    Log.d("===========Emp",jsonArray.get(i).toString());
                    Employee employee=gson.fromJson(jsonArray.get(i).toString(),Employee.class);
                    employeeList.add(employee);
                }
                for (Employee employee : employeeList) {

                    employee.save();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.toString() );
                // Log error here since request failed
            }
        });
//
    }

}
