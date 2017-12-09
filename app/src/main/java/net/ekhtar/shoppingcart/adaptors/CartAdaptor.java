package net.ekhtar.shoppingcart.adaptors;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.ekhtar.shoppingcart.R;
import net.ekhtar.shoppingcart.fragments.ProductDetailsFragment;
import net.ekhtar.shoppingcart.models.Product;

import java.util.List;

/**
 * Created by Hossam Magdy on 12/8/2017.
 */

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.CartViewHolder> {
    private Context context;
    private List<Product> cartList;

    public CartAdaptor(Context context, List<Product> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false)));
    }

    @Override
    public void onBindViewHolder(final CartViewHolder holder, int position) {
        final Product cartProduct=cartList.get(position);
        holder.tvProductName.setText(cartProduct.getName());
        holder.tvProductPrice.setText(String.valueOf(cartProduct.getPrice()));
        Picasso.with(context).load(cartProduct.getImge1()).into(holder.ivProductPic);

        holder.tvQty.setText(String.valueOf(cartProduct.getQuantity()));
        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty=cartProduct.getQuantity();
                if (qty<5){
                    cartProduct.setQuantity(qty+1);
                    holder.tvQty.setText(String.valueOf(cartProduct.getQuantity()));
                }else {
                    Toast.makeText(context, "Maximum Quantity is "+qty, Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.ivSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty=cartProduct.getQuantity();
                if (qty>1){
                    cartProduct.setQuantity(qty-1);
                    holder.tvQty.setText(String.valueOf(cartProduct.getQuantity()));
                }else {
                    Toast.makeText(context, "Minimum Quantity is "+qty, Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.llCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                ProductDetailsFragment detailsFragment= new ProductDetailsFragment();
                bundle.putParcelable("product",cartProduct);
                detailsFragment.setArguments(bundle);
                ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, detailsFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProductPic;
        ImageView ivAdd;
        ImageView ivSub;
        TextView tvProductName;
        TextView tvProductPrice;
        TextView tvQty;
        LinearLayout llCartItem;

        public CartViewHolder(View itemView) {
            super(itemView);
            ivProductPic=(ImageView) itemView.findViewById(R.id.imageView2);
            ivAdd=(ImageView) itemView.findViewById(R.id.ivAdd_CartItem);
            ivSub=(ImageView) itemView.findViewById(R.id.ivSub_CartItem);
            tvProductName=(TextView) itemView.findViewById(R.id.tvName_CartItem);
            tvProductPrice=(TextView) itemView.findViewById(R.id.tvPrice_CartItem);
            tvQty=(TextView) itemView.findViewById(R.id.tvQty_CartItem);
            llCartItem=(LinearLayout)itemView.findViewById(R.id.llCartItem_CartItem);
        }
    }
}
