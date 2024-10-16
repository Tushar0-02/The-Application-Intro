package com.test.dm;

import android.annotation.SuppressLint;

public class Dessert {
        // Name of the desert
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
        public Dessert(String vName, int vNumber, int imageResourceId)

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
