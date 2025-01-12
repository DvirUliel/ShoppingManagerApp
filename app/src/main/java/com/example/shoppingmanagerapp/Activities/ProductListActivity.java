package com.example.shoppingmanagerapp.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoppingmanagerapp.Adapters.ProductAdapter;
import com.example.shoppingmanagerapp.Classes.Product;
import com.example.shoppingmanagerapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private TextView tvWelcome;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList;
    private Button btnSubmitProducts;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        tvWelcome = findViewById(R.id.tv_welcome);
        recyclerView = findViewById(R.id.recycler_view);
        btnSubmitProducts = findViewById(R.id.btn_submit_products);

        String username = mAuth.getCurrentUser().getEmail();
        tvWelcome.setText("Welcome, " + username + "!");

        productList = new ArrayList<>();
        loadInitialProducts();

        adapter = new ProductAdapter(productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSubmitProducts.setOnClickListener(view -> {
            String userId = mAuth.getCurrentUser().getUid();
            database.getReference("users").child(userId).child("shoppingList").setValue(productList);
        });
    }

    private void loadInitialProducts() {
        productList.add(new Product("Apple", R.drawable.apple, 0));
        productList.add(new Product("Banana", R.drawable.banana, 0));
        productList.add(new Product("Orange", R.drawable.orange, 0));
        productList.add(new Product("Milk", R.drawable.milk, 0));
        productList.add(new Product("Bread", R.drawable.bread, 0));
        productList.add(new Product("Cheese", R.drawable.cheese, 0));
        productList.add(new Product("Eggs", R.drawable.eggs, 0));
        productList.add(new Product("Tomato", R.drawable.tomato, 0));
    }
}