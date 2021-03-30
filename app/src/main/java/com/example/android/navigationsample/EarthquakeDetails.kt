package com.example.android.navigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class EarthquakeDetails : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_earthquake_details, container, false)

        val name = arguments?.getString("earthquake_date") ?: "No Date"
        view.findViewById<TextView>(R.id.details_earthquake_date).text = name
        return view
    }
}
