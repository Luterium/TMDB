package com.example.tmdb.presentation.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.tmdb.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class Navigator @Inject constructor(fragmentActivity: FragmentActivity, fm: FragmentManager, containerID: Int) :
        SupportAppNavigator(fragmentActivity, fm, containerID) {

    override fun setupFragmentTransaction(command: Command?, currentFragment: Fragment?,
                                          nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {

        if (currentFragment != null)
            fragmentTransaction?.setCustomAnimations(
                R.anim.slide_out_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
    }

}