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

//10延伸recyclerview的adapter類別, 並自行輸入此類別名跟建一個viewhoilder類別,
// AA後載入3方法
//11viewholder類別延伸recycler類別又viewholder類別,AA後產生建構子
//宣告對應子介面元件的變數
//變數對應子介面元件
//按鈕設定反應監聽(建畫面類別)
//12印出訊息已購票(動作取得連接之子介面)
//13宣告陣列view類別之變數
//14改回到數量的值
//15到oncreate建,view類別設變數,打氣類別從(連接)做取得動作,打氣(子介面)值false
//16資料綁定,主持人做動作
// 動作-圖,動作圖片資源(介面類別變數,取得位置,取得介面圖片設定)
// 動作-載入文字,動作(介面類別變數,取得位置,取得介面文字設定)*3
//(只處理view,還沒處理到data)
//19沒使用到變數產生建構子

public class recycleradapterClass extends RecyclerView.Adapter<recycleradapterClass.ViewHolder> {
    private ArrayList<viewClass> viewclass;

    public recycleradapterClass(ArrayList<viewClass> viewclass) {
        this.viewclass = viewclass;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//建立視覺容器
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        ViewHolder viewholder = new ViewHolder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//跟viewholder做串接
        holder.imageiew.setImageResource(viewclass.get(position).pic);
        holder.txtname.setText(viewclass.get(position).name);
        holder.txtdate.setText(viewclass.get(position).date);
        holder.txtinfo.setText(viewclass.get(position).info);
    }

    @Override
    public int getItemCount() {
        return viewclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageiew;
        private TextView txtname,txtdate,txtinfo;
        private Button btnbuy;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageiew = itemView.findViewById(R.id.imageView);
            txtname = itemView.findViewById(R.id.textName);
            txtdate = itemView.findViewById(R.id.textDate);
            txtinfo = itemView.findViewById(R.id.textInfo);
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
