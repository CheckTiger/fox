package cn.sxh.fox;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @package-name: cn.sxh.fox
 * @auther:snowFox
 * @Email:snowTigersong@gmail.com
 * @time: 2018/9/30 0030 : 10 :15
 * @project-name: fox
 */

public class ArcPointLoadingView extends View {

    private int mCenterX, mCenterY;
    private Paint mPaint;
    private Path mPath;
    private Path mPath1;

    private int mStartAngle = 30;
    private int mDistanceAngle = 0;
    private int mRadius = 150;

    private int mCircleRadius = 25;
    private int mCircleDistance = 50;
    private int mCircleSweep = 0;

    private ValueAnimator mValueAnimator;
    private ValueAnimator mCircleAnimator;

    public ArcPointLoadingView(Context context) {
        super(context);
        init();
    }

    public ArcPointLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcPointLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30f);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
        mPath1 = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            mCenterX = w/2;
            mCenterY = h / 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        calculatePath();
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float textBaseY = fontHeight/2;
        canvas.drawText("杨瑶珍", mCenterX + mRadius + mCircleDistance + mCircleRadius - mCircleSweep,
                mCenterY + textBaseY / 2, mPaint);
        canvas.drawPath(mPath, mPaint);
//        canvas.drawPath(mPath1, mPaint);
    }

    private void calculatePath() {
        mPath.reset();
        mPath.moveTo(mCenterX, mCenterY);
        int tmpStartAngle = mStartAngle - mDistanceAngle;
        mPath.lineTo(mCenterX + (float) (mRadius * Math.cos(Math.PI * tmpStartAngle / 180)),
                mCenterY + (float) (mRadius * Math.sin(Math.PI * tmpStartAngle / 180)));
        mPath.addArc(new RectF(mCenterX - mRadius,
                        mCenterY - mRadius,
                        mCenterX + mRadius,
                        mCenterY + mRadius), tmpStartAngle,
                330-mStartAngle + mDistanceAngle * 2);
        mPath.lineTo(mCenterX, mCenterY);

    }

    public void startAnimation() {
        //怪物脸动画
        mValueAnimator = ValueAnimator.ofInt(1, mStartAngle);
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setRepeatMode(ValueAnimator.RESTART);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDistanceAngle = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        //食物的位移动画
        mCircleAnimator = ValueAnimator.ofInt(0, mCenterX + mRadius +mCircleRadius);
        mCircleAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mCircleAnimator.setRepeatCount(-1);
        mCircleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCircleSweep = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(mValueAnimator,mCircleAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }
}