package uz.registon.lc.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState: StateFlow<DashboardUiState> = _uiState

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            // Simulate API call
            _uiState.value = DashboardUiState.Success(
                balance = "1,250,000 UZS",
                attendance = "95%",
                homeworkProgress = "12/15",
                rank = "#4"
            )
        }
    }
}

sealed class DashboardUiState {
    object Loading : DashboardUiState()
    data class Success(
        val balance: String,
        val attendance: String,
        val homeworkProgress: String,
        val rank: String
    ) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}
