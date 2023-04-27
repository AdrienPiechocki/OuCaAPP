package app.myeline.ouca

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState

open class CuriosityViewModel: KMMViewModel() {

    val paris = Curiosity(
        Curiosity.Category.HISTORIC,
        "Tour Eiffel",
        48.8584,
        2.2945
    )
    val singapore = Curiosity(
        Curiosity.Category.ARCHITECTURAL,
        "Singapore",
        1.35,
        103.87
    )
    @NativeCoroutinesState
    val curiosity = MutableStateFlow<Curiosity>(viewModelScope, paris)

    fun getCuriosity() {
        curiosity.value = singapore
    }

}
