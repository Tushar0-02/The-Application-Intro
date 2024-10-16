package com.example.introo;

import android.annotation.SuppressLint;

public class msg {

    private final String mDessertName;

        // Number of desserts
        private final int mDessertNumber;

        // Drawable resource ID
        private final int mImageResourceId;

        /*
         * Create a new dessert object.
         *
         * @param vName is the name of the dessert
         * @param vNumber is the corresponding number of desserts
         * @param image is drawable reference ID that corresponds to the dessert
         * */
        @SuppressLint("WrongCommentType")
        public msg(String vName, int vNumber, int imageResourceId)

        {
            mDessertName = vName;
            mDessertNumber = vNumber;
            mImageResourceId = imageResourceId;
        }

        /**
         * Get the name of the dessert
         */
        public String getDessertName() {
            return mDessertName;
        }

        /**
         * Get the  number of desserts
         */
        public int getDessertNumber() {
            return mDessertNumber;
        }

        /**
         * Get the image resource ID
         */
        public int getImageResourceId() {
            return mImageResourceId;
        }
}

