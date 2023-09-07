package ru.sogya.work.testtask.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val vm: HomeVM by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        vm.getClientLiveData().observe(viewLifecycleOwner) {
            if (it!=null){
                binding.textViewName.text = it.name
                binding.textViewSurname.text = it.surname
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bankItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_authFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}