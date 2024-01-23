package com.example.project_acadeamease1;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Tab_Album();
            case 1:
                return new Tab_Notes();
            case 2:
                return new Tab_Files();
            default:
                return new Tab_Album(); // Default to AlbumFragment
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of tabs
    }
}











/** public class MyFragmentAdapter extends FragmentStateAdapter {
 public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
 super(fragmentManager, lifecycle);
 }

 @NonNull
 @Override
 public Fragment createFragment(int position) {
 if(position == 0){
 return new albumFragment();
 } else if (position == 1) {
 return new notesFragment();
 }else{
 return new filesFragment();
 }
 }

 @Override
 public int getItemCount() {
 return 3;
 }
 }
 */
