/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        FragmentManager fm=getSupportFragmentManager();

        HeaderFragment headerPartFragment=new HeaderFragment();

        //set the image id
        headerPartFragment.setListIndex(3);


        fm.beginTransaction()
                .add(R.id.fragment_container_head, headerPartFragment)
                .commit();


        BodyFragment bodyPartFragment=new BodyFragment();

        //set the image id
        bodyPartFragment.setListIndex(2);


        fm.beginTransaction()
                .add(R.id.fragment_container_body, bodyPartFragment)
                .commit();

        LegFragment legPartFragment=new LegFragment();

        //set the image id
        legPartFragment.setListIndex(1);


        fm.beginTransaction()
                .add(R.id.fragment_container_leg, legPartFragment)
                .commit();





    }
}
