package com.mk_sofia.sofiamain.core.base

import kotlinx.coroutines.flow.StateFlow

interface BaseMVI<STATE, EVENT, EFFECT> {
    val uiState: StateFlow<STATE>
    val effect: StateFlow<EFFECT?>

    fun event(event: EVENT)

    fun consume()
}