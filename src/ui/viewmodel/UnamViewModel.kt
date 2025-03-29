package ui.viewmodel

import model.Materia
import model.Pregunta
import model.RespuestaUsuario
import model.Tema
import repository.Repository

class UnamViewModel(private val repository: Repository) {


    val respuestasUsuario = mutableListOf<RespuestaUsuario>()

    fun responderPregunta(preguntaId: Int, respuestaSeleccionada: String) {
        // Buscar la pregunta en el repositorio
        val pregunta = repository.obtenerPreguntaPorId(preguntaId)

        if (pregunta != null) {

            val esCorrecta = pregunta.respuesta == respuestaSeleccionada
            val respuestaUsuario = RespuestaUsuario(
                preguntaId = preguntaId,
                respuestaSeleccionada = respuestaSeleccionada,
                esCorrecta = esCorrecta
            )
            respuestasUsuario.add(respuestaUsuario)
        } else {
            println("No existe la pregunta")
        }
    }

    fun obtenerRespuestaUsuario(idPregunta: Int): String {
        val respuesta = respuestasUsuario.find { it.preguntaId == idPregunta }
        if (respuesta != null) {
            return respuesta.respuestaSeleccionada;
        } else {
            return "respuesta not found"
        }
    }

    fun calcularPuntaje(): Int {
        return respuestasUsuario.count{ it.esCorrecta }
    }

    fun obtenerMaterias(): List<Materia> {
        return repository.obtenerMaterias()
    }

    fun obtenerTemasPorMateria(claveMateria: String): List<Tema> {
        return repository.obtenerTemas(claveMateria)
    }

    fun obtenerPreguntasPorTema(claveMateria: String, claveTema: String): List<Pregunta> {
        return repository.obtenerPreguntas(claveMateria, claveTema)
    }
}