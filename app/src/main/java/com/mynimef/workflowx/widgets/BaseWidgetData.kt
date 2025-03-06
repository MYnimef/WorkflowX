package com.mynimef.workflowx.widgets

import android.os.Parcelable
import com.mynimef.workflowx.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowx.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowx.widgets.slider.SliderWidgetData
import com.mynimef.workflowx.widgets.subscribe.SubscribeWidgetData
import com.mynimef.workflowx.widgets.visibilitycolumn.VisibilityColumnWidgetData
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * Базовый интерфейс данных виджета
 */
@Serializable(with = BaseWidgetData.Serializer::class)
interface BaseWidgetData : Parcelable {

    /** Уникальный в рамках одного экрана идентификатор виджета */
    val id: String

    /** Тип виджета */
    val type: String

    // временное решение
    fun findWidgetById(id: String): BaseWidgetData? = if (this.id == id) this else null

    // временное решение
    fun replaceWidgetById(id: String, widget: BaseWidgetData) = if (this.id == id) widget else this

    object Serializer : KSerializer<BaseWidgetData> {

        private val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
            prettyPrint = true
            coerceInputValues = true
        }

        override val descriptor: SerialDescriptor
            get() = PolymorphicSerializer(BaseWidgetData::class).descriptor

        override fun serialize(encoder: Encoder, value: BaseWidgetData) {}

        override fun deserialize(decoder: Decoder): BaseWidgetData {
            val jsonElement = (decoder as JsonDecoder).decodeJsonElement()
            return when (val itemType = jsonElement.jsonObject["type"]?.jsonPrimitive?.content) {
                ModuleColumnWidgetData.TYPE -> json.decodeFromJsonElement(ModuleColumnWidgetData.serializer(), jsonElement)
                MultilineTextWidgetData.TYPE -> json.decodeFromJsonElement(MultilineTextWidgetData.serializer(), jsonElement)
                SliderWidgetData.TYPE -> json.decodeFromJsonElement(SliderWidgetData.serializer(), jsonElement)
                SubscribeWidgetData.TYPE -> json.decodeFromJsonElement(SubscribeWidgetData.serializer(), jsonElement)
                VisibilityColumnWidgetData.TYPE -> json.decodeFromJsonElement(VisibilityColumnWidgetData.serializer(), jsonElement)
                else -> throw SerializationException("Unknown itemType: $itemType")
            }
        }

    }

}