package com.example.user.internproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LocalFragment extends Fragment {
    @Nullable
    // json file working //
            ArrayList<PersonModel> employeeList = new ArrayList<PersonModel>();

    // json file working //
    RecyclerView recyclerView;
   // int[] images = {R.drawable.student,R.drawable.teacher,R.drawable.boy1,R.drawable.teacher1};

    MyAdapter myAdapter;
    String [] names,designations;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local,container,false);
        recyclerView = view.findViewById(R.id.recyclerViewId);
        //names = getResources().getStringArray(R.array.names);
        //designations = getResources().getStringArray(R.array.designation);

        get_json();
        //employeeList = new ArrayList<>();
        myAdapter = new MyAdapter(employeeList,getContext());

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;

    }
    // json file working //

    public void get_json(){
        String json;
        try{
            InputStream is = getActivity().getAssets().open("app.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i< jsonArray.length();i++){

                JSONObject employeeObject = jsonArray.getJSONObject(i);
               // JSONObject jsonObject=jsonArray.getJSONObject(i);
                PersonModel person=new PersonModel();
                person.setName(employeeObject.getString("name"));
                person.setDesignation(employeeObject.getString("designation"));
                person.setTeam(employeeObject.getString("team"));
                person.setImage(employeeObject.getString("image"));
                //arrayList.add(jsonObject.getString("team"));
                employeeList.add(person);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    // json file working

    public LocalFragment() {

    }
}

