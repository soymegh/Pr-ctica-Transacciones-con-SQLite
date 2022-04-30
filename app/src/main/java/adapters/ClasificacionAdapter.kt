package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaroom.databinding.ItemGeneroBinding
import model.entities.ClasificacionEntity


class ClasificacionAdapter(val ClasificacionLista : List<ClasificacionEntity>) : RecyclerView.Adapter<ClasificacionAdapter.ClasificacionHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClasificacionHolder {
        val binding = ItemGeneroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(holder: ClasificacionAdapter.ClasificacionHolder, position: Int) {
        holder.bind(ClasificacionLista[position])
    }

    override fun getItemCount(): Int = ClasificacionLista.size

    inner class ClasificacionHolder(val binding: ItemGeneroBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(Clasificacion : ClasificacionEntity){
            with(binding){
                TxtId.text = Clasificacion.idClasificacion.toString()
                TxtNombre.text = Clasificacion.nombreClasificacion

            }
        }
    }


}