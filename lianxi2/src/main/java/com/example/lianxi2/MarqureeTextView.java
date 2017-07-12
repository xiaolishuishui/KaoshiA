package com.example.lianxi2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/7.
 */

public class MarqureeTextView extends TextView {

    public MarqureeTextView(Context context) {
        super(context);
    }

    public MarqureeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqureeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MarqureeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
