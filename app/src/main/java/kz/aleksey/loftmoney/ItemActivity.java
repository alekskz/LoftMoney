package kz.aleksey.loftmoney;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Гвозди х100", "100"));
        items.add(new Item("Гвозди х120", "130"));
        items.add(new Item("Саморезы 5х8", "195"));
        items.add(new Item("Саморезы 6х10", "210"));
        items.add(new Item("Саморезы 8х12", "250"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));
        items.add(new Item("Доска 10х10", "1500"));

        ItemsAdapter adapter = new ItemsAdapter();
        adapter.setItems(items);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
