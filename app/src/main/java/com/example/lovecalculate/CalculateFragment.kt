package com.example.lovecalculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lovecalculate.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.getPercentage(
                    edFirstName.text.toString(),
                    edSecName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val loveModel = response.body()
                        val resultFragment = ResultFragment()
                        val bundle = Bundle()
                        bundle.putString("result", loveModel?.result)
                        bundle.putString("percentage", loveModel?.percentage)
                        resultFragment.arguments = bundle
                        val fragmentManager = requireActivity().supportFragmentManager
                        val transaction = fragmentManager.beginTransaction()
                        transaction.replace(R.id.container, resultFragment)
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })
            }


        }
    }

}

