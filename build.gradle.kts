import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.detekt)
}

allprojects {
    val libs = rootProject.libs
    apply(plugin = libs.plugins.detekt.get().pluginId)

    detekt {
        parallel = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
    }

    dependencies {
        detektPlugins(libs.detekt.formatting)
        detektPlugins(libs.detekt.rules.libraries)
        detektPlugins(libs.detekt.rules.ruleauthors)
    }

    tasks {
        fun SourceTask.config() {
            setSource(files(project.projectDir))

            exclude(".gradle/caches/**") // не нужно анализировать gradle кеш

            exclude("**/*.kts")
            exclude("**/build/**")
            exclude("**/resources/**")
            exclude("**/generated/**")
        }
        
        withType<DetektCreateBaselineTask>().configureEach {
            config()
        }
        withType<Detekt>().configureEach {
            config()
        }
    }
}

true // Needed to make the Suppress annotation work for the plugins block