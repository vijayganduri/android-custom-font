package com.android.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.vijayganduri.customfont.R;

/**
 * 
 * 
 * @Author Vijay Ganduri
 */
public class CustomFontTextView extends TextView {

	public CustomFontTextView(Context context) {
		super(context);
		setCustomFont(context, null);
	}

	public CustomFontTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if(!isInEditMode()){
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
			String customFontName = a.getString(R.styleable.CustomFont_customTypeface);
			a.recycle();

			setCustomFont(context, customFontName);
		}
	}

	public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode()){
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
			String customFontName = a.getString(R.styleable.CustomFont_customTypeface);
			a.recycle();

			setCustomFont(context, customFontName);
		}
	}

	public boolean setCustomFont(Context ctx, String customFontName) {
		if(customFontName==null){
			customFontName = ctx.getResources().getString(R.string.font_light);
		}

		Typeface typeface = TypefaceCache.get(ctx, customFontName);

		if(typeface!=null){
			setTypeface(typeface);
			return true;
		}else{
			return false;
		}
	}

}