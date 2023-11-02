package com.example.lovecalculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lovecalculate.databinding.FragmentHistoryBinding
import com.example.lovecalculate.model.LoveModel


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lovesList: List<LoveModel> = App.appDatabase.getLoveDao().getAll().reversed()
        val recyclerView = binding.rvHistory
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        val adapter =  HistoryAdapter(ArrayList(lovesList))
        recyclerView.adapter = adapter
    }


}