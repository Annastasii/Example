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
}

rootProject.name = "PET"
include(":app")
include(":auth")
include(":auth:feature_auth")
include(":core_ui")
include(":core_navigation")
include(":message")
include(":message:feature_message")
include(":profile")
include(":profile:feature_profile")
include(":core_data")
include(":core_data:core_database")
include(":core_data:core_network")
include(":auth:core_auth")
include(":auth:core_auth:core_auth_api")
