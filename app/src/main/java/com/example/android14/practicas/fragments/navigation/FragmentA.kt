package com.example.android14.practicas.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android14.R
import com.example.android14.databinding.FragmentABinding
import com.example.android14.databinding.FragmentFirstBinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("Fragment A").replace(R.id.fragmentContaier, FragmentB.newInstance()).commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}