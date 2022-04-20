package com.example.practicaroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.practicaroom.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var fBinding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = FragmentMenuBinding.inflate(layoutInflater)
        return fBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fBinding.btnAddGenero.setOnClickListener {
            it.findNavController().navigate(R.id.go_to_addGeneroFragment)
        }
        fBinding.btnViewGenero.setOnClickListener {
            it.findNavController().navigate(R.id.go_to_viewGeneroFragment
            )
        }
    }
}