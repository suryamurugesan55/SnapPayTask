buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}