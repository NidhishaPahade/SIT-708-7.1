package com.example.myapplication3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication3.Database;
import com.example.myapplication3.Item;

import java.util.ArrayList;
import java.util.List;

public class ShowItems extends AppCompatActivity implements AdapterItem.RowClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        RecyclerView showRVItems = findViewById(R.id.RV);
        Database Database = new Database(this);
        List<Item> itemList = Database.fetchAllItems();
        AdapterItem a = new AdapterItem(itemList,ShowItems.this, this);
        RecyclerView.LayoutManager vertical =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        showRVItems.setAdapter(a);
        showRVItems.setLayoutManager(vertical);

    }

    @Override
    public void onItemClick(int id) {
        Intent i = new Intent(getApplicationContext(),ItemDetails.class);
        i.putExtra("item id",id);
        startActivity(i);
    }
}