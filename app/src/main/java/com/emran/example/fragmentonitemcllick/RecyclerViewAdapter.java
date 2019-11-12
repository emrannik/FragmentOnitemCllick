package com.emran.example.fragmentonitemcllick;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
  Context mContext;
  List<InfoModel> mData;
  Dialog mDialog;

  public RecyclerViewAdapter(Context mContext,List<InfoModel> mData){
      this.mContext=mContext;
      this.mData=mData;
  }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_info,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(v);
      //Dialog initialize//
        mDialog=new Dialog(mContext);
        mDialog.setContentView(R.layout.dialog_alert);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       //end


      // On ItemClick Lisner//
        myViewHolder.item_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AlertDialog initialize
                TextView dialog_name=(TextView)mDialog.findViewById(R.id.dialog_name) ;
                TextView dialog_phone=(TextView)mDialog.findViewById(R.id.dialog_phone) ;
                ImageView dialog_img=(ImageView)mDialog.findViewById(R.id.aler_img);
                dialog_name.setText(mData.get(myViewHolder.getAdapterPosition()).getName());
                dialog_phone.setText(mData.get(myViewHolder.getAdapterPosition()).getPhone());
                dialog_img.setImageResource(mData.get(myViewHolder.getAdapterPosition()).getPhoto());
                //end
                Toast.makeText(mContext,"Test Click"+String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_LONG).show();
                mDialog.show();
            }
        });
        //end
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textName.setText(mData.get(position).getName());
        holder.textPhone.setText(mData.get(position).getPhone());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

      private TextView textName;
      private TextView textPhone;
      private ImageView img;
      private LinearLayout item_linear;
        public MyViewHolder(View itemView){
            super(itemView);
             item_linear=(LinearLayout)itemView.findViewById(R.id.item_linearlayout);
            textName=(TextView)itemView.findViewById(R.id.info_name);
            textPhone=(TextView)itemView.findViewById(R.id.phone);
            img=(ImageView)itemView.findViewById(R.id.img_info);
        }

    }
}
