package com.mynimef.workflowxcore

import kotlinx.serialization.KSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlin.reflect.KClass

class DynamicSerializersModuleBuilder {

    private val moduleConfigurations = mutableListOf<SerializersModuleBuilder.() -> Unit>()

    fun <B: Any, T : B> registerPolymorphic(
        baseClass: KClass<B>,
        actualClass: KClass<T>,
        serializer: KSerializer<T>
    ) {
        moduleConfigurations.add {
            polymorphic(
                baseClass = baseClass,
                actualClass = actualClass,
                actualSerializer = serializer
            )
        }
    }

    fun build(): SerializersModule {
        return SerializersModule {
            moduleConfigurations.forEach { it.invoke(this) }
        }
    }

}