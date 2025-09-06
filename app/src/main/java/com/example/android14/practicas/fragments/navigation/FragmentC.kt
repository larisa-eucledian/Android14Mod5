package com.example.android14.practicas.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android14.R
import com.example.android14.databinding.ActivityFragmentNavigationBinding
import com.example.android14.databinding.FragmentCBinding

class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentC()
    }
}