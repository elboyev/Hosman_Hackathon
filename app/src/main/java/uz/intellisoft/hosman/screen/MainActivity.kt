package uz.intellisoft.hosman.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import uz.intellisoft.hosman.R
import uz.intellisoft.hosman.screen.home.HomeFragment
import uz.intellisoft.hosman.screen.liked.LikedFragment
import uz.intellisoft.hosman.screen.profile.ProfileFragment
import uz.intellisoft.hosman.screen.search.SearchFragment

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment.newInstance()
    val likedFragment=LikedFragment.newInstance()
    val profileFragment = ProfileFragment.newInstance()
    val searchFragment = SearchFragment.newInstance()

    var activefragment : Fragment = homeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.flcontainer,homeFragment,homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flcontainer,likedFragment,likedFragment.tag).hide(likedFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flcontainer,searchFragment,searchFragment.tag).hide(searchFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flcontainer,profileFragment,profileFragment.tag).hide(profileFragment).commit()

        supportFragmentManager.beginTransaction().show(activefragment).commit()
        bottomnavmenu.setOnNavigationItemSelectedListener {

            if (it.itemId==R.id.actionHome){
                supportFragmentManager.beginTransaction().hide(activefragment).show(homeFragment).commit()
                activefragment=homeFragment
            } else if (it.itemId==R.id.actionFavourite){
                supportFragmentManager.beginTransaction().hide(activefragment).show(likedFragment).commit()
                activefragment=likedFragment
            } else if (it.itemId==R.id.actionSearch){
                supportFragmentManager.beginTransaction().hide(activefragment).show(searchFragment).commit()
                activefragment=searchFragment
            } else if (it.itemId==R.id.actionProfile){
                supportFragmentManager.beginTransaction().hide(activefragment).show(profileFragment).commit()
                activefragment=profileFragment
            }

            return@setOnNavigationItemSelectedListener true

        }
    }
}