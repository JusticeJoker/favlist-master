package cm.a12872_a18797.favlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import cm.a12872_a18797.favlist.fragments.HomeFragment
import cm.a12872_a18797.favlist.fragments.ListsFragment
import cm.a12872_a18797.favlist.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        val homeFragment = HomeFragment()
        val listsFragment = ListsFragment()
        val searchFragment = SearchFragment()
        setCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    setCurrentFragment(homeFragment)
                    Log.i(TAG, "Home Selected")
                }
                R.id.nav_lists -> {
                    setCurrentFragment(listsFragment)
                    Log.i(TAG, "My Lists Selected")
                }
                R.id.nav_search -> {
                    setCurrentFragment(searchFragment)
                    Log.i(TAG, "Search Selected")
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}