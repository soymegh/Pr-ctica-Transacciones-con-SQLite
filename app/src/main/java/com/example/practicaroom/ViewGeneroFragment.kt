package com.example.practicaroom

import adapters.GeneroAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaroom.databinding.FragmentViewGeneroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.MainDataBase
import model.dao.GeneroDao

class ViewGeneroFragment : Fragment() {
    lateinit var vBinding: FragmentViewGeneroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vBinding = FragmentViewGeneroBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: MainDataBase = MainDataBase.getInstance(this.requireContext().applicationContext)
        val dao: GeneroDao = db.GeneroDao()

        CoroutineScope(Dispatchers.Main).launch {
            var listC = dao.getAll()

            vBinding.recyclerGenero.layoutManager = LinearLayoutManager(context)
            val adapter = GeneroAdapter(listC)
            vBinding.recyclerGenero.adapter = adapter
        }
    }


}