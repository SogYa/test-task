package ru.sogya.work.testtask.screen.authorize

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.databinding.FragmentAuthBinding


@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_auth) {
    private val vm: AuthVM by viewModels()
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private var isNumberCorrect: Boolean = false

    private companion object {
        private const val NUMBER_LENGTH = 16
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        vm.getValidationLiveData().observe(viewLifecycleOwner) {
            binding.addButton.isEnabled = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            goBackButton.setOnClickListener {
                findNavController().popBackStack()
            }
            addButton.setOnClickListener {
                val id = editTextNumber.text.toString()
                val code = editTextCode.text.toString()
                val name = editTextName.text.toString()
                val surname = editTextSurname.text.toString()
                vm.insertClientInfoToDatabase(id, code, name, surname)
            }
            editTextNumber.addTextChangedListener(object : TextValidator(editTextNumber) {
                override fun validate(textView: TextView, text: String?) {
                    vm.validField(id, text, NUMBER_LENGTH) {
                        isNumberCorrect = it
                        if (it) {
                            editTextNumber.setTextColor(Color.WHITE)
                            numbeerHelperHint.visibility = View.VISIBLE
                            numbeerHelperError.visibility = View.GONE
                            textInputNumber.boxStrokeColor =
                                resources.getColor(R.color.edittext_purple, null)
                            textInputNumber.error = null
                        }
                    }
                }
            })
            editTextNumber.setOnFocusChangeListener { _, focused ->
                if (!focused && !isNumberCorrect) {
                    numbeerHelperHint.visibility = View.GONE
                    numbeerHelperError.visibility = View.VISIBLE
                    textInputNumber.error = "Некорректные данные"
                }
            }

            editTextCode.addTextChangedListener(object : TextValidator(editTextCode) {
                override fun validate(textView: TextView, text: String?) {
                    vm.validField(textView.id, text)
                }
            })
            editTextName.addTextChangedListener(object : TextValidator(editTextName) {
                override fun validate(textView: TextView, text: String?) {
                    vm.validField(textView.id, text)
                }
            })
            editTextSurname.addTextChangedListener(object : TextValidator(editTextSurname) {
                override fun validate(textView: TextView, text: String?) {
                    vm.validField(textView.id, text)
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}