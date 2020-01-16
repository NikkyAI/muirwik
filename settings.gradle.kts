pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://jcenter.bintray.com/")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

enableFeaturePreview("GRADLE_METADATA")

rootProject.name = "muirwik"
include("muirwik-components")
//include("muirwik-testap"')

