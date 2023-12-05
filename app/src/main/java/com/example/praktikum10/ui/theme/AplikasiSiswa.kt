package com.example.praktikum10.ui.theme

import android.app.Application
import com.example.praktikum10.Repositori.ContainerApp
import com.example.praktikum10.Repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    /**
     * AppContainer intance digunakan oleh kelas-kelas lainnya untuk mendapatkan depedencies
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}