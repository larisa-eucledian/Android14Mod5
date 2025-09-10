package com.example.android14.practicas.fragments.navigation

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.android14.R
import com.example.android14.databinding.ActivityFirstFragmentBinding
import com.example.android14.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding
    private var name:String? = ""
    private var email:String? =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString("ARG_NAME")
            email = it.getString("ARG_EMAIL")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setTitle("Fragment B")

        binding.tvInfo.text = "Nombre = $name, Correo = ${email ?: "No hay email"}"

        binding.btnNext2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContaier, FragmentC.newInstance())
                .addToBackStack("FragmentC").commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        @JvmStatic
        fun newInstance(name:String, email: String) = FragmentB().apply {
            arguments = Bundle().apply {
                putString("ARG_NAME", name)
                putString("ARG_EMAIL", email)
            }
        }
        fun newInstance(name: String) = FragmentB().apply {
            arguments = Bundle().apply {
                putString("ARG_NAME",name)
            }
        }
    }
}