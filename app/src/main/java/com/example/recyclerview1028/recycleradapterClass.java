package com.example.recyclerview1028;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class recycleradapterClass extends RecyclerView.Adapter<recycleradapterClass.ViewHolder> {
//12延伸recyclerview.adapter類別,自行輸入<>,在裡面貼上recycleradapterClass.ViewHolder
//13紅後Create class ViewHolder
//14還紅,Implement methods*3

//15宣告(共3)
    private ArrayList<viewClass> viewclass;
//(下方viewholder只處理view沒有data)
//產生建構子(開門讓資料進來)
    public recycleradapterClass(ArrayList<viewClass> viewclass) {
        this.viewclass = viewclass;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                       ///建立視覺容器
//17(4)
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview,parent,false);
                                 //inflate到itemview
        ViewHolder viewholder = new ViewHolder(v);
        return viewholder;
              //透過ViewHolder傳達return到MainActivity(注意不是v)
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                                          //上面已經回傳到viewholder
//跟viewholder做串接
//18(4)
        holder.imageview.setImageResource(viewclass.get(position).pic);
        holder.txtname.setText(viewclass.get(position).name);
        holder.txtdate.setText(viewclass.get(position).date);
        holder.txtinfo.setText(viewclass.get(position).info);
    }

    @Override
    public int getItemCount() {
               //看有幾筆資料
//16改值(1)
        return viewclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//19                      extends RecyclerView.ViewHolder
//20紅,Create constructor matching super(主要產生跟要處理 itemview)
//21宣告
        private ImageView imageview;
        private TextView txtname,txtdate,txtinfo;
        private Button btnbuy;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

//22(這邊是類別不是activity所以要透過)子介面指定id
            imageview = itemView.findViewById(R.id.imgCover);
            txtname = itemView.findViewById(R.id.txtName);
            txtdate = itemView.findViewById(R.id.txtDate);
            txtinfo = itemView.findViewById(R.id.txtInfo);
            btnbuy = itemView.findViewById(R.id.btnBuy);
            btnbuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"已購票",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
//23回MainActivity結合
