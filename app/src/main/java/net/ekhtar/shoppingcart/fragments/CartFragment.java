package net.ekhtar.shoppingcart.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.ekhtar.shoppingcart.R;
import net.ekhtar.shoppingcart.adaptors.CartAdaptor;
import net.ekhtar.shoppingcart.adaptors.ProductAdaptor;
import net.ekhtar.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private RecyclerView rvCartList;
    private TextView tvTotalItems;
    private TextView tvSubTotal;
    private TextView tvTotalPrice;

    private CartAdaptor productAdaptor;
    private ArrayList<Product> cartItems;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCartList=(RecyclerView)view.findViewById(R.id.rvShoppingCart_Cart) ;
        tvTotalItems=(TextView)view.findViewById(R.id.tvTotalItems_Cart);
        tvSubTotal=(TextView)view.findViewById(R.id.tvSubTotal_Cart);
        tvTotalPrice=(TextView)view.findViewById(R.id.tvTotalPrice_Cart);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        cartItems=new ArrayList<>();
        getAllProduct();

        rvCartList.setLayoutManager(new LinearLayoutManager(getContext()));
        productAdaptor = new CartAdaptor(getContext(),cartItems);
        rvCartList.setAdapter(productAdaptor);

    }

    private void getAllProduct() {

        myRef.child("users").child("user01").child("cartItems").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Product allProduct=dataSnapshot.getValue(Product.class);
                cartItems.add(allProduct);
                double subTotal=0;
                for(Product product : cartItems) {
                    subTotal += product.getPrice() * product.getQuantity();
                    if (product.getQuantity()==1){
                        tvTotalItems.setText(product.getQuantity()+" item");
                    }else {
                        tvTotalItems.setText(product.getQuantity()+" items");
                    }
                    tvSubTotal.setText("EGP "+String.valueOf(subTotal));
                    tvTotalPrice.setText(String.valueOf(subTotal));
                }
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
