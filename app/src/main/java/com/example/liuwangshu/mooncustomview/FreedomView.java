package com.example.liuwangshu.mooncustomview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/8/18/018.
 */

public class FreedomView extends View {
    private static final String TAG = "CustomView";

    private int lastX;
    private int lastY;

    public FreedomView(Context context) {
        super(context);
    }

    public FreedomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //getX():相对于控件的位置，getRowX():相对于屏幕的位置
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
               /* Log.i(TAG, "onTouchEvent: lastXY:(" + lastX + ", " + lastY + ")"
                        + " XY:(" + x + ", " + y + ")");*/

               //移动视图位置
                layout(getLeft() + offsetX, getTop() + offsetY,
                        getRight() + offsetX, getBottom() + offsetY);
                break;
        }

        return true;
    }
}
