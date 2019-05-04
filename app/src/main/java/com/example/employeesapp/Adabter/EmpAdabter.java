package com.example.employeesapp.Adabter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.employeesapp.Data.DataHelper;
import com.example.employeesapp.EmployeesScreen;
import com.example.employeesapp.Model.EmpModel;
import com.example.employeesapp.R;

import java.util.List;

public class EmpAdabter extends RecyclerView.Adapter<EmpAdabter.EmpHolder> {
    private List<EmpModel> emplist;
    private Context context;

    public EmpAdabter(List<EmpModel> emplist) {
        this.emplist = emplist;
    }

    @NonNull
    @Override
    public EmpHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.row_card,viewGroup,false);
        return new  EmpHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EmpHolder empHolder, int i) {
        final EmpModel DH =emplist.get(i);
        empHolder.Name.setText(DH.getName());
        empHolder.Role.setText(DH.getRole());

        //stupid solution
        empHolder.Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, EmployeesScreen.class);
                i.putExtra("getName",DH.getName());
                i.putExtra("getRole",DH.getRole());
                i.putExtra("getSalary",DH.getSalary());
                i.putExtra("getBirthDate",DH.getBirthDate());
                i.putExtra("getAddress",DH.getAddress());
                i.putExtra("getGender",DH.getGender());
                context.startActivity(i);
            }
        });

    }
    @Override
    public int getItemCount() {
        return emplist!=null?emplist.size():0;
    }


    public class EmpHolder extends RecyclerView.ViewHolder {
        TextView Name,Role;

        public EmpHolder(@NonNull View itemView) {
            super(itemView);
            Name= itemView.findViewById(R.id.NameView);
            Role= itemView.findViewById(R.id.RoleView);


        }
    }
}
