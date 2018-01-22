package com.assignment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import com.assignment.fragment.FirstLayout;
import com.assignment.fragment.ForthLayout;
import com.assignment.fragment.MenuFragment;
import com.assignment.fragment.SecondLayout;
import com.assignment.fragment.ThirdLayout;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment mFragment;
    private  int menuFragmentLayout;
    private  int contentFragmentLayout;

    public static final int FIRST_FRAGMENT = 1;
    public static final int SECOND_FRAGMENT = 2;
    public static final int THIRD_FRAGMENT = 3;
    public static final int FORTH_FRAGMENT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init layout (.xml file)
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        menuFragmentLayout = R.id.fragment_main_menu;
        contentFragmentLayout = R.id.fragment_container;
        mFragment = new MenuFragment(); // instantiate fragment class
        fragmentManager.beginTransaction().add(menuFragmentLayout, mFragment).commit(); // add fragment view
        mFragment = new FirstLayout();  // instantiate fragment class
        fragmentManager.beginTransaction().add(contentFragmentLayout, mFragment).commit(); // add fragment view
    }

   /*  This method will handle fragment replacement
     when user select left side options right side fragment will update*/

    public void onMenuItemClick(int itemId){
        switch (itemId){
            case FIRST_FRAGMENT :
                mFragment = new FirstLayout(); // instantiate fragment class
                fragmentManager.beginTransaction().replace(contentFragmentLayout, mFragment).commit(); // replace fragment view
                break;
            case SECOND_FRAGMENT:
                mFragment = new SecondLayout(); // instantiate fragment class
                fragmentManager.beginTransaction().replace(contentFragmentLayout, mFragment).commit(); // replace fragment view
                break;
            case THIRD_FRAGMENT:
                mFragment = new ThirdLayout(); // instantiate fragment class
                fragmentManager.beginTransaction().replace(contentFragmentLayout, mFragment).commit(); // replace fragment view
                break;
            case FORTH_FRAGMENT:
                mFragment = new ForthLayout(); // instantiate fragment class
                fragmentManager.beginTransaction().replace(contentFragmentLayout, mFragment).commit(); // replace fragment view
        }

    }
}
