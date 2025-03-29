package model

data class Pregunta(
    val id: Int,
    val clave: String,
    val claveMateria: String,
    val claveTema: String,
    val descripcion: String,
    val opcionA: String,
    val opcionB: String,
    val opcionC: String,
    val opcionD: String,
    val respuesta: String,
    val image: String?
)
