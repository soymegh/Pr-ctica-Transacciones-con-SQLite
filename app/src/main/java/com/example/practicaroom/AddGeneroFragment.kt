package com.example.practicaroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.practicaroom.databinding.FragmentAddGeneroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.MainDataBase
import model.dao.GeneroDao
import model.entities.GeneroEntity

class AddGeneroFragment : Fragment() {
    private lateinit var aBinding: FragmentAddGeneroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aBinding = FragmentAddGeneroBinding.inflate(inflater, container, false)
        return aBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: MainDataBase = MainDataBase.getInstance(this.requireContext().applicationContext)
        val dao: GeneroDao = db.GeneroDao()

        with(aBinding){
            btnAgregarGenero.setOnClickListener {
                val new = GeneroEntity (0,etNombreGenero.text.toString(),etActivo.text.toString())

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insert(new)
                }
                navController.navigate(R.id.menuFragment)
            }
        }
    }
}