package com.example.project2mobileapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentFruit extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Contact> Firstcontact;

    public FragmentFruit() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fruit_fragment, container, false);
        //myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);
        RecyclerView myrecyclerview = v.findViewById(R.id.contact_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), Firstcontact);
        myrecyclerview.setAdapter(recyclerAdapter);
        myrecyclerview.setItemAnimator(new DefaultItemAnimator());
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firstcontact = new ArrayList<>();
        Firstcontact.add(new Contact("Apple", "Fresh pink lady apples", R.drawable.apple));
        Firstcontact.add(new Contact("Oranges", "Fresh oranges", R.drawable.orange));
        Firstcontact.add(new Contact("Banana", "Fresh bananas", R.drawable.banana));
        Firstcontact.add(new Contact("Kiwi", "Fresh kiwis", R.drawable.kiwi));
        Firstcontact.add(new Contact("Grapes", "Fresh grapes", R.drawable.grapes));
    }
}
