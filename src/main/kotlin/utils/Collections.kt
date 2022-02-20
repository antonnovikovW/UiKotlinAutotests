package utils

import kotlin.reflect.KClass

inline fun <reified R> Iterable<KClass<*>>.firstInstanceOf(): Int {
    for ((index, item) in this.withIndex()) {
        if (item == R::class)
            return index
    }
    throw NoSuchElementException("Element [${R::class.simpleName}] not found")
}