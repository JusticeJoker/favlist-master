package cm.a12872_a18797.favlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.content.contentValuesOf

internal class MainAdapter(
    private val context: Context,
    private val imageNames: Array<String>,
    private val images: IntArray
) : BaseAdapter(){
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView

    override fun getCount(): Int {
        return imageNames.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null){
            convertView = layoutInflater!!.inflate(R.layout.home_grid_row, null)
        }

        imageView = convertView!!.findViewById(R.id.grid_image)
        imageView.setImageResource(images[position])
        return convertView
    }
}