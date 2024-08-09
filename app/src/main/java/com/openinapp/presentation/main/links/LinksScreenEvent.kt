package com.openinapp.presentation.main.links

sealed class LinksScreenEvent {
    data object OnDismissError: LinksScreenEvent()
}