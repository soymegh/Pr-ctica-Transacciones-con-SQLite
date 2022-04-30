package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaroom.databinding.ItemGeneroBinding
import model.entities.GeneroEntity

class GeneroAdapter(val GeneroLista: List<GeneroEntity>): RecyclerView.Adapter<GeneroAdapter.GeneroHolder> (){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GeneroHolder {
        val binding = ItemGeneroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GeneroHolder(binding)
    }

    override fun onBindViewHolder(holder: GeneroAdapter.GeneroHolder, position: Int) {
        holder.bind(GeneroLista[position])
    }

    override fun getItemCount(): Int = GeneroLista.size

    inner class GeneroHolder(val binding: ItemGeneroBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(Genero: GeneroEntity){
            with(binding){
                TxtId.text = Genero.idGenero.toString()
                TxtNombre.text = Genero.nombre

            }
        }
    }

}