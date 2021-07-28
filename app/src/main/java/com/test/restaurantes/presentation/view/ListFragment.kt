package com.test.restaurantes.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.restaurantes.R
import com.test.restaurantes.databinding.FragmentListBinding
import com.test.restaurantes.presentation.adapter.RestaurantAdapter
import com.test.restaurantes.presentation.viewModel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private var restaurantAdapter = RestaurantAdapter()

    private val viewModel : RestaurantViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restaurantAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_entity", it)
            }

            findNavController().navigate(
                R.id.action_listFragment_to_detailFragment,
                bundle
            )
        }

        initRecyclerView()
       viewModel.getRestaurants().observe(viewLifecycleOwner, {
           restaurantAdapter.differ.submitList(it)
       })

    }

    private fun initRecyclerView(){
        binding.rvRestaurant.apply {
            adapter = restaurantAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}