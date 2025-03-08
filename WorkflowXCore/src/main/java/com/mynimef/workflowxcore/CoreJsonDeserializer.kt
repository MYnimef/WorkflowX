package com.mynimef.workflowxcore

import com.mynimef.workflowxcore.widgets.CoreWidgetData
import com.mynimef.workflowxcore.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowxcore.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowxcore.widgets.slider.SliderWidgetData
import com.mynimef.workflowxcore.widgets.spacer.SpacerWidgetData
import com.mynimef.workflowxcore.widgets.subscribe.SubscribeWidgetData
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * Фабрика для создания composable функций с провайдером данных
 */
open class CoreJsonDeserializer {

    protected val moduleBuilder = DynamicSerializersModuleBuilder()

    init {
        register<ModuleColumnWidgetData>()
        register<MultilineTextWidgetData>()
        register<SliderWidgetData>()
        register<SpacerWidgetData>()
        register<SubscribeWidgetData>()
    }

    protected inline fun <reified T : CoreWidgetData> register() {
        moduleBuilder.registerPolymorphic(
            baseClass = CoreWidgetData::class,
            actualClass = T::class,
            serializer = serializer<T>()
        )
    }

    val json: Json by lazy { Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
        prettyPrint = true
        coerceInputValues = true

        serializersModule = moduleBuilder.build()
        classDiscriminator = "type"
    } }

    inline fun <reified T> deserialize(input: String): T {
        return json.decodeFromString(input)
    }

}