package app.myeline.ouca

import kotlinx.coroutines.flow.MutableStateFlow
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow

open class CounterViewModel: KMMViewModel() {

//    @NativeCoroutinesState
    val count = MutableStateFlow(0)

    fun incrementCount() {
        count.value++
    }

}