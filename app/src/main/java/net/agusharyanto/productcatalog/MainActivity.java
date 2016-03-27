package net.agusharyanto.productcatalog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by agus on 3/27/16.
 * agus.superwriter@gmail.com
 * http://agusharyanto.net
 */

public class MainActivity extends AppCompatActivity {

    private List<Product> products = new ArrayList<Product>();
    private GridView gridViewProduct;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewProduct = (GridView) findViewById(R.id.gridViewProduct);
        initData();
        drawDatatoGridView();
    }

    private void initData(){
        List<String> fruits= Arrays.asList("apple", "banana", "cherry", "coconut", "grape", "kiwi", "lemon", "mango", "orange", "peach", "pear", "pineapple", "starfruit", "stroberry", "watermelon");
        for (int i=0; i<fruits.size(); i++){
            int id= i+1;
            int price = id * 1000;
            products.add(new Product(id + "", fruits.get(i), fruits.get(i), price + ""));
        }
    }

    private void drawDatatoGridView() {
        productAdapter = new ProductAdapter(MainActivity.this,
                R.layout.item_product, products);
        gridViewProduct.setAdapter(productAdapter);
        gridViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(),"Product Name :"+product.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
