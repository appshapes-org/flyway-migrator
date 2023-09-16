package org.appshapes.flywaymigrator.migrator

import org.appshapes.common.runtime.ApplicationBase
import org.appshapes.common.testing.ExcludeFromGeneratedCoverage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@ExcludeFromGeneratedCoverage
@SpringBootApplication
class Application : ApplicationBase()

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}