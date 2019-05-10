package com.dingptech.indexslibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LetterIndexView extends View {

    private Context mContext;
    private Paint mPaint;
    private String[] mLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String mTouchLetter;
    private boolean mCurrentIsTouch;
    private IndexTouchListener mTouchListener;
    public LetterIndexView(Context context) {
        this(context, null);
    }


    public LetterIndexView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterIndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(DensityUtil.sp2px(this.getContext(), 14));
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float singleHeight = ( float ) getHeight() / mLetters.length;
        for (int i = 0; i < mLetters.length; i++) {
            String letter = mLetters[i];
            Rect rect = new Rect();
            mPaint.getTextBounds(letter, 0, letter.length(), rect);
            float measureTextWidth = rect.width();
            int contentWidth = getWidth() - getPaddingLeft() - getPaddingRight();
            float x = getPaddingLeft() + (contentWidth - measureTextWidth) / 2;
            Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
            float baseLine = singleHeight / 2 + (singleHeight * i) +
                    (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
            if (mLetters[i].equals(mTouchLetter) && mCurrentIsTouch) {
                mPaint.setTextSize(DensityUtil.sp2px(mContext, 18));
                mPaint.setColor(Color.RED);
                canvas.drawText(letter, x, baseLine, mPaint);
            } else {
                mPaint.setTextSize(DensityUtil.sp2px(mContext, 14));
                mPaint.setColor(Color.BLACK);
                canvas.drawText(letter, x, baseLine, mPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float currentMoveY = ( int ) event.getY();
                int itemHeight = (getHeight() - getPaddingTop() - getPaddingBottom()) / mLetters.length;
                int currentPosition = ( int ) currentMoveY / itemHeight;
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                if (currentPosition > mLetters.length - 1) {
                    currentPosition = mLetters.length - 1;
                }
                mTouchLetter = mLetters[currentPosition];
                mCurrentIsTouch = true;
                if (mTouchListener != null) {
                    mTouchListener.onTouch(mTouchLetter, true);
                }
                break;
            case MotionEvent.ACTION_UP:
                mCurrentIsTouch = false;
                if (mTouchListener != null) {
                    mTouchListener.onTouch(mTouchLetter, false);
                }
                break;
        }
        invalidate();
        return true;
    }


    public void setOnLetterTouchListener(IndexTouchListener touchListener) {
        this.mTouchListener = touchListener;
    }

}
