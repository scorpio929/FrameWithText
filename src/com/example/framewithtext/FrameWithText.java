package com.example.framewithtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FrameWithText extends View {

	private Paint mPaint;
	private String text = "test";
	private int textSize = 20;
	private int paddingTop = 10;
	private int paddingOther = 1;

	private int rectLeft = 20;
	private float rectWidth;
	private int textPadding = 10;

	public FrameWithText(Context context) {
		super(context);
		mPaint = new Paint();
	}

	public FrameWithText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(1);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(0, paddingTop, getMeasuredWidth() - paddingOther, getMeasuredHeight() - paddingOther, mPaint);

		mPaint.setTextSize(20);
		float textWidth = mPaint.measureText(text);

		mPaint.setColor(Color.WHITE);
		mPaint.setStyle(Paint.Style.FILL);
		rectWidth = textWidth + textPadding * 2;
		canvas.drawRect(rectLeft, 0, rectLeft + rectWidth, textSize, mPaint);

		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(1);
		canvas.drawText(text, rectLeft + textPadding, paddingTop + textSize / 2, mPaint);
	}
}
