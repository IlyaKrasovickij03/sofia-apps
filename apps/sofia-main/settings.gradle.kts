pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("build-logic/libs.versions.toml"))
        }
    }
}

rootProject.name = "SofiaMain"
include(":app")
include(":core")
include(":feature-categories-screen")
include(":feature-auth-screens")
include(":feature-profile-screen")
include(":build-logic")
