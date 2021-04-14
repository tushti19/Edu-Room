package com.anddev.edu_room.Activities;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.anddev.edu_room.API.Data;
import com.anddev.edu_room.API.GetAllPostsAPI;
import com.anddev.edu_room.API.PostResponse;
import com.anddev.edu_room.API.RetrofitInstance;
import com.anddev.edu_room.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    GetAllPostsAPI apiInterface;

    String accessToken;

    int userId;

    ListView postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = getIntent().getExtras().getInt("userId");
        accessToken = getIntent().getExtras().getString("access");
        Toast.makeText(this, "userId : "+userId, Toast.LENGTH_SHORT).show();

        apiInterface = RetrofitInstance.getClient().create(GetAllPostsAPI.class);

        postsList = findViewById(R.id.posts_lv);

        final Call<PostResponse> postResponseCall = apiInterface.getAllPosts(userId , "Bearer "+ accessToken);
        postResponseCall.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                if(response.isSuccessful()){
                    PostResponse postResponse = response.body();
                    Log.d("body",""+postResponse.getResponseMessage()+postResponse.getResponseCode()+postResponse.getComments());
                    setUpListView(postResponse,postsList);
                }
                else{
                    Log.d("error", "res");
                }

            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

                Log.d("Error", t.getMessage());

            }
        });





    }

    private void setUpListView(PostResponse postResponse, ListView postsList) {

        Data[] data = postResponse.getResult().getData();
        CustomAdapter adapter = new CustomAdapter(data);
        postsList.setAdapter(adapter);




    }

    public class CustomAdapter extends BaseAdapter {

        Data[] data ;

        public CustomAdapter(Data[] data) {

            this.data = data;
        }



        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.post_item,null);


            TextView userName,answer,createdOn,upvotes,reply,reports;
            ImageView postImage;

            ImageButton AnswerBtn, UpvoteBtn, ReportBtn;

            userName = view.findViewById(R.id.UserName);
            answer = view.findViewById(R.id.Answer);
            createdOn = view.findViewById(R.id.Time);
            upvotes = view.findViewById(R.id.UpvotesTv);
            reply = view.findViewById(R.id.ReplyTv);
            reports = view.findViewById(R.id.ReportTv);
            postImage = view.findViewById(R.id.Image);

            AnswerBtn = view.findViewById(R.id.ReplyBtn);
            UpvoteBtn = view.findViewById(R.id.LikeBtn);
            ReportBtn = view.findViewById(R.id.ReportBtn);

            AnswerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,AnswerActivity.class);
                    intent.putExtra("userId",userId);
                    intent.putExtra("postId",data[i].getPostId());
                    intent.putExtra("accessToken",accessToken);
                    intent.putExtra("ques",data[i].getText());
                    startActivity(intent);
                }
            });


            userName.setText(data[i].getUserName());
            answer.setText(data[i].getText());
            createdOn.setText(data[i].getCreatedOn());
            upvotes.setText("Upvotes(" + data[i].getUpvoteCount() + ")");
            reports.setText("Report("+data[i].getReportCount()+")");
            reply.setText("Answer("+data[i].getAnswerCount()+")");


            String Url = data[i].getImage();

            Context context = getApplicationContext();
            if(Url != null && Url.length() !=0){

                Log.d("url",Url);



                Glide.with(context).load(new File("https://mirrorscore-android.herokuapp.com"+Url)).diskCacheStrategy(DiskCacheStrategy.ALL).into(postImage);
                //postImage.setVisibility(View.VISIBLE);

            }
            else {
                postImage.setVisibility(View.GONE);
            }

            return view;
        }
    }
}