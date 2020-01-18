package com.ccfraser.muirwik.components.button

import com.ccfraser.muirwik.components.*
import kotlinx.html.ButtonType
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler


@JsModule("@material-ui/core/Button")
private external val buttonModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val buttonComponent: RComponent<MButtonProps, RState> = buttonModule.default


interface MButtonProps : MButtonBaseProps {
    var disableFocusRipple: Boolean
    var fullWidth: Boolean
    var href: String
}
var MButtonProps.color by EnumPropToStringNullable(MColor.values())
var MButtonProps.size by EnumPropToString(MButtonSize.values())
var MButtonProps.variant by EnumPropToStringNullable(MButtonVariant.values())
var MButtonProps.type by EnumPropToString(ButtonType.values())


//Setting the color and variant to the default values seems to upset button groups... the buttons don't inherit the
//groups color or variant, even if color is default... so allowing color and variant to default to null which seems
//to fix the issue and does not cause any issues
fun RBuilder.mButton(
        caption: String,
        color: MColor? = null,
        variant: MButtonVariant? = null,
        disabled: Boolean = false,
        onClick: ((Event) -> Unit)? = null,
        size: MButtonSize = MButtonSize.medium,
        hRefOptions: HRefOptions? = null,
        type: ButtonType = ButtonType.button,

        addAsChild: Boolean = true,
        className: String? = null,
        handler: StyledHandler<MButtonProps>? = null) = createStyled(buttonComponent, addAsChild) {
    attrs.color = color
    attrs.disabled = disabled
    hRefOptions?.let { setHRefTargetNoOpener(attrs, it) }
    onClick?.let { attrs.onClick = onClick }
    attrs.size = size
    attrs.variant = variant
    attrs.type = type

    childList.add(caption)

    setStyledPropsAndRunHandler(className, handler)
}

