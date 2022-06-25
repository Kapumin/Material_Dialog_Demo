package com.abjt.materialdialogdemo

const val MATERIAL_DIALOG_TITLE = "material_dialog_title"
const val MATERIAL_DIALOG_MESSAGE = "material_dialog_message"
const val MATERIAL_DIALOG_POSITIVE_LABEL = "material_dialog_positive_button_label"
const val MATERIAL_DIALOG_NEGATIVE_LABEL = "material_dialog_negative_button_label"
const val MATERIAL_DIALOG_LIST_ITEMS = "material_dialog_list_items"


const val DIALOG_HOST_FRAGMENT_TAG = "dialog_host_fragment_tag"
const val LIST_MATERIAL_DIALOG_TAG = "list_material_dialog"
const val ACTION_MATERIAL_DIALOG_TAG = "action_material_dialog"

const val REQUEST_KEY_SINGLE_CHOICE_LIST = "request_key_single_choice_list_dialog"
const val REQUEST_KEY_MULTIPLE_CHOICE_LIST = "request_key_multiple_choice__list_dialog"
const val REQUEST_KEY_ACTION_DIALOG = "request_key_action_button_dialog"

const val CLICKED_INDEX = "clicked_index"
const val CLICKED_LIST_ITEM = "clicked_list_item"
const val CLICKED_ACTION_BUTTON = "clicked_action_button"


enum class MaterialDialogType(val requestKey: String) {
    SINGLE_CHOICE_LIST(REQUEST_KEY_SINGLE_CHOICE_LIST),
    MULTIPLE_CHOICE_LIST(REQUEST_KEY_MULTIPLE_CHOICE_LIST),
    ACTION_BUTTON(REQUEST_KEY_ACTION_DIALOG),
}
