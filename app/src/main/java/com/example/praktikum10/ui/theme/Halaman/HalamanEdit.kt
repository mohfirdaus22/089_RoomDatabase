package com.example.praktikum10.ui.theme.Halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktikum10.Model.DetailSiswa
import com.example.praktikum10.Model.EditViewModel
import com.example.praktikum10.Model.PenyediaViewModel
import com.example.praktikum10.Model.toDetailSiswa
import com.example.praktikum10.Model.toSiswa
import com.example.praktikum10.R
import com.example.praktikum10.Repositori.RepositoriSiswa
import com.example.praktikum10.navigasi.DestinasiNavigasi
import com.example.praktikum10.navigasi.SiswaTopAppBar
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

object ItemEditDestination : DestinasiNavigasi {
    override val route = "Item Edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen (
    navigateBack : () -> Unit,
    onNavigateup : () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold (
        topBar = {
            SiswaTopAppBar(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateup
            )
        },
        modifier = modifier
    ){innerPadding ->
        EntrySiswaBody(
            uiStateSiswa = viewModel.siswaUiState,
            onSiswaValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateSiswa()
                    navigateBack
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}