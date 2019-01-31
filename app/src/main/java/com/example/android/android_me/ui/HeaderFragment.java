package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class HeaderFragment extends Fragment {

    //a variable of the index of an image in the list
    private int mImageListIndex;

    //a variable of a list of images ids
    private List<Integer> mImageIds;

    public HeaderFragment(){
        //set the defult values
        mImageListIndex=0;
        mImageIds=null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot=inflater.inflate(R.layout.fragment_head_part, container, false);
        ImageView headerPartImageView=(ImageView) viewRoot.findViewById(R.id.image_view_head);

        headerPartImageView.setImageResource(AndroidImageAssets.getHeads().get(mImageListIndex));

        return viewRoot;
    }

    public void setListIndex(int imageIndex) {
        mImageListIndex=imageIndex;
    }

    public void setimageIds(List<Integer> imageList){
        mImageIds=imageList;
    }
}
