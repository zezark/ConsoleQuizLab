package model

data class RespuestaUsuario(
    val preguntaId: Int,
    val respuestaSeleccionada: String,
    val esCorrecta: Boolean
)
