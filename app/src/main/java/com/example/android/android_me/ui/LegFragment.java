package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class LegFragment extends Fragment {

    public final String TAG=getClass().getSimpleName().toString();
    //a variable of the index of an image in the list
    private int mImageListIndex;

    //a variable of a list of images ids
    private List<Integer> mImageIds;

    public LegFragment(){
        mImageListIndex=0;
        mImageIds=AndroidImageAssets.getLegs();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState!=null){
            mImageListIndex=savedInstanceState.getInt("IMAGE_ID");
            mImageIds=savedInstanceState.getIntegerArrayList("IMAGE_LIST");
        }


        View viewRoot=inflater.inflate(R.layout.fragment_leg, container, false);
        final ImageView headerPartImageView=(ImageView) viewRoot.findViewById(R.id.image_view_leg);

        headerPartImageView.setImageResource(AndroidImageAssets.getLegs().get(mImageListIndex));

        if(mImageIds!=null){

            headerPartImageView.setImageResource(AndroidImageAssets.getLegs().get(mImageListIndex));

            headerPartImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mImageListIndex<mImageIds.size()-1){
                        mImageListIndex++;
                    }else{
                        mImageListIndex=0;
                    }
                    headerPartImageView.setImageResource(AndroidImageAssets.getLegs().get(mImageListIndex));

                }

            });


        }else{
            Log.d(TAG, "the legs image list is empty!");
        }


        headerPartImageView.setImageResource(AndroidImageAssets.getLegs().get(mImageListIndex));

        return viewRoot;
    }

    public void setListIndex(int imageIndex) {
        mImageListIndex=imageIndex;
    }

    public void setimageIds(List<Integer> imageList){
        mImageIds=imageList;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList("IMAGE_lIST", (ArrayList<Integer>)mImageIds);
        outState.putInt("IMAGE_ID", mImageListIndex);
    }
}
