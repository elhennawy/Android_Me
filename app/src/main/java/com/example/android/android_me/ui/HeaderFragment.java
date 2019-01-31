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

public class HeaderFragment extends Fragment {

    public final String TAG=getClass().getSimpleName().toString();
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    //a variable of the index of an image in the list
    private int mImageListIndex;

    //a variable of a list of images ids
    private List<Integer> mImageIds;

    public HeaderFragment(){
        //set the defult values
        mImageListIndex=0;
        mImageIds=AndroidImageAssets.getHeads();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            mImageListIndex=savedInstanceState.getInt(LIST_INDEX);
            mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View viewRoot=inflater.inflate(R.layout.fragment_head, container, false);

        final ImageView headerPartImageView=(ImageView) viewRoot.findViewById(R.id.image_view_head);

        if(mImageIds!=null){

            headerPartImageView.setImageResource(mImageIds.get(mImageListIndex));

            headerPartImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mImageListIndex<mImageIds.size()-1){
                        mImageListIndex++;
                    }else{
                        mImageListIndex=0;
                    }

                    headerPartImageView.setImageResource(mImageIds.get(mImageListIndex));
                }

            });

        }else{
            Log.d(TAG, "image list is empty!");
        }

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
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)mImageIds);
        outState.putInt(LIST_INDEX, mImageListIndex);


    }
}
