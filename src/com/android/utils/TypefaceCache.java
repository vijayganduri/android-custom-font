package com.android.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * 
 * 
 * @Author Vijay Ganduri
 */
public class TypefaceCache{

	private static final String TAG = TypefaceCache.class.getName();

	private static LruCache<String, Typeface> sTypefaceCache =
			new LruCache<String, Typeface>(12);

	public static Typeface get(Context ctx, String customFontName) {

		if(sTypefaceCache == null){
			sTypefaceCache = new LruCache<String, Typeface>(4);
		}

		Typeface typeface = sTypefaceCache.get(customFontName);

		if(typeface == null){
			try {
				typeface = Typeface.createFromAsset(ctx.getAssets(), customFontName);
				sTypefaceCache.put(customFontName, typeface);
			} catch (Exception e) {
				Log.e(TAG, "Typeface not loaded. Shows system font : "+e.getMessage());
				return null;
			}
		}
		return typeface;
	}

	public void clear(){
		if(sTypefaceCache!=null){
			sTypefaceCache.evictAll();
			sTypefaceCache = null;
		}
	}

}