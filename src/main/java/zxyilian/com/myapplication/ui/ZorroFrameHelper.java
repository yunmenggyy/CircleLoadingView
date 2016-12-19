package zxyilian.com.myapplication.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.LoginFilter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ZorroFrameHelper implements View.OnTouchListener {

    private final Context context;
    private final ImageView view;
    private int downRawX;
    private int downRawY;
    private int moveRawX;
    private int moveRawY;
    private Paint paint;
    private Canvas canvas;
    private Bitmap b;


    public ZorroFrameHelper(Context context, ImageView view){
        this.context = context;
        this.view = view;
        initView(view);
    }

    private void initView(ImageView view) {

        view.setOnTouchListener(this);

        //初始化 画笔
        paint = new Paint();
        paint.setColor(Color.RED );
        paint.setAntiAlias(true); // 打开抗矩齿
        paint.setStrokeWidth(10);

        /*------------------------这里是我的全屏的坐标画布的大小----------------------------------------------*/
        b = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView iv = (ImageView) v;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v(getClass().getSimpleName(),"action---down");
                downRawX = (int) event.getRawX();
                downRawY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.v(getClass().getSimpleName(),"action---move");
                moveRawX = (int) event.getRawX();
                moveRawY = (int) event.getRawY();
                canvas.drawRect(new Rect(downRawX,downRawY,moveRawX,moveRawY),paint);
                view.setImageBitmap(b);

                break;
            case MotionEvent.ACTION_UP:
                Log.v(getClass().getSimpleName(),"action---up");
                break;
        }
        return true;
    }

}
