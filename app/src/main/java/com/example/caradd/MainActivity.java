package com.example.caradd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            gotoAddFragment();
        }


        private void gotoAddFragment() {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout,new AddCarFragment());
            ft.commit();
        }
    private void gotoAllRestsFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,new AllCarsFragment());
        ft.commit();
    }


}