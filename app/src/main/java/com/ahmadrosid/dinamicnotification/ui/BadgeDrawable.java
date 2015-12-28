package com.ahmadrosid.dinamicnotification.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import com.ahmadrosid.dinamicnotification.R;

/**
 * Created by ocittwo on 12/28/15.
 */
public class BadgeDrawable extends Drawable {

    private float mTextSize;
    private Paint mBadgePaint;
    private Paint mTextPaint;
    private Rect mTextRec = new Rect();
    private String mCount ="";
    private boolean mWilDraw = false;

    public BadgeDrawable(Context context) {
        mTextSize = context.getResources().getDimension(R.dimen.txt_notif_size);

        mBadgePaint = new Paint();
        mBadgePaint.setColor(Color.RED);
        mBadgePaint.setAntiAlias(true);
        mBadgePaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void draw(Canvas canvas) {
        if (!mWilDraw){
            return;
        }

        Rect bounds = new Rect();
        float width = bounds.right - bounds.left;
        float height =  bounds.bottom - bounds.top;

        float radius = ((Math.min(width, height) / 2)- 1) / 2;
        float centerX = width - radius - 1;
        float centerY = height - radius - 1;

        canvas.drawCircle(centerX, centerY, radius, mBadgePaint);

        mTextPaint.getTextBounds(mCount, 0 , mCount.length(), mTextRec);
        float textHeight = mTextRec.bottom - mTextRec.top;
        float textY = centerY + (textHeight / 2f);
        canvas.drawText(mCount, centerX, textY, mTextPaint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    public void setmCount(int count) {
        count = Integer.parseInt(mCount);

        mWilDraw = count > 0;
        invalidateSelf();
    }


}