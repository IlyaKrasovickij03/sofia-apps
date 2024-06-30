package com.mk_sofia.sofiamain.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun CoroutineScope.launchOnIo(code: suspend () -> Unit) {
    this.launch {
        withContext(Dispatchers.IO) {
            code()
        }
    }
}