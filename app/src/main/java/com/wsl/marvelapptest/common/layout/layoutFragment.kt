package com.wsl.marvelapptest.common.layout

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class LayoutFragment(val layoutId: Int, val title: Int = 0)