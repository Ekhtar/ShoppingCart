package net.ekhtar.shoppingcart.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.ekhtar.shoppingcart.R;
import net.ekhtar.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment {

    private TextView tvName;
    private TextView tvPrice;
    private SliderLayout slProductPic;
    private String [] productImages;
    private TextView addToCart;
    private boolean isCartEmpty;
    private ArrayList<Product> cartItems;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        slProductPic =(SliderLayout) view.findViewById(R.id.slider);
        tvName =(TextView) view.findViewById(R.id.tvName_ProductDetails);
        tvPrice = (TextView) view.findViewById(R.id.tvPrice_ProductDetails);
        addToCart=(TextView)view.findViewById(R.id.text_action_bottom1) ;

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();

        final Product currentProduct= getArguments().getParcelable("product");
        productImages = new String[]{currentProduct.getImge1(), currentProduct.getImge2(), currentProduct.getImge3(), currentProduct.getImge4(), currentProduct.getImge5(), currentProduct.getImge6()};
        tvName.setText(currentProduct.getName());
        tvPrice.setText(String.valueOf(currentProduct.getPrice()) +" EGP");

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddtoMyCart(currentProduct);
            }
        });

        initSliderProductPic(productImages,view);
    }

    private void initSliderProductPic(String [] images,View view) {

        for (int i = 0; i < images.length; i++) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(view.getContext());
            defaultSliderView.image(images[i]);
            slProductPic.addSlider(defaultSliderView);
        }

        slProductPic.setPresetTransformer(SliderLayout.Transformer.Default);
        slProductPic.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slProductPic.setCustomAnimation(new DescriptionAnimation());
        slProductPic.setDuration(4000);
        slProductPic.setCustomIndicator((PagerIndicator) view.findViewById(R.id.custom_indicator));
    }

    private void AddtoMyCart(final Product product){
        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                isCartEmpty = !((Boolean) dataSnapshot.child("cartItems").exists());
                if (isCartEmpty){
                    Map<String, Object> cartItemsMap = new HashMap<>();
                    cartItemsMap.put("product01", product);
                    myRef.child("users").child("user01").child("cartItems").updateChildren(cartItemsMap);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
