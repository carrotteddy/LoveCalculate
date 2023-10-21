package com.example.lovecalculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculate.databinding.FragmentCalculateBinding
import com.example.lovecalculate.model.LoveModel
import com.example.lovecalculate.model.RetrofitService
import com.example.lovecalculate.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalculateFragment : Fragment(), MainView {

    private lateinit var binding: FragmentCalculateBinding
    val presenter = MainPresenter()

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
                presenter.attachView(this@CalculateFragment)
                presenter.getData(
                    edFirstName.text.toString(),
                    edSecName.text.toString()
                )
            }
        }
    }

    override fun changeScreen(loveModel: LoveModel) {
        val resultFragment = ResultFragment()
        val bundle = Bundle()
        bundle.putSerializable("key", loveModel)
        resultFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, resultFragment).addToBackStack(null).commit()
    }

}

