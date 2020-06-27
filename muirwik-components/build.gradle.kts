import java.io.FileInputStream
import java.util.*

version = "0.5.1-1.4-M2"
description = "Muirwik Components - a Material UI React wrapper written in Kotlin"

plugins {
    kotlin("js")
}

repositories {
    jcenter()
    maven(url = "https://kotlin.bintray.com/kotlinx")
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

dependencies {
    val kotlinVersion = "1.4-M2"
    val kotlinJsVersion = "pre.107-kotlin-$kotlinVersion"
    val kotlinReactVersion = "16.13.1-$kotlinJsVersion"

    implementation(kotlin("stdlib-js", kotlinVersion))
    implementation("org.jetbrains", "kotlin-react", kotlinReactVersion)
    implementation("org.jetbrains", "kotlin-react-dom", kotlinReactVersion)
    implementation("org.jetbrains", "kotlin-styled", "1.0.0-$kotlinJsVersion")

    implementation("org.jetbrains.kotlinx", "kotlinx-html-js", "0.7.1-$kotlinVersion")

    // We don't have peer dependencies and projects using this project via gradle fail to run
    // if we have the dependencies listed below...
    // So, the user of this project needs to include the material-ui dependencies themselves
    // and be careful to select the correct version!
//    implementation(npm("@material-ui/core", "^4.9.14"))
//    implementation(npm("@material-ui/icons", "^4.9.1"))
}


kotlin {
    js {
        useCommonJs()
        nodejs {
        }
    }
}

// TODO: Look at javadoc/kdoc/dokka
//val dokka: DokkaTask by tasks
//tasks.register<Jar>("KDocJar") {
//    from(tasks.javadoc)
//    classifier = "javadoc"
//    from(tasks.dokka)
//}


