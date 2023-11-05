package com.example.lovecalculate.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lovecalculate.CalculateFragment
import com.example.lovecalculate.Prefs
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentOnBoardBinding
import com.example.lovecalculate.onBoarding.adapter.OnBoardAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    @Inject
    lateinit var prefs: Prefs
    private val adapter = OnBoardAdapter(this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
    }

    private fun onClick() {
        prefs.onBoardShowed()
        val fragment = CalculateFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}