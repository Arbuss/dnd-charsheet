package com.arbuss.data.model.character

import com.arbuss.data.model.exception.LevelOutOfBoundsException

enum class CharacterLevel(val range: IntRange, val proficiencyBonus: Int) {
    LEVEL_1(CharacterLevelConstants.LEVEL_1_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_1),
    LEVEL_2(CharacterLevelConstants.LEVEL_2_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_1),
    LEVEL_3(CharacterLevelConstants.LEVEL_3_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_1),
    LEVEL_4(CharacterLevelConstants.LEVEL_4_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_1),
    LEVEL_5(CharacterLevelConstants.LEVEL_5_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_2),
    LEVEL_6(CharacterLevelConstants.LEVEL_6_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_2),
    LEVEL_7(CharacterLevelConstants.LEVEL_7_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_2),
    LEVEL_8(CharacterLevelConstants.LEVEL_8_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_2),
    LEVEL_9(CharacterLevelConstants.LEVEL_9_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_3),
    LEVEL_10(CharacterLevelConstants.LEVEL_10_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_3),
    LEVEL_11(CharacterLevelConstants.LEVEL_11_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_3),
    LEVEL_12(CharacterLevelConstants.LEVEL_12_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_3),
    LEVEL_13(CharacterLevelConstants.LEVEL_13_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_4),
    LEVEL_14(CharacterLevelConstants.LEVEL_14_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_4),
    LEVEL_15(CharacterLevelConstants.LEVEL_15_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_4),
    LEVEL_16(CharacterLevelConstants.LEVEL_16_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_4),
    LEVEL_17(CharacterLevelConstants.LEVEL_17_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_5),
    LEVEL_18(CharacterLevelConstants.LEVEL_18_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_5),
    LEVEL_19(CharacterLevelConstants.LEVEL_19_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_5),
    LEVEL_20(CharacterLevelConstants.LEVEL_20_RANGE, CharacterLevelConstants.PROFICIENCY_BONUS_5);

    val levelAsInt: Int = ordinal + 1

    val nextLevelAsInt: Int = if (levelAsInt == CharacterLevelConstants.MAX_LEVEL) {
        CharacterLevelConstants.MAX_LEVEL
    } else {
        levelAsInt + 1
    }

    val maxExp: Int = if (levelAsInt == CharacterLevelConstants.MAX_LEVEL) {
        CharacterLevelConstants.MAX_EXP
    } else {
        range.last + 1
    }

    companion object {
        fun fromLevel(level: Int): CharacterLevel {
            val levelRange: IntRange =
                CharacterLevelConstants.MIN_LEVEL..CharacterLevelConstants.MAX_LEVEL
            if (!levelRange.contains(level)) {
                throw LevelOutOfBoundsException("level $level out of range($levelRange)")
            }
            return entries[level - 1]
        }

        @Suppress("CyclomaticComplexMethod")
        fun fromExperience(experience: Int): CharacterLevel {
            return when (experience) {
                in CharacterLevelConstants.LEVEL_1_RANGE -> LEVEL_1
                in CharacterLevelConstants.LEVEL_2_RANGE -> LEVEL_2
                in CharacterLevelConstants.LEVEL_3_RANGE -> LEVEL_3
                in CharacterLevelConstants.LEVEL_4_RANGE -> LEVEL_4
                in CharacterLevelConstants.LEVEL_5_RANGE -> LEVEL_5
                in CharacterLevelConstants.LEVEL_6_RANGE -> LEVEL_6
                in CharacterLevelConstants.LEVEL_7_RANGE -> LEVEL_7
                in CharacterLevelConstants.LEVEL_8_RANGE -> LEVEL_8
                in CharacterLevelConstants.LEVEL_9_RANGE -> LEVEL_9
                in CharacterLevelConstants.LEVEL_10_RANGE -> LEVEL_10
                in CharacterLevelConstants.LEVEL_11_RANGE -> LEVEL_11
                in CharacterLevelConstants.LEVEL_12_RANGE -> LEVEL_12
                in CharacterLevelConstants.LEVEL_13_RANGE -> LEVEL_13
                in CharacterLevelConstants.LEVEL_14_RANGE -> LEVEL_14
                in CharacterLevelConstants.LEVEL_15_RANGE -> LEVEL_15
                in CharacterLevelConstants.LEVEL_16_RANGE -> LEVEL_16
                in CharacterLevelConstants.LEVEL_17_RANGE -> LEVEL_17
                in CharacterLevelConstants.LEVEL_18_RANGE -> LEVEL_18
                in CharacterLevelConstants.LEVEL_19_RANGE -> LEVEL_19
                in CharacterLevelConstants.LEVEL_20_RANGE -> LEVEL_20
                else -> {
                    throw LevelOutOfBoundsException(
                        "experience $experience out of " +
                                "range(${
                                    CharacterLevelConstants.MIN_EXP..
                                            CharacterLevelConstants.MAX_EXP
                                })"
                    )
                }
            }
        }
    }
}

object CharacterLevelConstants {
    const val MAX_EXP = 355_000
    const val MIN_EXP = 0
    const val MAX_LEVEL = 20
    const val MIN_LEVEL = 1
    internal const val PROFICIENCY_BONUS_1 = 2
    internal const val PROFICIENCY_BONUS_2 = 3
    internal const val PROFICIENCY_BONUS_3 = 4
    internal const val PROFICIENCY_BONUS_4 = 5
    internal const val PROFICIENCY_BONUS_5 = 6

    internal val LEVEL_1_RANGE = MIN_EXP..299
    internal val LEVEL_2_RANGE = 300..899
    internal val LEVEL_3_RANGE = 900..2699
    internal val LEVEL_4_RANGE = 300..899
    internal val LEVEL_5_RANGE = 2700..6499
    internal val LEVEL_6_RANGE = 14000..22999
    internal val LEVEL_7_RANGE = 23000..33999
    internal val LEVEL_8_RANGE = 34000..47999
    internal val LEVEL_9_RANGE = 48000..63999
    internal val LEVEL_10_RANGE = 64000..84999
    internal val LEVEL_11_RANGE = 85000..99_999
    internal val LEVEL_12_RANGE = 100_000..119_999
    internal val LEVEL_13_RANGE = 120_000..139_999
    internal val LEVEL_14_RANGE = 140_000..164_999
    internal val LEVEL_15_RANGE = 165_000..194_999
    internal val LEVEL_16_RANGE = 195_000..224_999
    internal val LEVEL_17_RANGE = 225_000..264_999
    internal val LEVEL_18_RANGE = 265_000..304_999
    internal val LEVEL_19_RANGE = 305_000..354_999
    internal val LEVEL_20_RANGE = 355_000..MAX_EXP
}
