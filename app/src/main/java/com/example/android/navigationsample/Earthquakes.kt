package com.example.android.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

class Earthquakes : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_earthquakes, container, false)

        val viewAdapter = MyAdapter(arrayOf(EarthquakeUIData("12 March 2012", "Depth: 12 km", "Mag: 5"),
                EarthquakeUIData("15 April 2012", "Depth: 7 km", "Mag: 8"),
                EarthquakeUIData("30 December 2012", "Depth: 11 km", "Mag: 7"),
                EarthquakeUIData("22 October 2012", "Depth: 9 km", "Mag: 2")))

        view.findViewById<RecyclerView>(R.id.leaderboard_list).run {
            setHasFixedSize(true)

            adapter = viewAdapter
        }
        return view
    }
}

data class EarthquakeUIData(val date: String, val depth: String, val magnitude: String)

class MyAdapter(private val myDataset: Array<EarthquakeUIData>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view_item, parent, false)


        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.earthquake_date).text = myDataset[position].date
        holder.item.findViewById<TextView>(R.id.earthquake_depth).text = myDataset[position].depth
        holder.item.findViewById<TextView>(R.id.earthquake_magnitude).text = myDataset[position].magnitude

        holder.item.setOnClickListener {
            val bundle = bundleOf("earthquake_date" to myDataset[position].date)

            Navigation.findNavController(holder.item).navigate(
                    R.id.action_earthquake_to_earthquake_detail,
                bundle)
        }
    }

    override fun getItemCount() = myDataset.size
}
