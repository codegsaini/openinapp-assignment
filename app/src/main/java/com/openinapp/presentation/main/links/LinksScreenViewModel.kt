package com.openinapp.presentation.main.links

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openinapp.data._util.Response
import com.openinapp.data.repository.AuthRepository
import com.openinapp.data.repository.DashboardRepository
import com.openinapp.domain.model.DashboardData
import com.openinapp.domain.model.ResponseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LinksScreenViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = mutableStateOf(LinksScreenState())
    private val state : State<LinksScreenState> = _state

    init {
        viewModelScope.launch {
            login()
            getDashboardData()
        }

    }

    val userName get() = "Gaurav Saini"
    val topLinks get() = state.value.data.data.topLinks
    val recentLinks get() = state.value.data.data.recentLinks
    val favouriteLinks get() = state.value.data.data.favouriteLinks
    val chartEntries get() = emptyList<String>()
    val dashBoardData get() = state.value.data
    val error get() = state.value.error
    val loading get() = state.value.loading

    fun onEvent(event: LinksScreenEvent) {
        when (event) {
            is LinksScreenEvent.OnDismissError -> hideError()
        }
    }


    private suspend fun login() {
        authRepository.login()
    }

    private suspend fun getDashboardData() {
        showLoading()
        when (val response = dashboardRepository.getDashBoardData()) {
            is Response.Success -> onDataFetchSuccess(response.data)
            is Response.Failure -> onDataFetchFailure(response.error)
        }
        hideLoading()
    }

    private fun onDataFetchSuccess(data: DashboardData) {
        _state.value = state.value.copy(
            data = data,
        )
        hideError()
    }

    private fun onDataFetchFailure(error: ResponseError) {
        showError(error.message)
    }

    private fun showLoading() {
        _state.value = state.value.copy(
            loading = true
        )
        hideError()
    }

    private fun hideLoading() {
        _state.value = state.value.copy(
            loading = false
        )
    }

    private fun showError(message: String) {
        _state.value = state.value.copy(
            error = message
        )
    }

    private fun hideError() {
        _state.value = state.value.copy(
            error = null
        )
    }

}