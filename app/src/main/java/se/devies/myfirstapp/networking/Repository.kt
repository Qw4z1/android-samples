package se.devies.myfirstapp.networking

data class Repository(val owner: Owner, val name: String)

data class Owner(val login: String)