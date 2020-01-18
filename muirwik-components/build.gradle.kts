plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

version = "0.4.1-dev"
description = "Muirwik Components - a Material UI React wrapper written in Kotlin"

//plugins {
//    java // Not sure why this is needed, but it makes the dependencies below work.
//    id("com.jfrog.bintray") version "1.8.4"
//}

repositories {
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://dl.bintray.com/kotlin/kotlin-dev")
    maven("https://dl.bintray.com/kotlin/kotlin-js-wrappers")
}


kotlin {
    js {
        useCommonJs()
        browser {
            runTask {
                sourceMaps = true
            }
            webpackTask {
                sourceMaps = true
            }
        }
        compilations.all {
            kotlinOptions {
                sourceMap = true
                metaInfo = true
//                outputFile = "${project.buildDir.path}/js/muirwik-components.js"
                main = "call"
//                moduleKind = "commonjs"
            }
        }
//        val sourcesJar = tasks.register<Jar>("sourcesJar") {
//            from((sourceSets.getByName("main") as SourceSet).allSource)
//            archiveClassifier.set("sources")
//        }

        mavenPublication { // Setup the publication for the target
            // The default artifactId was 'foo-jvm6', change it:
            artifactId = "muirwik-components"
            // Add a docs JAR artifact (it should be a custom task):
//            artifact(sourcesJar)
        }
    }


    sourceSets {
        js().compilations["main"].apply {

        }
        js().compilations["main"].defaultSourceSet {
            dependencies {
                val kotlinWrappersVersion = "pre.89-kotlin-1.3.60"
                val kotlinReactVersion = "16.9.0-$kotlinWrappersVersion"

                implementation(kotlin("stdlib-js"))

                api("org.jetbrains:kotlin-react:$kotlinReactVersion")
                api("org.jetbrains:kotlin-react-dom:$kotlinReactVersion")
                api("org.jetbrains:kotlin-styled:1.0.0-$kotlinWrappersVersion")

                api(npm("react", "^16.9.0"))
                api(npm("react-dom", "^16.9.0"))
                api(npm("inline-style-prefixer", "^5.1.0"))
//    api(npm("core-js", "^3.4.7"))
                api(npm("styled-components", "^4.4.1"))
                api(npm("@material-ui/core", "^4.8.3"))
                api(npm("@material-ui/icons", "^4.5.1"))
            }
            kotlin.srcDir(project.file("src/main/kotlin"))
        }
    }
}

//val sourcesJar = tasks.register<Jar>("sourcesJar") {
//    group = "build"
//    from(kotlin.target {sourceSets.getByName("main") })
//    archiveClassifier.set("sources")
//}

// TODO: Look at javadoc/kdoc/dokka
//val dokka: DokkaTask by tasks
//tasks.register<Jar>("KDocJar") {
//    from(tasks.javadoc)
//    classifier = "javadoc"
//    from(tasks.dokka)
//}

//val publicationName = "mavenJava"
publishing {
    repositories {
        mavenLocal()
    }

    publications {
        publications.withType<MavenPublication>().apply {
//            val js by getting { /* Setup the publication for target 'jvm6' */ }
        }
//        create<MavenPublication>(publicationName) {
////            components
////            from(components["java"]) // TODO find existing components
////            artifact(tasks["KDocJar"])
////            artifact(tasks["sourcesJar"])
//
//            pom {
//                name.set("Muirwik Components")
//                description.set(project.description)
//                url.set("https://github.com/cfnz/muirwik")
//                licenses {
//                    license {
//                        name.set("Mozilla Public License 2.0")
//                    }
//                }
//                scm {
//                    connection.set("https://github.com/cfnz/muirwik.git")
//                    url.set("https://github.com/cfnz/muirwik")
//                }
//            }
//        }
    }
}

//bintray {
//    // Bintray keys are kept in a local, non version controlled, properties file
//    if (project.file("local.properties").exists()) {
//        val properties = Properties()
//        properties.load(FileInputStream(project.file("local.properties")))
//        fun findProperty(propertyName: String) = properties[propertyName] as String?
//
//        user = findProperty("bintray.user")
//        key = findProperty("bintray.apikey")
//        publish = true
//        override = true
//
//        pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
//            // Mandatory fields
//            repo = project.parent?.name
//            name = "${project.group}:${project.name}"
//            setLicenses("MPL-2.0")
//            vcsUrl = "https://github.com/cfnz/muirwik"
//
//            // Some optional fields
//            description = project.description
//            desc = description
//            websiteUrl = "https://github.com/cfnz/muirwik"
//            issueTrackerUrl = "https://github.com/cfnz/muirwik/issues"
//            githubRepo = "https://github.com/cfnz/muirwik"
//            setLabels("kotlin", "material-ui", "react")
//        })
//        setPublications(publicationName)
//    }
//}