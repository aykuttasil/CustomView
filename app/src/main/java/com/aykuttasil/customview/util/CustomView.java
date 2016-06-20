package com.aykuttasil.customview.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.aykuttasil.customview.R;

/**
 * Created by aykutasil on 20.06.2016.
 */
public class CustomView extends View {

    private String TAG = CustomView.class.getSimpleName();

    Paint paint;
    String color;
    float size;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomView,
                0,
                0);

        try {
            color = typedArray.getString(R.styleable.CustomView_a_color);
            size = typedArray.getDimension(R.styleable.CustomView_a_size, 30f);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            typedArray.recycle();
        }

        Log.i(TAG, "Color: " + String.valueOf(color));
        Log.i(TAG, "Size: " + String.valueOf(size));
        //Yuvarlagın rengini belirledik
        paint = new Paint();
        paint.setColor(Color.parseColor(color));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(size, size, size, paint);
    }
}
