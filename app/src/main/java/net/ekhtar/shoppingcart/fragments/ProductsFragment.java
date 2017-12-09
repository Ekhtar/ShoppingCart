package net.ekhtar.shoppingcart.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.ekhtar.shoppingcart.R;
import net.ekhtar.shoppingcart.adaptors.ProductAdaptor;
import net.ekhtar.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private RecyclerView rvSubCategoryProducts;
    private List<Product> products;
    private ProductAdaptor productAdaptor;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    String productRef="products";

    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSubCategoryProducts = view.findViewById(R.id.rvSubCategoryProducts_SubCategoryProducts);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        products = new ArrayList<>();

        getAllProduct();

        productAdaptor = new ProductAdaptor(products,getContext());
        DividerItemDecoration vdividerItemDecoration = new DividerItemDecoration(getContext(), GridLayoutManager.VERTICAL);
        DividerItemDecoration hdividerItemDecoration = new DividerItemDecoration(getContext(), GridLayoutManager.HORIZONTAL);
        rvSubCategoryProducts.addItemDecoration(vdividerItemDecoration);
        rvSubCategoryProducts.addItemDecoration(hdividerItemDecoration);
        rvSubCategoryProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvSubCategoryProducts.setAdapter(productAdaptor);
    }

    private void getAllProduct(){

        myRef.child(productRef).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Product allProduct=dataSnapshot.getValue(Product.class);
                products.add(allProduct);
                productAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
