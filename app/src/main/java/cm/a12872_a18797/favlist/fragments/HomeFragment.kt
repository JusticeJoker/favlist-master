package cm.a12872_a18797.favlist.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import cm.a12872_a18797.favlist.MainAdapter
import cm.a12872_a18797.favlist.R

class HomeFragment : Fragment() {

    lateinit var rootView: View

    lateinit var gridView: GridView
    private var gridImageNames = arrayOf(
        "Golden Bridge", "Tampa Bay Buccaneers", "Chevrolet Camaro",
        "Vegetable Casserole", "Sweet and Sour Chicken", "Design Vector",
        "Pork Loin", "Sidney's Opera House", "Pasta Dish",
        "Dope Setup", "Singapore", "Tacos Dish",
        "Toquio", "Warm Salad Dish"
    )
    private var gridImages = intArrayOf(
        R.drawable.bridge, R.drawable.buccaneers, R.drawable.camaro,
        R.drawable.casserole, R.drawable.chicken, R.drawable.design,
        R.drawable.lombo, R.drawable.operahouse, R.drawable.pasta,
        R.drawable.setup, R.drawable.singapore, R.drawable.tacos,
        R.drawable.toquio, R.drawable.warmsalad
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        gridView = rootView.findViewById(R.id.home_grid)
        val mainAdapter =
            MainAdapter(this@HomeFragment.requireContext(), gridImageNames, gridImages)
        gridView.adapter = mainAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(), "You Clicked " + gridImageNames[+position],
                Toast.LENGTH_SHORT
            ).show()
        }

        return rootView
    }
}
