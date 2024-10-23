package com.example.a511lasalleappp.utils

import com.example.a511lasalleappp.models.Community
import com.example.a511lasalleappp.models.Materia
import com.example.a511lasalleappp.models.News
import com.example.a511lasalleappp.models.Pago

val newsList = listOf(
    News(
        id = 1,
        title = "Evento de Construcción de la Paz",
        description = "La Salle Bajío realiza un foro para fomentar la construcción de la paz en la comunidad estudiantil.",
        image =  "https://www.lasallebajio.edu.mx/noticias/images/4701_1.jpg"
    ),
    News(
        id = 2,
        title = "Conferencia de Liderazgo",
        description = "Una conferencia que destaca la importancia del liderazgo en la comunidad universitaria.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_2.jpg"
    ),
    News(
        id = 3,
        title = "Semana Cultural 2024",
        description = "Celebración anual de la Semana Cultural con diversas actividades artísticas y deportivas.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_3.jpg"
    )
)

val communities = listOf(
    Community(1,"https://www.lasallebajio.edu.mx/comunidad/images/tile_documentos_inspiradores.jpg"),
    Community(2,"https://www.lasallebajio.edu.mx/comunidad/images/tile_boletin.jpg"),
    Community(3,"https://www.lasallebajio.edu.mx/comunidad/images/tile_cat_souv_22.jpg  "),
    Community(4,"https://www.lasallebajio.edu.mx/comunidad/images/tile_tramites.jpg"),
    Community(5,"https://www.lasallebajio.edu.mx/comunidad/images/tile_blog.jpg"),
)
val materias = listOf(
    Materia(1, "Literatura", 9.6, 10.0, 10.0, 10.0),
    Materia(2, "Quimica", 9.8, 10.0, 9.5, 10.0),
    Materia(3, "Economía", 5.0, 5.0, 5.0, 5.0),
    Materia(4, "Geografia", 9.7, 9.9, 9.8, 10.0),
    Materia(5, "Sociología", 6.9, 6.4, 8.1, 8.0)
)

val pagos = listOf(
    Pago(false, "Noviembre", 2024, 10333.00),
    Pago(false, "Octubre", 2024, 10333.00),
    Pago(false, "Septiembre", 2024, 10333.00),
    Pago(true, "Agosto", 2024, 10333.00),
    Pago(true, "Julio", 2024, 10333.00)
)