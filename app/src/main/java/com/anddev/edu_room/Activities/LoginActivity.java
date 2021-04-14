package com.anddev.edu_room.Activities;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anddev.edu_room.API.LoginAPI;
import com.anddev.edu_room.API.LoginResponse;
import com.anddev.edu_room.API.RetrofitInstance;
import com.anddev.edu_room.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText EmailET;
    EditText passwordET;

    String Email ;
    String Pass ;

    Button LoginBTn;

    LoginAPI apiIntergace ;

    View parentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        parentLayout = findViewById(android.R.id.content);

        EmailET = findViewById(R.id.Email);
        passwordET = findViewById(R.id.Password);
        LoginBTn = findViewById(R.id.LoginBtn);

        apiIntergace = RetrofitInstance.getClient().create(LoginAPI.class);

        LoginBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = EmailET.getText().toString();
                Pass = passwordET.getText().toString();
                if(Email.length() != 0 && Pass.length() != 0){


                    Log.d("Email , Pass" , Email +","+Pass);


                    Call<LoginResponse> call1 = apiIntergace.createUser(Email,Pass);
                    call1.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            LoginResponse loginR = response.body();

                            
                            if(loginR == null){

                                Toast.makeText(LoginActivity.this, "Incorrect Email or Password", Toast.LENGTH_LONG).show();
                            }
                            else{

                                if(loginR.getResponseCode() == 1){
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                    Log.d("userId",loginR.getResult().getUserId()+"");
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    intent.putExtra("userId",loginR.getResult().getUserId());
                                    intent.putExtra("access",loginR.getResult().getToken().getAccess());
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "Something went Wrong. Try again.", Toast.LENGTH_LONG).show();
                                }
                               
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {




                            Log.d("mess", "yes"+t.getMessage());

                        }
                    });


                }
            }
        });


    }
}