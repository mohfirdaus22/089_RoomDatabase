package com.example.praktikum10.Model

import android.text.Spannable.Factory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum10.ui.theme.AplikasiSiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
    }
}

