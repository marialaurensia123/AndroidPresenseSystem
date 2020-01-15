package com.example.androidpresensesystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ActionBar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
//import android.widget.Toolbar;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import androidx.appcompat.widget.Toolbar;
//import android.support.v7.widget.Toolbar;



public class ListOnline extends AppCompatActivity {

    //Firebase
    DatabaseReference onlineRef,currentUserRef,counterRef;
    FirebaseRecyclerAdapter<User, ListOnlineViewHolder> adapter;

    //view
    RecyclerView listOnline;
    RecyclerView.LayoutManager layoutManager;

    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_online);

        //init view
        listOnline = (RecyclerView)findViewById(R.id.listOnline);
        listOnline.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listOnline.setLayoutManager(layoutManager);


        //set Toolbar and logout /join menu
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        toolbar.setTitle("EDMT Presense System");
        setSupportActionBar(toolbar);

        //Firebase
        onlineRef = FirebaseDatabase.getInstance().getReference().child(".info/connected");
        counterRef = FirebaseDatabase.getInstance().getReference("lastOnline");// create
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
}
