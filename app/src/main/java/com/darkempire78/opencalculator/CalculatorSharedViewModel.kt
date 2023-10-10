package com.darkempire78.opencalculator

import Event
import androidx.lifecycle.ViewModel
import com.darkempire78.opencalculator.spec.ArrowClickEventSpec
import com.darkempire78.opencalculator.spec.UpdateArrowDataSpec
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class CalculatorSharedViewModel : ViewModel() {

    private val _arrowClickEvent: MutableStateFlow<Event<ArrowClickEventSpec?>> = MutableStateFlow(Event(null))
    val arrowClickEvent: StateFlow<Event<ArrowClickEventSpec?>> = _arrowClickEvent

    private val _calculatorDataFlow: MutableStateFlow<Event<UpdateArrowDataSpec?>> = MutableStateFlow(Event(null))
    val calculatorDataFlow: StateFlow<Event<UpdateArrowDataSpec?>> = _calculatorDataFlow

    fun onArrowClick(originId: Int) {
        _arrowClickEvent.value = Event(ArrowClickEventSpec(originId, Random.nextDouble()))
    }

    fun updateArrowData(id: Int, data: String) {
        _calculatorDataFlow.value = Event(UpdateArrowDataSpec(id, data, Random.nextDouble()))
    }
}