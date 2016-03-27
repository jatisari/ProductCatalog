package net.agusharyanto.productcatalog;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by agus on 3/27/16.
 * agus.superwriter@gmail.com
 * http://agusharyanto.net
 */
public class ProductAdapter extends ArrayAdapter<Product>{
    Context context;

    public ProductAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {

        TextView tvName;
        TextView tvPrice;
        ImageView ivProduct;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Product product = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_product, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.textViewPrice);
            holder.ivProduct = (ImageView) convertView.findViewById(R.id.imageViewProduct);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText("Rp"+product.getPrice());
        int imageid = context.getResources().getIdentifier(product.getImage(), "drawable", context.getPackageName());
        try {
            Picasso.with(context)
                    .load(imageid)
                    .fit()
                    .centerInside()
                    .into(holder.ivProduct);
        }catch (Exception e){
            Log.d("TAG","product:"+product.getName());
        }
        return convertView;
    }
}
