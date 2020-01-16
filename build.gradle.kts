allprojects {
    group = "com.ccfraser.muirwik"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
    }
}

plugins {
    kotlin("multiplatform") version "1.3.70-eap-42" apply false
    base
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}