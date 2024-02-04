package com.arbuss.ui.theme

import androidx.compose.ui.graphics.Color

object Colors {
    object Text {
        object Light {
            val Primary = Color(0xFF1D2023) // Заголовки и основной текст.
            val Secondary = Color(0xFF626C77) // Дополнительный текст.
            val Tertiary =
                Color(0xFF969FA8) // Третичный текст. Используется только в начертаниях медиум и выше. Исключение — маска в полях (например, ввод телефона и даты).
            val Inverted = Color(0xFFFAFAFA) // Текст для тултипа, тоста и снэкбара.
            val Positive = Color(0xFF12B23F) // Текст успешных действий.
            val Negative = Color(0xFFD8400C) // Текст ошибки и негативных действий.
            val PrimaryLink = Color(0xFF0070E5) // Основные ссылки.
            val VisitedLink = Color(0xFF883888) // Посещенные ссылки.
            val PrimaryLinkInverted = Color(0xFF45B6FC) // Основные ссылки на инвертированном бэкграунде.
            val SecondaryLink = Color(0xFF626C77) // Второстепенные ссылки
            val InactiveTabbar = Color(0xFF6E7780) // Цвет текста в неактивном пункте таббара.
        }

        object Dark {
            val Primary = Color(0xFFFAFAFA)
            val Secondary = Color(0xFF969FA8)
            val Tertiary = Color(0xFF626C77)
            val Inverted = Color(0xFF1D2023)
            val Positive = Color(0xFF74DF8B)
            val Negative = Color(0xFFFFA080)
            val PrimaryLink = Color(0xFF45B6FC)
            val VisitedLink = Color(0xFFB767B7)
            val PrimaryLinkInverted = Color(0xFF0070E5)
            val SecondaryLink = Color(0xFF969FA8)
            val InactiveTabbar = Color(0xFFFFFFFF)
        }
    }

    object Background {
        object Light {
            val Primary = Color(0xFFFFFFFF) // Основной фон темы.
            val PrimaryElevated = Color(0xFFFFFFFF) // Первый уровень над фоном: карточки, инпут, таббар.
            val Modal = Color(0xFFFFFFFF) // Второй уровень над фоном, например, выпадающие меню и шторки.
            val Stroke = Color(0x80BCC3D0) // Сепараторы и обводки.
            val Secondary = Color(0xFFF2F3F7) // Второстепенный фон темы.
            val SecondaryElevated = Color(0xFFFFFFFF) // Тот же первый уровень, но над Secondary Background.
            val Overlay = Color(0x661D2023) // Затемнение фона. Можно использовать совместно с Blur 50.
            val Inverted = Color(0xFF1D2023) // Фон тултипа, тоста и снэкбара.
            val Hover = Color(0x40BCC3D0) // Ховер. Используется над фоном элемента, но под его контентом.
            val Bar = Color(0xE0FFFFFF) // Навбар и таббар G2.0. Использовать только совместно с Blur 40.
            val Disabled = Color(0xFFF8F8FB) // Цвет фона для неактивных инпута, дропдауна, текстареа.
            val StrokeDisabled = Color(0x40BCC3D0) // Цвет обводки фона для неактивных инпута, дропдауна, текстареа.
            val Lower = Color(0xFFF2F3F7) // Альтернативный основной фон темы.
        }

        object Dark {
            val Primary = Color(0xFF000000)
            val PrimaryElevated = Color(0xFF1D2023)
            val Modal = Color(0xFF2C3135)
            val Stroke = Color(0x597F8C99)
            val Secondary = Color(0x40626C77)
            val SecondaryElevated = Color(0x40626C77)
            val Overlay = Color(0xE61D2023)
            val Inverted = Color(0xFFFFFFFF)
            val Hover = Color(0xCCF2F3F7)
            val Bar = Color(0x4D000000)
            val Disabled = Color(0xD9626C77)
            val StrokeDisabled = Color(0xE67F8C99)
            val Lower = Color(0xFF000000)
        }
    }

    object Icons {
        object Light {
            val Primary = Color(0xFF1D2023) // Цвет иконок в навбаре и второстепенных кнопках.
            val Secondary = Color(0xFF8D969F) // Цвет интерактивных иконок.
            val Tertiary = Color(0xFFBBC1C7) // Цвет декоративных иконок.
        }

        object Dark {
            val Primary = Color(0xFFFAFAFA)
            val Secondary = Color(0xFF969FA8)
            val Tertiary = Color(0xFF626C77)
        }
    }

    object Buttons {
        object Light {
            val Primary = Color(0xFF26CD58) // Основной цвет позитивной кнопки.
            val Secondary = Color(0xFF007CFF) // Второй цвет позитивной кнопки.
            val Negative = Color(0xFFF95721) // Основной цвет негативной кнопки.
        }

        object Dark {
            val Primary = Color(0xFF74DF8B)
            val Secondary = Color(0xFF45B6FC)
            val Negative = Color(0xFFFA8A64)
        }
    }
}


val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)