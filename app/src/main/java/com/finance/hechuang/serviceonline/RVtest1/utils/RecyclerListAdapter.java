package com.finance.hechuang.serviceonline.RVtest1.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 15-11-3.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder> {

    private List<ViewItem> mItems = new ArrayList<>();


    public RecyclerListAdapter(Context context, List<ViewItem> mItems) {
        this.mItems = mItems;
    }

    public RecyclerListAdapter(Context context) {
    }


    public void updateAdapter(List<ViewItem> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    //------------set on click----------
    private OnAdapterClick onClick=null;
    public void setAdapterClickListener(OnAdapterClick onClick){
        this.onClick=onClick;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.textView.setText(mItems.get(position).mainText);

//        Log.i("AAA","holder.getLayoutPosition():"+holder.getLayoutPosition()+"  position:"+position);
// holder.getLayoutPosition() is the same as position

        if (onClick!=null) {
            holder.netImage.setClickable(true);
            holder.netImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onItemClick(mItems.get(position),position);
                }
            });
        }



        final Callable<Bitmap> bitmapCallable = new Callable<Bitmap>() {
            @Override
            public Bitmap call() throws Exception {
                URL url = new URL(mItems.get(position).imagaURL);
                HttpURLConnection htc = (HttpURLConnection) url.openConnection();
                InputStream is = new BufferedInputStream(htc.getInputStream());
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            }
        };


        Observable<Bitmap> bitmapObservable = Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                try {
                    subscriber.onNext(bitmapCallable.call());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Subscriber<Bitmap> imageSubscriber = new DefaultSubscriber<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.i("AAA", "----");
                holder.netImage.setImageBitmap(bitmap);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("AAA", Log.getStackTraceString(e));
            }
        };


        bitmapObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(imageSubscriber);

    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView;
        public final ImageView netImage;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            netImage = (ImageView) itemView.findViewById(R.id.netImage);
        }

    }



    //------- Handle clicking--------
    public interface OnAdapterClick{
        void onItemClick(ViewItem item,int number);
        void onItemLongClick(ViewItem item,int number);
    }
}
