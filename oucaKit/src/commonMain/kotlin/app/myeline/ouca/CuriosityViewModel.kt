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
    val océan = Curiosity(
        Curiosity.Category.ARTISTIC,
        "Océan",
        0.0,
        0.0
    )

    val curiosities = listOf(paris, singapore)

    @NativeCoroutinesState
    val curiosity = MutableStateFlow<Curiosity>(viewModelScope, paris)

    fun setCuriosity() {
        var current = getCuriosity()
        val currentIndex = curiosities.indexOf(current)
        println("previous location: "+current.name)
        if(curiosities[currentIndex] == curiosities[curiosities.size-1]){
            current = curiosities[0]
            curiosity.value = current
            return
        } else {
            current = curiosities[currentIndex + 1]
            curiosity.value = current
            return
        }
    }

    fun getCuriosity(): Curiosity {
        return curiosity.value
    }
}

