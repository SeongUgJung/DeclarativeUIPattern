rootProject.name = "DeclarativeUIPattern"

include("sample-app")
include("view-component")


val modules = hashMapOf<String, String>()

rootProject.projectDir.listFiles().forEach {
    findSubProjects(it, modules)
}

fun findSubProjects(file: File,  map: Map<String, String>) {
    if (file.name.startsWith(".")) {
        return
    }

    if (file.name == "build.gradle.kts" || file.name == "build.gradle") {
        modules[file.parentFile.name] = file.parentFile.path
        return
    }

    if (file.isDirectory) {
        file.listFiles().forEach {
            findSubProjects(it, modules)
        }
    }
}

for (project in rootProject.children) {

    if (modules.containsKey(project.name)) {
        val directory = modules[project.name]
        project.projectDir = File(directory)
    }
}