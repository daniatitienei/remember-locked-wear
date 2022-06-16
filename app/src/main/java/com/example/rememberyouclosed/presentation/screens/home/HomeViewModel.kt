package com.example.rememberyouclosed.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.rememberyouclosed.domain.repository.LockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: LockRepository
) : ViewModel() {

    var locks = repository.getAllLocks()
}