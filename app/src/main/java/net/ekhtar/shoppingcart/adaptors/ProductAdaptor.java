package net.ekhtar.shoppingcart.adaptors;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.ekhtar.shoppingcart.R;
import net.ekhtar.shoppingcart.fragments.ProductDetailsFragment;
import net.ekhtar.shoppingcart.fragments.ProductsFragment;
import net.ekhtar.shoppingcart.models.Product;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Hossam Magdy on 12/8/2017.
 */

public class ProductAdaptor extends RecyclerView.Adapter<ProductAdaptor.ProductViewHolder> {
    private List<Product> productList;
    private Context context;

    public ProductAdaptor(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.name.setText(product.getName());
        holder.brand.setText(product.getBrand());
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.llProductItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                ProductDetailsFragment detailsFragment= new ProductDetailsFragment();
                bundle.putParcelable("product",product);
                detailsFragment.setArguments(bundle);
                ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, detailsFragment).addToBackStack(null).commit();
            }
        });
        Picasso.with(context)
                .load(product.getImge1())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price, brand;
        private ImageView image, like;
        private RatingBar rating;
        private LinearLayout llProductItem;
        public ProductViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvMyOrder_MyAccount);
            brand=itemView.findViewById(R.id.textView2);
            image=itemView.findViewById(R.id.imageView4);
            price = itemView.findViewById(R.id.textView10);
            llProductItem = itemView.findViewById(R.id.llProductItem_ProductHorizontalItem);
        }
    }
}
