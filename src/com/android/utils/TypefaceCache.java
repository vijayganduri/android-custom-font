package com.android.utils;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * 
 * 
 * @Author Vijay Ganduri
 */
public class TypefaceCache{

	private static final String TAG = TypefaceCache.class.getName();
	private static HashMap< String, Typeface > typefaceHashMap;

	public static Typeface get(Context ctx, String customFontName) {

		if(typefaceHashMap==null){
			typefaceHashMap = new HashMap< String, Typeface>();
		}

		Typeface typeface = typefaceHashMap.get(customFontName);

		if(typeface == null){
			try {
				typeface = Typeface.createFromAsset(ctx.getAssets(), customFontName);
				typefaceHashMap.put(customFontName, typeface);
			} catch (Exception e) {
				Log.e(TAG, "Typeface not loaded. Shows system font : "+e.getMessage());
				return null;
			}
		}
		return typeface;
	}

	public void clear(){
		if(typefaceHashMap!=null){
			typefaceHashMap.clear();
			typefaceHashMap = null;
		}
	}

}