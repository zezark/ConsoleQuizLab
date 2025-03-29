package repository

import model.Materia
import model.Pregunta
import model.Tema

object Repository {

    fun obtenerMaterias(): List<Materia> = materias

    fun obtenerTemas(claveMateria: String): List<Tema> =
        temas.filter { it.claveMateria == claveMateria }

    fun obtenerPreguntas(claveMateria: String, claveTema: String): List<Pregunta> =
        preguntas.filter { it.claveMateria == claveMateria && it.claveTema == claveTema }

    fun obtenerPreguntaPorId(preguntaId: Int): Pregunta? {
        return preguntas.find { it.id == preguntaId }
    }


    private val materias = listOf(
        Materia(1, "MAT", "Matemáticas", "matematicas.png"),
        Materia(2, "FIS", "Física", "fisica.png"),
        Materia(3, "QUI", "Química", "quimica.png"),
        Materia(4, "BIO", "Biología", "biologia.png"),
        Materia(5, "HIS", "Historia", "historia.png"),
        Materia(6, "GEO", "Geografía", "geografia.png"),
        Materia(7, "ESP", "Español", "espanol.png"),
        Materia(8, "FIL", "Filosofía", "filosofia.png"),
        Materia(9, "ING", "Inglés", "ingles.png")
    )

    private val temas = listOf(

        // Matemáticas
        Tema(1, "ALG", "MAT", "Álgebra", "algebra.png"),
        Tema(2, "GEO", "MAT", "Geometría", "geometria.png"),
        Tema(3, "TRIG", "MAT", "Trigonometría", "trigonometria.png"),
        Tema(4, "CALC", "MAT", "Cálculo", "calculo.png"),

        // Física
        Tema(5, "MOV", "FIS", "Movimiento", "movimiento.png"),
        Tema(6, "FOR", "FIS", "Fuerza", "fuerza.png"),
        Tema(7, "ENE", "FIS", "Energía", "energia.png"),

        // Química
        Tema(8, "ESTQ", "QUI", "Estequiometría", "estequiometria.png"),
        Tema(9, "GASES", "QUI", "Gases", "gases.png"),
        Tema(10, "SOL", "QUI", "Soluciones", "soluciones.png"),

        // Biología
        Tema(11, "ANAT", "BIO", "Anatomía", "anatomia.png"),
        Tema(12, "ECO", "BIO", "Ecología", "ecologia.png"),
        Tema(13, "GEN", "BIO", "Genética", "genetica.png"),

        // Historia
        Tema(14, "MEX", "HIS", "Historia de México", "historia_mexico.png"),
        Tema(15, "UNI", "HIS", "Historia Universal", "historia_universal.png"),

        // Geografía
        Tema(16, "FISG", "GEO", "Geografía Física", "geografia_fisica.png"),
        Tema(17, "HUMG", "GEO", "Geografía Humana", "geografia_humana.png"),

        // Español
        Tema(18, "GRAM", "ESP", "Gramática", "gramatica.png"),
        Tema(19, "ORTO", "ESP", "Ortografía", "ortografia.png"),
        Tema(20, "COMP", "ESP", "Comprensión de Lectura", "comprension.png"),

        // Filosofía
        Tema(21, "ETI", "FIL", "Ética", "etica.png"),
        Tema(22, "LOG", "FIL", "Lógica", "logica.png"),

        // Inglés
        Tema(23, "GRAMI", "ING", "Gramática en Inglés", "gramatica_ingles.png"),
        Tema(24, "VOCAB", "ING", "Vocabulario", "vocabulario.png"),
        Tema(25, "READ", "ING", "Reading", "reading.png")
    )

    private val preguntas = listOf(
        // Matemáticas - Álgebra
        Pregunta(1, "ALG_1", "MAT", "ALG", "¿Cuál es el resultado de (x + 3)(x - 3)?",
            "x² - 9", "x² + 6x + 9", "x² - 6x + 9", "x² + 9", "A", null),

        Pregunta(2, "ALG_2", "MAT", "ALG", "¿Cuánto vale x en la ecuación 2x + 5 = 15?",
            "5", "10", "15", "20", "A", null),

        // Matemáticas - Geometría
        Pregunta(3, "GEO_1", "MAT", "GEO", "Si un triángulo tiene ángulos de 45° y 90°, ¿cuánto mide el tercer ángulo?",
            "90°", "60°", "45°", "75°", "45°", null),

        // Física - Movimiento
        Pregunta(4, "MOV_1", "FIS", "MOV", "Si un auto viaja a 60 km/h durante 2 horas, ¿qué distancia recorre?",
            "30 km", "60 km", "120 km", "90 km", "120 km", null),

        // Química - Gases
        Pregunta(5, "GASES_1", "QUI", "GASES", "¿Cuál es la ecuación de estado de los gases ideales?",
            "PV = nRT", "E = mc²", "F = ma", "Q = mcΔT", "PV = nRT", null),

        // Biología - Genética
        Pregunta(6, "GEN_1", "BIO", "GEN", "¿Quién es considerado el padre de la genética?",
            "Darwin", "Mendel", "Lamarck", "Watson", "Mendel", null),

        // Historia - Historia de México
        Pregunta(7, "MEX_1", "HIS", "MEX", "¿En qué año ocurrió la Independencia de México?",
            "1810", "1821", "1910", "1857", "1810", null),

        // Geografía - Geografía Física
        Pregunta(8, "FISG_1", "GEO", "FISG", "¿Cuál es el río más largo del mundo?",
            "Amazonas", "Nilo", "Mississippi", "Yangtsé", "Amazonas", null),

        // Español - Ortografía
        Pregunta(9, "ORTO_1", "ESP", "ORTO", "¿Cuál es la forma correcta?",
            "Halla", "Haya", "Aya", "Allá", "Haya", null),

        // Filosofía - Lógica
        Pregunta(10, "LOG_1", "FIL", "LOG", "¿Cuál es la base de un argumento lógico?",
            "Premisas", "Conclusión", "Ejemplos", "Suposiciones", "Premisas", null),

        // Inglés - Gramática
        Pregunta(11, "GRAMI_1", "ING", "GRAMI", "What is the correct past tense of 'go'?",
            "Goed", "Went", "Goes", "Going", "Went", null)
    )

}