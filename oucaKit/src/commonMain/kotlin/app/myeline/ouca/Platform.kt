package app.myeline.ouca

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform