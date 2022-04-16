package com.dsb.sports.models

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope

class SportSaver : Saver<Sport, String> {
    companion object {
        private const val SEPARATOR = "|&|"
    }

    override fun restore(value: String): Sport? {
        return try {
            val list = value.split(SEPARATOR)
            Sport(list[0], list[1])
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

    override fun SaverScope.save(value: Sport): String {
        return "${value.name}$SEPARATOR${value.description}"
    }

}
