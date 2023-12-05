package com.example.praktikum10.Model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.praktikum10.Data.Siswa
import com.example.praktikum10.Repositori.OfflineRepositoriSiswa

class EntryViewModel(private val repositoriSiswa: OfflineRepositoriSiswa): ViewModel() {
    /**
     * Berisi Status Siswa Saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /*Fungsi Untuk Validasi Input*/
    private fun validasiInput(uiState:DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /*Fungsi Untuk menyimpan data yg dientry*/

    suspend fun saveSis(){
        if(validasiInput()){
            repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

/**
 * Mewakili status ui untuk siswa
 */

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon :String="",
)
/* Fungsi Untuk Mengkonversi Data Input keData dalam tabel sesuai jenis datanya */
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false):UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid

)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)