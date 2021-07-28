package com.test.restaurantes.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.test.restaurantes.R


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = requireView().findViewById<View>(R.id.imageView2) as ImageView
        val restaurant: TextView = requireView().findViewById<View>(R.id.restaurant) as TextView
        val address: TextView = requireView().findViewById<View>(R.id.address) as TextView
        val ranking: TextView = requireView().findViewById<View>(R.id.ranking) as TextView
        val description: TextView = requireView().findViewById<View>(R.id.description) as TextView


        val args : DetailFragmentArgs by navArgs()
        val selecRestaruant = args.selectedEntity


        Glide.with(imageView.context)
            .load(selecRestaruant.imageUrl)
            .into(imageView)

        restaurant.text = selecRestaruant.name
        address.text= selecRestaruant.address
        ranking.text = selecRestaruant.rating.toString()
        description.text = selecRestaruant.description

    }
}