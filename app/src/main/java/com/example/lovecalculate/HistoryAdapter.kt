package com.example.lovecalculate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.lovecalculate.model.LoveModel
import com.example.lovecalculate.model.room.AppDatabase
import com.example.lovecalculate.model.room.LoveDao
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class HistoryAdapter(private val loves: ArrayList<LoveModel>) :
    Adapter<HistoryAdapter.HistoryViewHolder>() {

    private lateinit var context: Context

    @Inject
    lateinit var dao: LoveDao


    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tv_first_name)
        val secondName: TextView = itemView.findViewById(R.id.tv_second_name)
        val tvPercentage: TextView = itemView.findViewById(R.id.tv_percentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_love_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return loves.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val love = loves[position]
        holder.firstName.text = love.firstName
        holder.secondName.text = love.secondName
        holder.tvPercentage.text = love.percentage

        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                " it was created: ${convertLongToDateForLoveHistory(love.creationDate)}",
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.itemView.setOnLongClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(context.getString(R.string.delete_this))

            builder.setPositiveButton("Да") { dialog, which ->
                if (position != RecyclerView.NO_POSITION) {
                    dao.delete(love)
                    loves.removeAt(position)
                    notifyItemRemoved(position)
                }
            }

            builder.setNegativeButton("Нет") { dialog, which ->
                dialog.dismiss()
            }
            builder.show()
            true
        }
    }

    private fun convertLongToDateForLoveHistory(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd-MM-yyyy HH:mm")
        return format.format(date)
    }

}