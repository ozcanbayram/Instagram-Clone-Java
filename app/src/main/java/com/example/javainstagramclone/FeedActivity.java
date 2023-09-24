package com.example.javainstagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FeedActivity extends AppCompatActivity {

    private FirebaseAuth auth;  // Add Firebase  Authentication (name: Auth)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        auth = FirebaseAuth.getInstance(); //İnitilaze FirebaseAuth
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.add_post){
            // Go to Upluad Activity
            Intent intent = new Intent(FeedActivity.this, UploadActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.signout){
            // Signout
            auth.signOut();

            Intent intent = new Intent(FeedActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

            Toast.makeText(this, "Sign out is successfull", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}