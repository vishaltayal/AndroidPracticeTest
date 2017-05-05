package com.example.android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MOLDEDBITS on 05-05-2017.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder {

    TextView lstItemView ;

    public NumberViewHolder(View itemView) {
        super(itemView);
        lstItemView = (TextView) itemView.findViewById(R.id.txt_item_number);

    }
   public void bind (int index) {lstItemView.setText(String.valueOf(index));}
}

