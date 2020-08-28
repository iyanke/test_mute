import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    buildType(TestConfig)
    buildType(TestConfig2)
    buildType(TestConfig3)
}

object TestConfig : BuildType({
    name = "Test config"

    steps {
        script {
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.XXX']"
                echo "##teamcity[testFailed name='MyTest.XXX' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.test3']"
                echo "##teamcity[testFailed name='MyTest.test3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test3']"
                
                echo "##teamcity[testStarted name='MyTest.test3']"
                echo "##teamcity[testFinished name='MyTest.test3']"
                
                echo "##teamcity[testStarted name='MyTest.test4']"
                echo "##teamcity[testFailed name='MyTest.test4' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test4']"
                
                echo "##teamcity[testStarted name='MyTest.test4']"
                echo "##teamcity[testFinished name='MyTest.test4']"
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFailed name='MyTest.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test5']"
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFinished name='MyTest.test5']"
            """.trimIndent()
        }
        script {
            name = "Wait"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "ping 127.0.0.1 -n 60 > nul"
        }
        script {
            name = "New build step"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                
                
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            name = "XXX"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest.XXX']"
                echo "##teamcity[testFinished name='MyTest.XXX']"
                
                echo "##teamcity[testStarted name='MyTest.test1']"
                echo "##teamcity[testFailed name='MyTest.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test1']"
                
                
                echo "##teamcity[testStarted name='MyTest.test5']"
                echo "##teamcity[testFailed name='MyTest.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test5']"
            """.trimIndent()
        }
    }

    failureConditions {
    }

    features {
        notifications {
            notifierSettings = emailNotifier {
                email = "inna_yan@mail.ru"
            }
            buildFailed = true
            firstBuildErrorOccurs = true
        }
    }
})

object TestConfig2 : BuildType({
    name = "Test config2"

    steps {
        script {
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                echo "##teamcity[testFailed name='MyTest.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                echo "##teamcity[testStarted name='MyTest.XXX']"
                echo "##teamcity[testFailed name='MyTest.XXX' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest.XXX']"
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                echo "##teamcity[testStarted name='MyTest1.test2']"
                echo "##teamcity[testFailed name='MyTest1.test2' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test2']"
                
                echo "##teamcity[testStarted name='MyTest1.test2']"
                echo "##teamcity[testFinished name='MyTest1.test2']"
                
                echo "##teamcity[testStarted name='MyTest1.test3']"
                echo "##teamcity[testFailed name='MyTest1.test3' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test3']"
                
                echo "##teamcity[testStarted name='MyTest1.test3']"
                echo "##teamcity[testFinished name='MyTest1.test3']"
                
                echo "##teamcity[testStarted name='MyTest1.test4']"
                echo "##teamcity[testFailed name='MyTest1.test4' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test4']"
                
                echo "##teamcity[testStarted name='MyTest1.test4']"
                echo "##teamcity[testFinished name='MyTest1.test4']"
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFailed name='MyTest1.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
            """.trimIndent()
        }
        script {
            name = "Wait"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = "ping 127.0.0.1 -n 60 > nul"
        }
        script {
            name = "New build step"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testSuiteStarted name='suiteName']"
                
                echo "##teamcity[testStarted name='MyTest.test2']"
                
                
                echo "##teamcity[testFinished name='MyTest.test2']"
                
                
                
                echo "##teamcity[testSuiteFinished name='suiteName']"
            """.trimIndent()
        }
        script {
            name = "XXX"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            scriptContent = """
                echo "##teamcity[testStarted name='MyTest1.XXX']"
                echo "##teamcity[testFinished name='MyTest1.XXX']"
                
                echo "##teamcity[testStarted name='MyTest1.test1']"
                echo "##teamcity[testFailed name='MyTest1.test1' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test1']"
                
                
                echo "##teamcity[testStarted name='MyTest1.test5']"
                echo "##teamcity[testFailed name='MyTest1.test5' message='failure message' details='message and stack trace']"
                echo "##teamcity[testFinished name='MyTest1.test5']"
            """.trimIndent()
        }
    }

    failureConditions {
        supportTestRetry = true
    }

    features {
        notifications {
            notifierSettings = emailNotifier {
                email = "inna_yan@mail.ru"
            }
            buildFailed = true
            firstBuildErrorOccurs = true
        }
    }
})

object TestConfig3 : BuildType({
    name = "Test config3"

    failureConditions {
        javaCrash = false
        supportTestRetry = true
    }
})
