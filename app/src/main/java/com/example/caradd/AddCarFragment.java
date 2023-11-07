package com.example.caradd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCarFragment extends Fragment {
    FirebaseServices fbs;
    private EditText etYear,etColor,etEngineDisplacement,etPrice,etMn,etHorsepower,etCylinder,etModel;
    private Button btnAdd;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCarFragment newInstance(String param1, String param2) {
        AddCarFragment fragment = new AddCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_car, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        connectComponents();
    }

    private void connectComponents() {
        fbs = FirebaseServices.getInstance();
        etYear = getView().findViewById(R.id.etYearAddCarFragment);
        etColor = getView().findViewById(R.id.etColorAddCarFragment);
        etModel = getView().findViewById(R.id.etModelAddCarFragment);
        etMn = getView().findViewById(R.id.etMnAddCarFragment);
        etCylinder = getView().findViewById(R.id.etCilanderAddCarFragment);
       etPrice=getView().findViewById(R.id.etPriceAddCarFragment);
        etHorsepower = getView().findViewById(R.id.etHPAddCarFragment);
        etEngineDisplacement = getView().findViewById(R.id.etEngineAddCarFragment);
        btnAdd = getView().findViewById(R.id.btnAddAddCarFragment);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                Integer year = Integer.parseInt(etYear.getText().toString());
                Integer mn = Integer.parseInt(etMn.getText().toString());
                Integer cylinder= Integer.parseInt(etCylinder.getText().toString());
                Integer price = Integer.parseInt(etPrice.getText().toString());
                Integer horsePower = Integer.parseInt(etHorsepower.getText().toString());
                String color = etColor.getText().toString();
                String model = etModel.getText().toString();
                Double  engineDisplacement=Double.parseDouble(etEngineDisplacement.getText().toString()) ;

                // data validation
                if (color.trim().isEmpty() || model.trim().isEmpty() )

                {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }

                // add data to firestore
                Car rest = new Car(color, year, model, price,cylinder,horsePower,mn,engineDisplacement);

                fbs.getFire().collection("restaurants").add(rest).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your restaurant!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddRestaurant: ", e.getMessage());
                    }
                });


            }
        });

    }


}