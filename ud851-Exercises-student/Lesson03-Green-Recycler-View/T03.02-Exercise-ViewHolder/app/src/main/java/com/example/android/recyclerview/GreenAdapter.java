/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {


    private static final String TAG = GreenAdapter.class.getSimpleName();

    private int mNumberItems;

    final public ListItemClickListner listItemListner ;

    public GreenAdapter(int numberOfItems, ListItemClickListner listner) {
        mNumberItems = numberOfItems;
        listItemListner =listner;
    }

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.add_numbers;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    // TODO (12) Create a class called NumberViewHolder that extends RecyclerView.ViewHolder

    // TODO (13) Within NumberViewHolder, create a TextView variable called listItemNumberView

    // TODO (14) Create a constructor for NumberViewHolder that accepts a View called itemView as a parameter
    // TODO (15) Within the constructor, call super(itemView) and then find listItemNumberView by ID

    // TODO (16) Within the NumberViewHolder class, create a void method called bind that accepts an int parameter called listIndex
    // TODO (17) Within bind, set the text of listItemNumberView to the listIndex
    // TODO (18) Be careful to get the String representation of listIndex, as using setText with an int does something different
    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView lstItemView ;

        public NumberViewHolder(View itemView) {
            super(itemView);
            lstItemView = (TextView) itemView.findViewById(R.id.txt_item_number);
            itemView.setOnClickListener(this);

        }
        public void bind (int index) {lstItemView.setText(String.valueOf(index));}

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listItemListner.onListItemClickListener(position);

        }
    }

    public interface ListItemClickListner{
        void onListItemClickListener (int index);
    }
    }



