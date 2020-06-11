package et.com.synctech.mobileappexam.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import et.com.synctech.mobileappexam.R;
import et.com.synctech.mobileappexam.entity.Employee;

/**
 * Created by Queen on 6/11/2020.
 */

public class EmployeeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Employee> arrayList;

    public EmployeeAdapter(Context context, ArrayList<Employee> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null)
        {
            view=View.inflate(context, R.layout.employee_list,null);
        }
        TextView empName=view.findViewById(R.id.employee_name);
        TextView empAge=view.findViewById(R.id.age);
        TextView empSalary=view.findViewById(R.id.salary);
        Employee employee= arrayList.get(i);
        empName.setText(""+employee.getName());
        empAge.setText(""+employee.getAge());
        empSalary.setText(""+employee.getSalary());

        return view;
    }
}
