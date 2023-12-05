package com.example.praktikum10.Repositori

import android.content.Context
import com.example.praktikum10.Data.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context): ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy{
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao()) }

}