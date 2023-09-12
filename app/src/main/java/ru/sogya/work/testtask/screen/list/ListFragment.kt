package ru.sogya.work.testtask.screen.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment: Fragment() {
    private val vm:ListVM by viewModels()
}