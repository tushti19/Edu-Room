package com.anddev.edu_room.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anddev.edu_room.API.AnswerPost;
import com.anddev.edu_room.API.AnswerResponse;
import com.anddev.edu_room.API.RetrofitInstance;
import com.anddev.edu_room.R;

public class AnswerActivity extends AppCompatActivity {

    EditText ans;
    String Text;
    Button submit;
    TextView ques;

    AnswerPost answerPost;

    int userId,postId;
    String accessToken,question;
    String image = "/path/to/image.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        userId = getIntent().getExtras().getInt("userId");
        postId = getIntent().getExtras().getInt("postId");
        accessToken = getIntent().getExtras().getString("accessToken");
        question = getIntent().getExtras().getString("ques");

        ques = findViewById(R.id.Question);
        ques.setText(question);

        //Toast.makeText(this, userId + "+" + postId + "+" + accessToken + "+" , Toast.LENGTH_LONG).show();



        ans = findViewById(R.id.Answer);

        submit = findViewById(R.id.submit);

        answerPost = RetrofitInstance.getClient().create(AnswerPost.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text = ans.getText().toString();
                if(Text.length() != 0){


                    Call<AnswerResponse> call = answerPost.saveAnswer("Bearer "+ accessToken,userId,postId,Text,image);
                    call.enqueue(new Callback<AnswerResponse>() {
                        @Override
                        public void onResponse(Call<AnswerResponse> call, Response<AnswerResponse> response) {
                            AnswerResponse response1 = response.body();
                            if(response1 == null){
                                Toast.makeText(AnswerActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(AnswerActivity.this, response1.getResult(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<AnswerResponse> call, Throwable t) {

                        }
                    });

                }
            }
        });




    }
}