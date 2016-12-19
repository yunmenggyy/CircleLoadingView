package zxyilian.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import zxyilian.com.myapplication.ui.CircleLoadingView;
import zxyilian.com.myapplication.ui.ProgressWheel;
import zxyilian.com.myapplication.ui.ZorroFrameHelper;

public class MainActivity extends AppCompatActivity {
    //private ProgressWheel progressWheel;
    private CircleLoadingView circleLoadingView;
    private RecyclerView mRecycleView;
    private ArrayList<Integer> list;
    private ListView listView;
    private ImageView imageView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_main);

        TextView textView1 = (TextView) findViewById(R.id.text1);
        TextView textView2 = (TextView) findViewById(R.id.text2);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/scyahei.ttf");
        textView1.setTypeface(face);
        textView1.setText("世界你好！");


        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Hiragino Sans GB W32.ttf");
        textView2.setTypeface(face2);
        textView2.setText("世界你好！");*/

/*
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));*/

/*        progressWheel = (ProgressWheel) findViewById(R.id.pw_spinner);
        progressWheel.startSpinning();

        CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar1);
        seekbar.getProgress();
        seekbar.setProgress(50);*/

/*        setContentView(R.layout.circle_loadingview_layout);
        tadpole = (ImageView) findViewById(R.id.tadpole);
        anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        anim.setInterpolator(new LinearInterpolator());*/

        //tadpole.startAnimation(anim);

/*        setContentView(R.layout.activity_main);
        circleLoadingView = (CircleLoadingView) findViewById(R.id.circleLoading);*/
/*        setContentView(R.layout.activity_main);

        initData();
        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new HomeAdapter());*/
        //mRecycleView.addItemDecoration(new DividerItemDecoration());
        //mRecycleView.scrollToPosition(300);



/*        setContentView(R.layout.activity_main2);
        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<1500;i++) arrayList.add(String.valueOf(i));

        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList));*/


        //imageView = (ImageView) findViewById(R.id.myImage);

/*        Paint paint = new Paint();
        paint.setColor(Color.RED );
        paint.setAntiAlias(true); // 打开抗矩齿
        paint.setStrokeWidth(2);
        Bitmap b = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(b);
        canvas.drawRect(new Rect(100,100,400,400),paint);
        imageView.setImageBitmap(b);*/


        //ZorroFrameHelper zorroFrameHelper = new ZorroFrameHelper(this,imageView);

/*        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);*/

        LinkedList<String> linkedList1 = new LinkedList<>();
        LinkedList<String> linkedList2 = new LinkedList<>();

        linkedList1.add("hahaha");
        linkedList1.add("hehehe");
        linkedList1.add("enenene");
        linkedList1.add("lalala");

        linkedList2.add("kakaka");
        linkedList2.add("mamama");
        Iterator<String> iterator2 = linkedList2.iterator();

        while (iterator2.hasNext()){
            iterator2.next();
            iterator2.remove();
            //iterator2.next();
        }

        System.out.println("size==="+linkedList2.size());
    }


    public void returnOrigin(View view){
        //mRecycleView.scrollToPosition(300);
        //mRecycleView.smoothScrollToPosition(list.size()-1);
        //listView.setSelection(2000);
/*        listView.post(new Runnable() {
            @Override
            public void run() {
                listView.smoothScrollToPosition(listView.getAdapter().getCount() - 1);
            }
        });*/
        //listView.smoothScrollToPosition(listView.getAdapter().getCount() - 1);
        //imageView.setImageResource(R.mipmap.sunwukong);
        myAdapter.setData(new int[100]);

    }

    @Override
    public void onBackPressed() {
        listView.smoothScrollToPosition(0);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i=0;i<1000;i++){
            list.add(i);
        }
    }


    private final class HomeAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            /*return new MyViewHolder(View.inflate(MainActivity.this,R.layout.item,null));*/
            return new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item2, parent,
                    false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(String.valueOf(list.get(position)));
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private final class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    private final class MyAdapter extends BaseAdapter{
        private int[] counts = new int[2];

        public void setData(int[] data){
            this.counts = data;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return counts.length;
        }

        @Override
        public Object getItem(int position) {
            return counts[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView==null){
                convertView = View.inflate(MainActivity.this,R.layout.single_image,null);
                holder = new Holder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }
            holder.imageView.setImageResource(R.mipmap.me);
            return convertView;
        }
    }

    private static class Holder{
        public ImageView imageView;
    }
}
