// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    repositories {
//        maven {
//            setUrl("https://nxs.sigma-it.ru/repository/public/")
//        }
//    }
//}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    id ("com.google.dagger.hilt.android") version "2.52" apply false
//    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}