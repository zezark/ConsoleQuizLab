import repository.Repository
import ui.viewmodel.UnamViewModel

fun main() {
    println("Hello World!")

    val repository = Repository
    val viewModel = UnamViewModel(repository)

    val materias = viewModel.obtenerMaterias()
    println("Materias disponibles:")
    materias.forEach { println("${it.id}. ${it.descripcion}") }

    println("Ingresa la clave de la materia:")
    val claveMateria = readlnOrNull() ?: ""

    val temas = viewModel.obtenerTemasPorMateria(claveMateria)
    if (temas.isEmpty()) {
        println("Clave de materia no encontrada. Intenta nuevamente.")
        return
    }

    println("Temas disponibles:")
    temas.forEach { println("${it.id}. ${it.descripcion}") }

    println("Ingresa la clave del tema:")
    val claveTema = readlnOrNull() ?: ""

    val preguntas = viewModel.obtenerPreguntasPorTema(claveMateria, claveTema)
    if (preguntas.isEmpty()) {
        println("No se encontraron preguntas para este tema.")
        return
    }

    println("Preguntas para el tema $claveTema:")
    preguntas.forEach { pregunta ->
        println(pregunta.descripcion)
        println("A) ${pregunta.opcionA}")
        println("B) ${pregunta.opcionB}")
        println("C) ${pregunta.opcionC}")
        println("D) ${pregunta.opcionD}")
        println("Respuesta correcta: ${pregunta.respuesta}")
        println()
    }

    preguntas.forEach { pregunta ->
        println(pregunta.descripcion)
        println("A) ${pregunta.opcionA}")
        println("B) ${pregunta.opcionB}")
        println("C) ${pregunta.opcionC}")
        println("D) ${pregunta.opcionD}")
        print("Selecciona la opcion correcta: ")
        val respuesta = readlnOrNull() ?: ""
        viewModel.responderPregunta(pregunta.id, respuesta)
    }

    println("Resultados")
    preguntas.forEach { pregunta ->
        println(pregunta.descripcion)
        println("A) ${pregunta.opcionA}")
        println("B) ${pregunta.opcionB}")
        println("C) ${pregunta.opcionC}")
        println("D) ${pregunta.opcionD}")
        println("Respuesta correcta: ${pregunta.respuesta}")
        val respuesta = viewModel.obtenerRespuestaUsuario(pregunta.id)
        println("Usuario: $respuesta")
    }

    println("-------------------------> Puntaje Total = " + viewModel.calcularPuntaje())

}