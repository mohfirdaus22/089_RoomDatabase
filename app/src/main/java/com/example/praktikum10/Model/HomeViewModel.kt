package com.example.praktikum10.Model

import androidx.lifecycle.ViewModel
import com.example.praktikum10.Repositori.RepositoriSiswa

class HomeViewModel (private val repositoriSiswa: RepositoriSiswa):ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}