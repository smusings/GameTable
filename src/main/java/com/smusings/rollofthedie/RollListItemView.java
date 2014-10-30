package com.smusings.rollofthedie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class RollListItemView extends TextView{

    //the roll list item view
	public RollListItemView(Context context, AttributeSet ats, int ds){
		super(context, ats, ds);
		init();
	}
	
	public RollListItemView(Context context){
		super(context);
		init();
	}
	
	public RollListItemView(Context context, AttributeSet attrs){
		super(context, attrs);
		init();
	}

    //sets up how the itemview looks
	private Paint linePaint;
	private int paperColor;
	
	private void init(){
		Resources myResources = getResources();

		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myResources.getColor(R.color.LightBlue));
		paperColor = myResources.getColor(R.color.AntiqueWhite);
	}
	
	@Override 
	public void onDraw(Canvas canvas){
		canvas.drawColor(paperColor);
		
		canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
		canvas.drawLine(0, getMeasuredHeight(),
				getMeasuredWidth(), getMeasuredHeight(), linePaint);

		
		canvas.save();
		
		super.onDraw(canvas);
		canvas.restore();
	}
}
