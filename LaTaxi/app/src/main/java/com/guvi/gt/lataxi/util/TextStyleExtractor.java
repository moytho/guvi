package com.guvi.gt.lataxi.util;

public abstract class TextStyleExtractor {

    public abstract TextStyle[] getTextStyles();

    public TextStyle getTextStyle(String textStyleName) {
        for (TextStyle textStyle : getTextStyles()) {
            if (textStyle.getName().equals(textStyleName)) {
                return textStyle;
            }
        }
        return null;
    }
}
