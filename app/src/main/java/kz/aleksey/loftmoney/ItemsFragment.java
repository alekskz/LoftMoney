package kz.aleksey.loftmoney;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private static final String KEY_TYPE = "type";

    private static final int TYPE_UNKNOWN = -1;

    public static final int TYPE_INCOMES = 1;
    public static final int TYPE_EXPENSES = 2;
    public static final int TYPE_BALANCE = 3;


    public static ItemsFragment newInstance(int type){
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ItemsFragment.KEY_TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }

    public ItemsFragment() {}

    private RecyclerView recycler;
    private ItemsAdapter adapter;

    private int type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            type = args.getInt(KEY_TYPE, TYPE_UNKNOWN);
            if (type == TYPE_UNKNOWN){
              throw new IllegalStateException("Unknown type!");
            }
        } else {
            throw new IllegalStateException("You mast pass valid fragment type!");
        }

        adapter = new ItemsAdapter();
        adapter.setItems(createTestItems());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private List<Item> createTestItems() {

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
        return items;

    }
}
