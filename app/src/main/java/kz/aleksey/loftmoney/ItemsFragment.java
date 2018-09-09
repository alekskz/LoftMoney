package kz.aleksey.loftmoney;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    private static final String TAG = "ItemsFragment";

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
    private  Api api;

    private int type;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");

        Bundle args = getArguments();

        if (args != null) {
            type = args.getInt(KEY_TYPE, TYPE_UNKNOWN);
            if (type == TYPE_UNKNOWN){
              throw new IllegalStateException("Unknown type!");
            }
        } else {
            throw new IllegalStateException("You mast pass valid fragment type!");
        }

        api = ((App) getActivity().getApplication()).getApi();
        adapter = new ItemsAdapter();
        loadItems();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated: ");
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    private void loadItems(){

    }
}
