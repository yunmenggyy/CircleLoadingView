package zxyilian.com.myapplication.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zxyilian.com.myapplication.R;

/**
 * this View is a loading ProgressBar view,it can be used to
 * show the progress
 * Created by GuanYangYi on 2016/11/4.
 */

public class CircleLoadingView extends RelativeLayout {
    private Context context;
    private View rootView;
    private float centerTextSize = 40;
    private int centerTextColor = 0xFF000000;
    private float centerDownTextSize = 12;
    private int centerDownTextColor = 0xFFDDDDDD;
    private ImageView tadPoleImg,bacImg;
    private Button startBtn;
    private TextView centerText,centerDownText;
    private Animation animation;
    private float startValue = 12;
    private float decreaseTimeInterVal = 200;
    private float decreaseInterUnit = 0.5f;
    private boolean isLoading;



    public CircleLoadingView(Context context) {
        super(context);
        init(context,null, 0);
    }

    public CircleLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public CircleLoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }


    private void init(Context context, AttributeSet attrs, int defStyle){
        this.context = context;
        if (attrs!=null){
            final TypedArray attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.CircularSeekBar, defStyle, 0);
            initAttributes(attrArray);
            attrArray.recycle();
        }
    }

    private void initAttributes(TypedArray attrArray) {
        centerTextSize = attrArray.getDimension(R.styleable.CircleLoadingView_centerTextSize,40);
        centerTextColor = attrArray.getColor(R.styleable.CircleLoadingView_centerTextColor,0xFF000000);
        centerDownTextSize = attrArray.getDimension(R.styleable.CircleLoadingView_centerDwonTextSize,12);
        centerDownTextColor = attrArray.getColor(R.styleable.CircleLoadingView_centerDwonTextColor,0xFFDDDDDD);
        startValue = attrArray.getInt(R.styleable.CircleLoadingView_startValue,10);
        decreaseTimeInterVal = attrArray.getInt(R.styleable.CircleLoadingView_decreaseInterVal,200);
        decreaseInterUnit = attrArray.getFloat(R.styleable.CircleLoadingView_decreaseInterUnit,0.5f);
        attrArray.recycle();

        rootView = View.inflate(context,R.layout.circle_loadingview_layout,null);

        startBtn = (Button)rootView.findViewById(R.id.controlBtn);
        startBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoading){
                    isLoading = true;
                    start();
                }else{
                    stop();
                }
            }
        });


        tadPoleImg = (ImageView) rootView.findViewById(R.id.tadpole);

        centerText = (TextView) rootView.findViewById(R.id.centerText);
        centerDownText = (TextView) rootView.findViewById(R.id.centerDownText);
        bacImg = (ImageView) rootView.findViewById(R.id.bacImg);

        centerDownText.setTextSize(centerDownTextSize);
        centerText.setTextSize(centerTextSize);
        centerDownText.setTextColor(centerDownTextColor);
        centerText.setTextColor(centerTextColor);


        animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        animation .setInterpolator(new LinearInterpolator());

        addView(rootView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setCenterText(String string){
        if (!TextUtils.isEmpty(string)){
            centerText.setText(string);
        }
    }

    public void setCenterDwonText(String string){
        if (!TextUtils.isEmpty(string)){
            centerDownText.setText(string);
        }
    }

    public void start(){
        myHandler.sendEmptyMessage(MyHandler.START);
    }

    public void stop(){
        myHandler.sendEmptyMessage(MyHandler.STOP);
    }



    private MyHandler myHandler = new MyHandler();
    private final class MyHandler extends Handler{
        public final static int START = 1;
        public final static int STOP = 3;
        public final static int CIRCULATE = 2;


        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case START:
                    bacImg.setImageResource(R.mipmap.loading);
                    tadPoleImg.startAnimation(animation);
                    sendEmptyMessageDelayed(CIRCULATE, (long) decreaseTimeInterVal);
                    break;

                case CIRCULATE:
                    if (startValue-decreaseInterUnit>0){
                        startValue -= decreaseInterUnit;
                        centerText.setText(String.valueOf(startValue));
                        centerDownText.setText("M");
                        sendEmptyMessageDelayed(CIRCULATE,(long) decreaseTimeInterVal);
                    }else{
                        sendEmptyMessage(STOP);
                    }
                    break;

                case STOP:
                    startValue -= decreaseInterUnit;
                    tadPoleImg.clearAnimation();
                    centerText.setText(startValue>0?String.valueOf(startValue): String.valueOf(0));
                    if (startValue<=0){
                        centerDownText.setText("清除完成");
                        tadPoleImg.setVisibility(View.GONE);
                        bacImg.setImageResource(R.mipmap.complete);
                    }
                    isLoading = false;
                    break;
            }
        }
    }
}
