package com.example.android14.practicas.fragments.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setTitle("Registrar")

        binding.btnNext.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                parentFragmentManager.beginTransaction().addToBackStack("Fragment A")
                    .replace(R.id.fragmentContaier, FragmentB.newInstance(name, email)).commit()
            } else {
                Toast.makeText(requireContext(), "Ingresa todos los datos", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.btnOpenC.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("Fragment A")
                .replace(R.id.fragmentContaier, FragmentC.newInstance()).commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}