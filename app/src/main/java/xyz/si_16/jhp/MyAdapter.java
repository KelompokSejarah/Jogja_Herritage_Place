package xyz.si_16.jhp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<wisataData> mWisataData;
    private GradientDrawable mGradientDrawable;

    static class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public TextView mJudul;
        public ImageView mImage;
        private Context mContext;
        private wisataData mCurrentSport;
        private GradientDrawable mGradientDrawable;

        MyViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mJudul = (TextView) itemView.findViewById(R.id.id.ivJudul);
            mImage = (ImageView) itemView.findViewById(R.id.ivImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        void bindTo(wisataData currentSport){
            mJudul.setText(currentSport.getWisataName());
            mCurrentSport = currentSport;

            Glide.with(mContext).load(currentSport.getWisataImage())
                    .placeholder(mGradientDrawable).into(mImage);
        }

        @Override
        public void onClick(View v) {
            Intent detailIntent = wisataData.startr(mContext, mCurrentSport.getWisataName(),
                    mCurrentSport.getWisataImage());
            mContext.startActivity(detailIntent);
        }
    }

    public MyAdapter(Context mContext, ArrayList<wisataData> sportData){
        this.mContext = mContext;
        this.mWisataData = sportData;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new MyViewHolder(itemView);*/

        return new MyViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.recyclerview_item_row, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        wisataData currentSport = mWisataData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mWisataData.size();
    }

}
